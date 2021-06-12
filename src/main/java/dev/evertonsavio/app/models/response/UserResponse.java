package dev.evertonsavio.app.models.response;

import dev.evertonsavio.app.domain.data.User;
import lombok.Getter;
import lombok.Setter;

public class UserResponse extends DefaultResponse {
	
	public UserResponse(User user) {
		this.user = user;
	}
	
	@Getter @Setter
	private User user;

}
