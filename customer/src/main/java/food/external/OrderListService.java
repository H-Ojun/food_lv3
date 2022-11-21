package food.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name = "order", url = "${api.url.order}")
public interface OrderListService {
    @RequestMapping(method= RequestMethod.GET, path="/orderLists/{id}")
    public OrderList getOrderList(@PathVariable("id") Long id);
}

