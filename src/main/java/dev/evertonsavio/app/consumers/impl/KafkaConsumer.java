package dev.evertonsavio.app.consumers.impl;

import dev.evertonsavio.app.config.amqp.UserAmqpMessage;
import dev.evertonsavio.app.consumers.UserListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static dev.evertonsavio.app.config.constants.KafkaConstants.TOPIC_REGISTER;

@Component
public class KafkaConsumer implements UserListener {

    @Override
    @KafkaListener(id = "kafkaTopicListener", topics = TOPIC_REGISTER)
    public void consumeMessage(UserAmqpMessage message) {

        System.out.println("MESSAGE RECEIVED");
        System.out.println(message.getRegisters());

    }
}
