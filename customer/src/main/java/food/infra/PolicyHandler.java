package food.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import food.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import food.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired OrderStatusRepository orderStatusRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Picked'")
    public void wheneverPicked_Notify(@Payload Picked picked){

        Picked event = picked;
        System.out.println("\n\n##### listener Notify : " + picked + "\n\n");


        

        // Sample Logic //
        OrderStatus.notify(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderAccepted'")
    public void wheneverOrderAccepted_Notify(@Payload OrderAccepted orderAccepted){

        OrderAccepted event = orderAccepted;
        System.out.println("\n\n##### listener Notify : " + orderAccepted + "\n\n");


        

        // Sample Logic //
        OrderStatus.notify(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderRejected'")
    public void wheneverOrderRejected_Notify(@Payload OrderRejected orderRejected){

        OrderRejected event = orderRejected;
        System.out.println("\n\n##### listener Notify : " + orderRejected + "\n\n");


        

        // Sample Logic //
        OrderStatus.notify(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderStarted'")
    public void wheneverOrderStarted_Notify(@Payload OrderStarted orderStarted){

        OrderStarted event = orderStarted;
        System.out.println("\n\n##### listener Notify : " + orderStarted + "\n\n");


        

        // Sample Logic //
        OrderStatus.notify(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderFinished'")
    public void wheneverOrderFinished_Notify(@Payload OrderFinished orderFinished){

        OrderFinished event = orderFinished;
        System.out.println("\n\n##### listener Notify : " + orderFinished + "\n\n");


        

        // Sample Logic //
        OrderStatus.notify(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Delivered'")
    public void wheneverDelivered_Notify(@Payload Delivered delivered){

        Delivered event = delivered;
        System.out.println("\n\n##### listener Notify : " + delivered + "\n\n");


        

        // Sample Logic //
        OrderStatus.notify(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCanceled'")
    public void wheneverOrderCanceled_Notify(@Payload OrderCanceled orderCanceled){

        OrderCanceled event = orderCanceled;
        System.out.println("\n\n##### listener Notify : " + orderCanceled + "\n\n");


        

        // Sample Logic //
        OrderStatus.notify(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_Notify(@Payload OrderPlaced orderPlaced){

        OrderPlaced event = orderPlaced;
        System.out.println("\n\n##### listener Notify : " + orderPlaced + "\n\n");


        

        // Sample Logic //
        OrderStatus.notify(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_Notify(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener Notify : " + paid + "\n\n");


        

        // Sample Logic //
        OrderStatus.notify(event);
        

        

    }

}


