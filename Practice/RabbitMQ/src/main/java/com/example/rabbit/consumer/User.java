package com.example.rabbit.consumer;

import com.example.rabbit.config.MessageConfig;
import com.example.rabbit.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

    @RabbitListener(queues = MessageConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus){
        System.out.println("Message received:"+orderStatus.getMessage());
    }
}
