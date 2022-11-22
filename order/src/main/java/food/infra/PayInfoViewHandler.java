package food.infra;

import food.domain.*;
import food.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PayInfoViewHandler {


    @Autowired
    private PayInfoRepository payInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_CREATE_1 (@Payload Paid paid) {
        try {

            if (!paid.validate()) return;

            // view 객체 생성
            PayInfo payInfo = new PayInfo();
            // view 객체에 이벤트의 Value 를 set 함
            payInfo.setOrderId(paid.getOrderId());
            payInfo.setCancel(false);
            // view 레파지 토리에 save
            payInfoRepository.save(payInfo);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_1(@Payload OrderCanceled orderCanceled) {
        try {
            if (!orderCanceled.validate()) return;
                // view 객체 조회

                List<PayInfo> payInfoList = payInfoRepository.findByOrderId(String.valueOf(orderCanceled.getId()));
                for(PayInfo payInfo : payInfoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    payInfo.setCancel(true);
                // view 레파지 토리에 save
                payInfoRepository.save(payInfo);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderRejected_then_DELETE_1(@Payload OrderRejected orderRejected) {
        try {
            if (!orderRejected.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            payInfoRepository.deleteByOrderId(orderRejected.getOrderId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

