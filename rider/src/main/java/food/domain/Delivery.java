package food.domain;

import food.domain.Picked;
import food.domain.Delivered;
import food.RiderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {
 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String address;

    private String status;

    private String orderId;

    @PostPersist
    public void onPostPersist(){


        Picked picked = new Picked(this);
        picked.publishAfterCommit();



        Delivered delivered = new Delivered(this);
        delivered.publishAfterCommit();

    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }




    public static void updateStatus(OrderFinished orderFinished){

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderFinished.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }

    // 주문 취소 (삭제)
    public static void updateStatus(OrderRejected orderRejected){

        /** Example 2:  finding and process
        
        repository().findById(orderRejected.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }

    // 주문 수락 pick 전 정보 추가
    public static void orderInfo(OrderAccepted orderAccepted){

        Delivery delivery = new Delivery();
        delivery.setAddress(orderAccepted.getAddress());
        delivery.setOrderId(orderAccepted.getOrderId());
        delivery.setStatus(orderAccepted.getStatus());

        repository().save(delivery);
        
    }


}
