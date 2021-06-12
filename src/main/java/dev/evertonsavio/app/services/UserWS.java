package dev.evertonsavio.app.services;

import dev.evertonsavio.app.models.request.UsersRequest;
import dev.evertonsavio.app.models.request.UserRequest;
import dev.evertonsavio.app.models.response.UserListResponse;
import dev.evertonsavio.app.models.response.UserResponse;

public interface UserWS {

	public UserResponse saveRegister(UserRequest request);
	
	public UserResponse saveRegisters(UsersRequest request);
	
	public UserListResponse listRegisters();
	
}
