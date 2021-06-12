package dev.evertonsavio.app.services;

import dev.evertonsavio.app.models.request.UsersRequest;
import dev.evertonsavio.app.models.response.UserResponse;

public interface SaveUsers {
    
    UserResponse execute(UsersRequest request);

}
