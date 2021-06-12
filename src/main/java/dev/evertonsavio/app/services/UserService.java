package dev.evertonsavio.app.services;

import dev.evertonsavio.app.domain.data.DataBaseSequence;
import dev.evertonsavio.app.models.request.UserRequest;
import dev.evertonsavio.app.models.response.UserResponse;
import reactor.core.publisher.Mono;

public interface UserService {
    
    Mono<UserResponse> execute(UserRequest request);
    Mono<DataBaseSequence> findNextSequence(String sequenceName);

}
