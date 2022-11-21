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
// @RequestMapping(value="/payments")
@Transactional
public class PaymentController {
    @Autowired
    PaymentRepository paymentRepository;



    @RequestMapping(value = "payments/{id}/cancelpayment",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Payment cancelPayment(@PathVariable(value = "id") Long id, @RequestBody CancelPaymentCommand cancelPaymentCommand, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /payment/cancelPayment  called #####");
            Optional<Payment> optionalPayment = paymentRepository.findByOrderId(id);
            
            optionalPayment.orElseThrow(()-> new Exception("No Entity Found"));
            Payment payment = optionalPayment.get();
            payment.cancelPayment(cancelPaymentCommand);
            
            paymentRepository.save(payment);
            return payment;
            
    }
    



}
