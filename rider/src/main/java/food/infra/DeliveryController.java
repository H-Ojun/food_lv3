package food.infra;
import food.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@RestController
// @RequestMapping(value="/deliveries")
@Transactional
public class DeliveryController {
    @Autowired
    DeliveryRepository deliveryRepository;



    @RequestMapping(value = "deliveries/{id}/pick",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Delivery pick(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /delivery/pick  called #####");
            Optional<Delivery> optionalDelivery = deliveryRepository.findByOrderId(String.valueOf(id));
            
            optionalDelivery.orElseThrow(()-> new Exception("No Entity Found"));
            Delivery delivery = optionalDelivery.get();
            delivery.pick();
            
            deliveryRepository.save(delivery);
            return delivery;
            
    }
    



    @RequestMapping(value = "deliveries/{id}/deliveryconfirm",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Delivery deliveryConfirm(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /delivery/deliveryConfirm  called #####");
            Optional<Delivery> optionalDelivery = deliveryRepository.findByOrderId(String.valueOf(id));
            
            optionalDelivery.orElseThrow(()-> new Exception("No Entity Found"));
            Delivery delivery = optionalDelivery.get();
            delivery.deliveryConfirm();
            
            deliveryRepository.save(delivery);
            return delivery;
            
    }
    



}
