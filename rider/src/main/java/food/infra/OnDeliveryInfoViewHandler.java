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
public class OnDeliveryInfoViewHandler {


    @Autowired
    private OnDeliveryInfoRepository onDeliveryInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPicked_then_CREATE_1 (@Payload Picked picked) {
        try {

            if (!picked.validate()) return;

            // view 객체 생성
            OnDeliveryInfo onDeliveryInfo = new OnDeliveryInfo();
            // view 객체에 이벤트의 Value 를 set 함
            onDeliveryInfo.setOrderId(picked.getOrderId());
            onDeliveryInfo.setStatus(picked.getStatus());
            onDeliveryInfo.setAddress(picked.getAddress());
            // view 레파지 토리에 save
            onDeliveryInfoRepository.save(onDeliveryInfo);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenDelivered_then_UPDATE_1(@Payload Delivered delivered) {
        try {
            if (!delivered.validate()) return;
                // view 객체 조회

                List<OnDeliveryInfo> onDeliveryInfoList = onDeliveryInfoRepository.findByOrderId(String.valueOf(delivered.getId()));
                for(OnDeliveryInfo onDeliveryInfo : onDeliveryInfoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    onDeliveryInfo.setStatus(delivered.getStatus());
                // view 레파지 토리에 save
                onDeliveryInfoRepository.save(onDeliveryInfo);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

