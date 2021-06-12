package dev.evertonsavio.app.consumers;

import dev.evertonsavio.app.config.amqp.UserAmqpMessage;

public interface UserListener {
	
	void consumeMessage(String message);

}
