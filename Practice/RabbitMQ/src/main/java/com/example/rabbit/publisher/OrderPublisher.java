package com.example.rabbit.publisher;

import com.example.rabbit.config.MessageConfig;
import com.example.rabbit.dto.Order;
import com.example.rabbit.dto.OrderStatus;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.example.rabbit.RabbitMqApplication.*;


@RestController
@RequestMapping("/order")
public class OrderPublisher {

    final
    RabbitTemplate rabbitTemplate;

    public OrderPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setDefaultReceiveQueue(QUEUE);
    }

    @PostMapping("/{restName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restName){
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus status=new OrderStatus(order,"PROCCESS","order has been successfully processed"+restName);
        rabbitTemplate.convertAndSend(EXCHANGE,ROUTING_KEY,"status");
        return "Success!!";
    }
}
