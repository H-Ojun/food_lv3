package food.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Data
public class CancelPaymentCommand {

        private String orderId;
        private Boolean paid;


}
