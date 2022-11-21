package food.domain;

import food.domain.Paid;
import food.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Payment_table")
@Data

public class Payment  {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Long id;

    private String orderId;

    @PostPersist
    public void onPostPersist(){

        Paid paid = new Paid(this);
        paid.publishAfterCommit();  // store status update

    }

    public static PaymentRepository repository(){
        PaymentRepository paymentRepository = OrderApplication.applicationContext.getBean(PaymentRepository.class);
        return paymentRepository;
    }

    public static void pay(OrderPlaced orderPlaced){

        // 결제
        Payment payment = new Payment();
        payment.setOrderId(String.valueOf(orderPlaced.getId()));
        repository().save(payment);

    }

    // 주문자의 결제 취소
    public static void cancelPayment(OrderCanceled orderCanceled){

        repository().findByOrderId(orderCanceled.getId()).ifPresent(payment->{
            
            repository().delete(payment);

         });
        
    }

    // 요리사의 주문 취소
    public static void cancelPayment(OrderRejected orderRejected){
        
        repository().findByOrderId(Long.parseLong(orderRejected.getOrderId())).ifPresent(payment->{
            
            repository().delete(payment);

         });
    }


}
