package com.example.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/demo")
public class DemoRs {

    @Autowired
    private KafkaProducer producer;

    @GetMapping("push")
    public void pushMsg() {
        System.out.println("true = " + true);
        producer.run();
    }
}
