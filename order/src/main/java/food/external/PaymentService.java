package food.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name = "order", url = "${api.url.order}")
public interface PaymentService {
    @RequestMapping(method= RequestMethod.PUT, path="/payments/{id}/cancelpayment")
    public void cancelPayment(@PathVariable("id") Long id);
}

