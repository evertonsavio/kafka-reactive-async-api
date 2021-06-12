package dev.evertonsavio.app.handlers;

import dev.evertonsavio.app.models.request.UserRequest;
import dev.evertonsavio.app.models.response.UserResponse;
import dev.evertonsavio.app.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {
    
    private UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    public Mono<ServerResponse> registerUser(ServerRequest request){

        Mono<UserRequest> registerUserRequest$ = request.bodyToMono(UserRequest.class);
        Mono<UserResponse> registerUserResponse$ = registerUserRequest$
                .flatMap(userRequest -> userService.execute(userRequest));

        return null;
    }

}
