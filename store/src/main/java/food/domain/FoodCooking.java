package food.domain;

import food.domain.OrderFinished;
import food.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="FoodCooking_table")
@Data

public class FoodCooking  {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String orderId;
    
    private String foodId;
    
    private String status;
    
    private String address;

    @PostPersist
    public void onPostPersist(){

        OrderFinished orderFinished = new OrderFinished(this);
        orderFinished.publishAfterCommit();

    }

    public static FoodCookingRepository repository(){
        FoodCookingRepository foodCookingRepository = StoreApplication.applicationContext.getBean(FoodCookingRepository.class);
        return foodCookingRepository;
    }

    public void accept(AcceptCommand acceptCommand){

        if (acceptCommand.getAccept()) {
            OrderAccepted orderAccepted = new OrderAccepted(this);
            orderAccepted.publishAfterCommit();

            setStatus("OrderAccept");
        } else {
            OrderRejected orderRejected = new OrderRejected(this);
            orderRejected.publishAfterCommit();

            setStatus("OrderReject");
        }

    }
    public void start(){
        OrderStarted orderStarted = new OrderStarted(this);
        orderStarted.publishAfterCommit();

    }

    public static void updateStatus(Paid paid){

        repository().findByOrderId(paid.getOrderId()).ifPresent(foodCooking->{
            
            foodCooking.setStatus("Paid");
            repository().save(foodCooking);

         });
        
    }

    public static void updateStatus(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        FoodCooking foodCooking = new FoodCooking();
        repository().save(foodCooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(foodCooking->{
            
            foodCooking // do something
            repository().save(foodCooking);


         });
        */

        
    }

    public static void orderInfo(OrderPlaced orderPlaced){
        
        FoodCooking foodCooking = new FoodCooking();
        foodCooking.setFoodId(orderPlaced.getFoodId());
        foodCooking.setOrderId(String.valueOf(orderPlaced.getId()));
        foodCooking.setAddress(orderPlaced.getAddress());
        foodCooking.setStatus(orderPlaced.getStatus());

        repository().save(foodCooking); 
    }


}
