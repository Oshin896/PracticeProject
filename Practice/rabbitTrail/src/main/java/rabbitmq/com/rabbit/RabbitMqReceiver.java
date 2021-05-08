package rabbitmq.com.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqReceiver  {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqReceiver.class);

    public static final String queueName="feePortal.data.queue";




    @RabbitListener(queues = queueName)
    public void receivedMessage(LeadsDataTippersTO user) {
        logger.info("User Details Received is.. " + user);
    }




}