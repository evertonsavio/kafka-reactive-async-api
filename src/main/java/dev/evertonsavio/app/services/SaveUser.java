package dev.evertonsavio.app.services;

import dev.evertonsavio.app.domain.data.DataBaseSequence;
import dev.evertonsavio.app.models.request.UserRequest;
import dev.evertonsavio.app.models.response.UserResponse;

public interface SaveUser {
    
    UserResponse execute(UserRequest request);
    
    DataBaseSequence findNextSequence(String sequenceName);

}
