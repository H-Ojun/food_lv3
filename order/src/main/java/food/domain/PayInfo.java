package food.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="PayInfo_table")
@Data
public class PayInfo {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String orderId;
        private Boolean cancel;


}