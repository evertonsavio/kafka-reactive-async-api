package dev.evertonsavio.app.producers;

import java.io.Serializable;

public interface KafkaProducer<K extends Serializable, V> {
    void send(String topicName, K key, V message);
}