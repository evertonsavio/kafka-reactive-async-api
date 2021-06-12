package dev.evertonsavio.app.listeners;

import dev.evertonsavio.app.config.amqp.UserAmqpMessage;
import dev.evertonsavio.app.domain.data.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.messaging.handler.annotation.Payload;

public interface UserListener {
	
	void consumeMessage(@Payload String message);

}
