package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderFinished extends AbstractEvent {

    private Long id;
    private String status;
    private String orderId;
    private String foodId;
    private String address;

    public OrderFinished(FoodCooking aggregate){
        super(aggregate);
    }
    public OrderFinished(){
        super();
    }
}
