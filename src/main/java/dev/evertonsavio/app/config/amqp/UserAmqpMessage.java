package dev.evertonsavio.app.config.amqp;

import java.util.List;

import dev.evertonsavio.app.models.request.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAmqpMessage {
	
	private List<UserRequest> registers;

	@Override
	public String toString() {
		return "{\"" + "registers\":" + registers + '}';
	}
}
