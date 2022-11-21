package food.domain;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    
    
    
    private String street;
    
    
    
    private String city;
    
    
    
    private String state;
    
    
    
    private String country;
    
    
    
    private String zipcode;



}

