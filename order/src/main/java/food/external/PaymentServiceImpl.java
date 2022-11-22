package food.external;

import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * Fallback
     */
    public Payment getPayment(Long id) {
        throw new RuntimeException("TIMEOUT_ERROR");
    }

    @Override
    public void cancelPayment(Long id, CancelPaymentCommand cancelPaymentCommand) {
        // TODO Auto-generated method stub
        
    }
}
