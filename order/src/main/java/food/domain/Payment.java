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

    public static void cancelPayment(OrderCanceled orderCanceled){

        repository().findByOrderId(orderCanceled.getId()).ifPresent(payment->{
            // 결제 취소
            repository().delete(payment);

         });
        
    }


}
