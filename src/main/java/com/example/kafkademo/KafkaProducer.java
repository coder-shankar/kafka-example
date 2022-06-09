package com.example.kafkademo;

import lombok.SneakyThrows;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class KafkaProducer implements CommandLineRunner  {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @SneakyThrows
    public void run() {
        for (int i = 0; i < 40; i++) {
            ProducerRecord<String, String> emailMsg =
                new ProducerRecord<String, String>("test3", String.valueOf(i), "email message");
            kafkaTemplate.send(emailMsg);

            ProducerRecord<String, String> addrMsg =
                new ProducerRecord<String, String>("test2", String.valueOf(i), "address message");
            kafkaTemplate.send(addrMsg);


        }


    }

    @Override
    public void run(String... args) throws Exception {
        run();
    }
}
