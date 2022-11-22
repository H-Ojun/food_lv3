package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderSync extends AbstractEvent {

    private Long id;
    private String status;

    public OrderSync(OrderStatus aggregate){
        super(aggregate);
    }
    public OrderSync(){
        super();
    }
}
