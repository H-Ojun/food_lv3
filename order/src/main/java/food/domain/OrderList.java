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

        String msg;
        // Get request from OrderStatus
        food.external.OrderStatus orderStatus =
            OrderApplication.applicationContext.getBean(food.external.OrderStatusService.class)
           .getOrderStatus(getId());    // OrderStatus의 id가 OrderId라서 getId()를 보내 객체를 가져옴

        if (orderStatus != null) {
            if ("OrderPlace".equals(orderStatus.getStatus())
            || "Paid".equals(orderStatus.getStatus())
            || "OrderAccept".equals(orderStatus.getStatus())) {
                // 정상 주문 취소
                OrderCanceled orderCanceled = new OrderCanceled(this);
                orderCanceled.publishAfterCommit();
                return;
            } else {
                // 이미 요리 시작 이후의 상태
                msg = "Order Status : " + orderStatus.getStatus();
            }
        } else {
            msg = "Not Found OrderId : " + getId();
        }

        throw new RuntimeException(msg);

    }

    public static OrderListRepository repository(){
        OrderListRepository orderListRepository = OrderApplication.applicationContext.getBean(OrderListRepository.class);
        return orderListRepository;
    }

}
