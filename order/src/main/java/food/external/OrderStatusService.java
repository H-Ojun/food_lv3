package food.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name = "customer", url = "${api.url.customer}")
public interface OrderStatusService {
    @RequestMapping(method= RequestMethod.GET, path="/orderStatuses/{id}")
    public OrderStatus getOrderStatus(@PathVariable("id") Long id);
}

