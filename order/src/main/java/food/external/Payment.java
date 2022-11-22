package food.external;

import java.util.Date;
import lombok.Data;

@Data
public class Payment {

    private Long id;
    private String orderId;
    private Boolean cancel;
}
