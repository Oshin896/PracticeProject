package com.example.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



//@Configuration
//@EnableRabbit
public class MessageConfig {
/*

    public static final String QUEUE = "test.queue";
    public static final String EXCHANGE = "test.exchange";
    public static final String ROUTING_KEY = "test.routing";

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE);
    }


    @Bean
    public Queue queue(){
        return new Queue(QUEUE,true);
    }
    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY);
    }
    */
/*@Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(System.getProperty("spring.rabbitmq.host"));
        connectionFactory.setVirtualHost(System.getProperty("spring.rabbitmq.virtual-host"));
        connectionFactory.setUsername(System.getProperty("spring.rabbitmq.username"));
        connectionFactory.setPassword(System.getProperty("spring.rabbitmq.password"));
        return connectionFactory;
    }*//*

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public AmqpTemplate template(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(System.getProperty("spring.rabbitmq.host"));
        connectionFactory.setVirtualHost(System.getProperty("spring.rabbitmq.virtual-host"));
        connectionFactory.setUsername(System.getProperty("spring.rabbitmq.username"));
        connectionFactory.setPassword(System.getProperty("spring.rabbitmq.password"));
         RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
*/



}
