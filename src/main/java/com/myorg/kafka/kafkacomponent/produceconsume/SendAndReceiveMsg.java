package com.myorg.kafka.kafkacomponent.produceconsume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class SendAndReceiveMsg {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Value("${my_kafka_component_topic}")
    private String topicName;

    public void produceMessage(String uuid){
        kafkaTemplate.send(topicName,
                String.valueOf(Instant.now().getEpochSecond()), uuid);
    }


    @KafkaListener(topics = {"mycomponenttopic"}, groupId = "kafkacomponent")
    public void listenermessage(String message) {
        System.out.println("messsage consumed = " + message);
    }

   @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    public void pushMessageToTopic() {
        this.produceMessage(UUID.randomUUID().toString());
    }
}
