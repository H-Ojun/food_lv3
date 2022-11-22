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
// @RequestMapping(value="/orderLists")
@Transactional
public class OrderListController {
    @Autowired
    OrderListRepository orderListRepository;




    @RequestMapping(value = "orderLists/{id}/cancel",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public OrderList cancel(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /orderList/cancel  called #####");
            Optional<OrderList> optionalOrderList = orderListRepository.findById(id);
            
            optionalOrderList.orElseThrow(()-> new Exception("No Entity Found"));
            OrderList orderList = optionalOrderList.get();
            orderList.cancel();
            
            orderListRepository.save(orderList);
            return orderList;
            
    }
    



}
