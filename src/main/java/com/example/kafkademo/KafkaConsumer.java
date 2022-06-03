package com.example.kafkademo;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class KafkaConsumer {


    @SneakyThrows
    @KafkaListener(topics = {"test2", "test3"}, groupId = "grp-id", concurrency = "20")
    public void consume(ConsumerRecord<String,String> msg) {
        String msgDisplay = " thread : "+ Thread.currentThread().getId() + " from topic :"+ msg.topic()  + " with key : " + msg.key() + " Partation: " + msg.partition();
       log.info("- ----Start "+ msgDisplay);
        TimeUnit.SECONDS.sleep(3);
        log.info("- ----Finish "+ msgDisplay);


    }

}
