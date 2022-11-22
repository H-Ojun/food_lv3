package food.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="OnDeliveryInfo_table")
@Data
public class OnDeliveryInfo {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String orderId;
        private String status;
        private String address;


}