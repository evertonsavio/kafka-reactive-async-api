package dev.evertonsavio.app.services;

import dev.evertonsavio.app.models.request.UsersRequest;
import dev.evertonsavio.app.models.response.UserResponse;
import reactor.core.publisher.Mono;

public interface KafkaUserService {

    Mono<UserResponse> execute(UsersRequest request);

}
