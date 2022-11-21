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

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.




        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

    }

    public static OrderListRepository repository(){
        OrderListRepository orderListRepository = OrderApplication.applicationContext.getBean(OrderListRepository.class);
        return orderListRepository;
    }

    public void search(){
        //
    }





}
