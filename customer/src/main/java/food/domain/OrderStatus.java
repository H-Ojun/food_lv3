package food.domain;

import food.domain.OrderSync;
import food.CustomerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="OrderStatus_table")
@Data

public class OrderStatus  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String status;

    @PostPersist
    public void onPostPersist(){
        
        OrderSync orderSync = new OrderSync(this);
        orderSync.publishAfterCommit();

    }

    public static OrderStatusRepository repository(){
        OrderStatusRepository orderStatusRepository = CustomerApplication.applicationContext.getBean(OrderStatusRepository.class);
        return orderStatusRepository;
    }

    public static void notify(Picked picked){

        repository().findById(Long.parseLong(picked.getOrderId())).ifPresent(orderStatus->{
            orderStatus.setStatus(picked.getStatus());
            repository().save(orderStatus);
         });

    }

    public static void notify(OrderAccepted orderAccepted){

        repository().findById(Long.parseLong(orderAccepted.getOrderId())).ifPresent(orderStatus->{
            orderStatus.setStatus(orderAccepted.getStatus());
            repository().save(orderStatus);
         });

    }

    public static void notify(OrderRejected orderRejected){

        repository().findById(Long.parseLong(orderRejected.getOrderId())).ifPresent(orderStatus->{
            orderStatus.setStatus(orderRejected.getStatus());
            repository().save(orderStatus);
         });

    }

    public static void notify(OrderStarted orderStarted){

        repository().findById(Long.parseLong(orderStarted.getOrderId())).ifPresent(orderStatus->{
            orderStatus.setStatus(orderStarted.getStatus());
            repository().save(orderStatus);
         });
        
    }

    public static void notify(OrderFinished orderFinished){

        repository().findById(Long.parseLong(orderFinished.getOrderId())).ifPresent(orderStatus->{
            orderStatus.setStatus(orderFinished.getStatus());
            repository().save(orderStatus);
         });

    }

    public static void notify(Delivered delivered){

        repository().findById(Long.parseLong(delivered.getOrderId())).ifPresent(orderStatus->{
            orderStatus.setStatus(delivered.getStatus());
            repository().save(orderStatus);
         });

    }

    public static void notify(OrderCanceled orderCanceled){

        repository().findById(orderCanceled.getId()).ifPresent(orderStatus->{
            orderStatus.setStatus(orderCanceled.getStatus());
            repository().save(orderStatus);
         });

    }

    public static void notify(OrderPlaced orderPlaced){

        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setId(orderPlaced.getId());
        orderStatus.setStatus(orderPlaced.getStatus());

        repository().save(orderStatus);

    }

    public static void notify(Paid paid){

        repository().findById(Long.parseLong(paid.getOrderId())).ifPresent(orderStatus->{
            orderStatus.setStatus("Paid");
            repository().save(orderStatus);
         });

    }

}
