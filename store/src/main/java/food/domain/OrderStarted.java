package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderStarted extends AbstractEvent {

    private Long id;
    private String status;
    private String orderId;
    private String foodId;
    private String address;

    public OrderStarted(FoodCooking aggregate){
        super(aggregate);
    }
    public OrderStarted(){
        super();
    }
}
