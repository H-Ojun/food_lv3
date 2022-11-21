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


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

    }
    @PreRemove
    public void onPreRemove(){


        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

        // Get request from OrderStatus
        //food.external.OrderStatus orderStatus =
        //    Application.applicationContext.getBean(food.external.OrderStatusService.class)
        //    .getOrderStatus(/** mapping value needed */);

    }

    public static OrderListRepository repository(){
        OrderListRepository orderListRepository = OrderApplication.applicationContext.getBean(OrderListRepository.class);
        return orderListRepository;
    }

    public void search(){
        //
    }





}
