package dev.evertonsavio.app.domain.conveter;

import dev.evertonsavio.app.domain.data.Address;
import dev.evertonsavio.app.domain.data.User;
import dev.evertonsavio.app.models.request.UserRequest;

public class UserConverter {
	
	public static User convertFromRequest(UserRequest request, String id) {
		User user = new User();
		user.setUserPublicId(id);
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setAge(request.getAge());
		
		if(request.getAddress() != null) {
			user.setAddress(new Address(request.getAddress().getStreet(), request.getAddress().getPostalCode()));
		}
		
		return user;
	}

}
