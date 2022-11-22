package food.external;

import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * Fallback
     */
    public Payment getPayment(Long id) {
        Payment payment = new Payment();
        return payment;
    }
}
