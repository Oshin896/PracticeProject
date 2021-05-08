package rabbitmq.com.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Receiver {

    private final static String HOST_NAME = "centralized-rabbitmq01.test.homecredit.in";
    private final static String QUEUE_NAME = "feePortal.data.queue";

    public static void main(String[] args) throws Exception {

        final ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(HOST_NAME);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("Welcome@123");

        final Connection connection = connectionFactory.newConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        System.out.println("Waiting for messages from the queue. To exit press CTRL+C");

        final DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            final String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("Received from message from the queue: " + message);
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
    }
}