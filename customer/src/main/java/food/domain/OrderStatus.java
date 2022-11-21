package food.domain;

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

    private String orderId;
    
    private String status;

    public static OrderStatusRepository repository(){
        OrderStatusRepository orderStatusRepository = CustomerApplication.applicationContext.getBean(OrderStatusRepository.class);
        return orderStatusRepository;
    }

    public static void notify(Picked picked){

        /** Example 1:  new item 
        OrderStatus orderStatus = new OrderStatus();
        repository().save(orderStatus);

        */

        /** Example 2:  finding and process
        
        repository().findById(picked.get???()).ifPresent(orderStatus->{
            
            orderStatus // do something
            repository().save(orderStatus);


         });
        */

        
    }

    public static void notify(OrderAccepted orderAccepted){

        /** Example 1:  new item 
        OrderStatus orderStatus = new OrderStatus();
        repository().save(orderStatus);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderAccepted.get???()).ifPresent(orderStatus->{
            
            orderStatus // do something
            repository().save(orderStatus);


         });
        */

        
    }

    public static void notify(OrderRejected orderRejected){

        /** Example 1:  new item 
        OrderStatus orderStatus = new OrderStatus();
        repository().save(orderStatus);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderRejected.get???()).ifPresent(orderStatus->{
            
            orderStatus // do something
            repository().save(orderStatus);


         });
        */

        
    }

    public static void notify(OrderStarted orderStarted){

        /** Example 1:  new item 
        OrderStatus orderStatus = new OrderStatus();
        repository().save(orderStatus);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderStarted.get???()).ifPresent(orderStatus->{
            
            orderStatus // do something
            repository().save(orderStatus);


         });
        */

        
    }

    public static void notify(OrderFinished orderFinished){

        /** Example 1:  new item 
        OrderStatus orderStatus = new OrderStatus();
        repository().save(orderStatus);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderFinished.get???()).ifPresent(orderStatus->{
            
            orderStatus // do something
            repository().save(orderStatus);


         });
        */

        
    }

    public static void notify(Delivered delivered){

        /** Example 1:  new item 
        OrderStatus orderStatus = new OrderStatus();
        repository().save(orderStatus);

        */

        /** Example 2:  finding and process
        
        repository().findById(delivered.get???()).ifPresent(orderStatus->{
            
            orderStatus // do something
            repository().save(orderStatus);


         });
        */

        
    }

    public static void notify(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        OrderStatus orderStatus = new OrderStatus();
        repository().save(orderStatus);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(orderStatus->{
            
            orderStatus // do something
            repository().save(orderStatus);


         });
        */

        
    }

    public static void notify(OrderPlaced orderPlaced){

        /** Example 1:  new item 
        OrderStatus orderStatus = new OrderStatus();
        repository().save(orderStatus);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(orderStatus->{
            
            orderStatus // do something
            repository().save(orderStatus);


         });
        */

        
    }

    public static void notify(Paid paid){

        /** Example 1:  new item 
        OrderStatus orderStatus = new OrderStatus();
        repository().save(orderStatus);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(orderStatus->{
            
            orderStatus // do something
            repository().save(orderStatus);


         });
        */

        
    }

}
