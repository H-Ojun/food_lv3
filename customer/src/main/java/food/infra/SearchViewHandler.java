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
public class SearchViewHandler {


    @Autowired
    private SearchRepository searchRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            Search search = new Search();
            // view 객체에 이벤트의 Value 를 set 함
            search.setStatus("OrderPlace");
            search.setId(orderPlaced.getId());
            // view 레파지 토리에 save
            searchRepository.save(search);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_1(@Payload Paid paid) {
        try {
            if (!paid.validate()) return;
                // view 객체 조회
            Optional<Search> searchOptional = searchRepository.findById(paid.getOrderId());

            if( searchOptional.isPresent()) {
                 Search search = searchOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                search.setStatus("Paid");    
                // view 레파지 토리에 save
                 searchRepository.save(search);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderAccepted_then_UPDATE_2(@Payload OrderAccepted orderAccepted) {
        try {
            if (!orderAccepted.validate()) return;
                // view 객체 조회
            Optional<Search> searchOptional = searchRepository.findById(orderAccepted.getOrderId());

            if( searchOptional.isPresent()) {
                 Search search = searchOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                search.setStatus("OrderAccept");    
                // view 레파지 토리에 save
                 searchRepository.save(search);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderRejected_then_UPDATE_3(@Payload OrderRejected orderRejected) {
        try {
            if (!orderRejected.validate()) return;
                // view 객체 조회
            Optional<Search> searchOptional = searchRepository.findById(Long.valueOf(orderRejected.getOrderId()));

            if( searchOptional.isPresent()) {
                 Search search = searchOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                search.setStatus("OrderReject");    
                // view 레파지 토리에 save
                 searchRepository.save(search);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderStarted_then_UPDATE_4(@Payload OrderStarted orderStarted) {
        try {
            if (!orderStarted.validate()) return;
                // view 객체 조회
            Optional<Search> searchOptional = searchRepository.findById(Long.valueOf(orderStarted.getOrderId()));

            if( searchOptional.isPresent()) {
                 Search search = searchOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                search.setStatus("OrderStart");    
                // view 레파지 토리에 save
                 searchRepository.save(search);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderFinished_then_UPDATE_5(@Payload OrderFinished orderFinished) {
        try {
            if (!orderFinished.validate()) return;
                // view 객체 조회
            Optional<Search> searchOptional = searchRepository.findById(Long.valueOf(orderFinished.getOrderId()));

            if( searchOptional.isPresent()) {
                 Search search = searchOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                search.setStatus("OrderFinish");    
                // view 레파지 토리에 save
                 searchRepository.save(search);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPicked_then_UPDATE_6(@Payload Picked picked) {
        try {
            if (!picked.validate()) return;
                // view 객체 조회
            Optional<Search> searchOptional = searchRepository.findById(Long.valueOf(picked.getOrderId()));

            if( searchOptional.isPresent()) {
                 Search search = searchOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                search.setStatus("Pick");    
                // view 레파지 토리에 save
                 searchRepository.save(search);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

