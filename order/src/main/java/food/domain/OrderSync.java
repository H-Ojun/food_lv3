package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderSync extends AbstractEvent {

    private Long id;
    private String status;
}


