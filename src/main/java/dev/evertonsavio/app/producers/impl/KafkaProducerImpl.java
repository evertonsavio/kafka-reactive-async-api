package dev.evertonsavio.app.producers.impl;

import dev.evertonsavio.app.producers.KafkaProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class KafkaProducerImpl implements KafkaProducer {

    private KafkaTemplate kafkaTemplate;

    public KafkaProducerImpl(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(String topicName, Serializable key, Object message) {

        kafkaTemplate.send(topicName, key, message);
    }
}
