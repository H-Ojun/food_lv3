package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Delivered extends AbstractEvent {

    private Long id;
    private String address;
    private String status;
    private String orderId;

    public Delivered(Delivery aggregate) {
        super(aggregate);
    }

    public Delivered() {
        super();
    }
}
