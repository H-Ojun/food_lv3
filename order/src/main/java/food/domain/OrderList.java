package food.domain;

import food.domain.OrderPlaced;
import food.domain.OrderCanceled;
import food.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="OrderList_table")
@Data

public class OrderList  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String foodId;

    private String address;

    private String status;

    private String customerId;

    @PostPersist
    public void onPostPersist(){
        this.status = "OrderPlace";

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove(){

        // Get request from Payment
        food.external.Payment payment =
           OrderApplication.applicationContext.getBean(food.external.PaymentService.class)
           .getPayment(getId());

        if (payment == null) {
            throw new RuntimeException("It's before the payment");
        }

        if (payment.getCancel()) {
            // 이미 취소된 주문
            throw new RuntimeException("It's the payment");
        }

        if ("OrderPlace".equals(status)
        || "Paid".equals(status)
        || "OrderAccept".equals(status)) {
            // 정상 주문 취소
            //Following code causes dependency to external APIs
            // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.
            food.external.CancelPaymentCommand cancelPaymentCommand = new food.external.CancelPaymentCommand();
            cancelPaymentCommand.setCancel(true);
            // mappings goes here
            OrderApplication.applicationContext.getBean(food.external.PaymentService.class)
                .cancelPayment(getId(), cancelPaymentCommand);

            OrderCanceled orderCanceled = new OrderCanceled(this);
            orderCanceled.publishAfterCommit();
        } else {
            // 이미 요리 시작 이후의 상태
            throw new RuntimeException("Order Status : " + status);
        }
    }

    public static OrderListRepository repository(){
        OrderListRepository orderListRepository = OrderApplication.applicationContext.getBean(OrderListRepository.class);
        return orderListRepository;
    }

    public void search(){
        //
    }



    public static void updateStatus(OrderSync orderSync){

        repository().findById(orderSync.getId()).ifPresent(orderList->{
            
            orderList.setStatus(orderSync.getStatus());
            repository().save(orderList);


         });
        
    }

}
