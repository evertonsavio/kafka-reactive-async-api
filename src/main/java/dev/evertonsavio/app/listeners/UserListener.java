package dev.evertonsavio.app.listeners;

import dev.evertonsavio.app.config.amqp.UserAmqpMessage;

public interface UserListener {
	
	void consumeMessage(UserAmqpMessage message);

}
