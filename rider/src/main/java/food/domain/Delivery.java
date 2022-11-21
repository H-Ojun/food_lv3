package food.domain;

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
    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }

    // 배달 출발
    public void pick(){
        if ("OrderFinish".equals(status)) {
            setStatus("Pick");
            Picked picked = new Picked(this);
            picked.publishAfterCommit();
        } else {
            // 요리 안됨
            throw new RuntimeException("Unable to pick up : " + status);
        }
    }

    // 배달 완료
    public void deliveryConfirm(){
        if ("Pick".equals(status)) {
            setStatus("Complete");
            Delivered delivered = new Delivered(this);
            delivered.publishAfterCommit();
        } else {
            // 배달 출발 안함
            throw new RuntimeException("Unable to receive delivery. : " + status);
        }

    }

    // 요리 완료 - pick 가능
    public static void updateStatus(OrderFinished orderFinished){

        repository().findByOrderId(orderFinished.getOrderId()).ifPresent(delivery->{
            
            delivery.setStatus(orderFinished.getStatus());
            repository().save(delivery);

         });
        
    }

    // 주문 취소 (삭제)
    public static void updateStatus(OrderRejected orderRejected){

        repository().findByOrderId(orderRejected.getOrderId()).ifPresent(delivery->{
            
            repository().delete(delivery);

         });
        
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
