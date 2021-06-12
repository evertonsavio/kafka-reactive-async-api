package dev.evertonsavio.app.models.response;

import java.util.List;

import dev.evertonsavio.app.domain.data.User;
import lombok.Getter;
import lombok.Setter;

public class UserListResponse extends DefaultResponse {

	public UserListResponse(List<User> userList) {
		this.userList = userList;
	}
	
	@Getter @Setter
	private List<User> userList;
	

}
