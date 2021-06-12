package dev.evertonsavio.app.handlers;

import dev.evertonsavio.app.models.request.UsersRequest;
import dev.evertonsavio.app.models.response.UserResponse;
import dev.evertonsavio.app.services.KafkaUserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class KafkaUserHandler {

    private KafkaUserService kafkaUserService;

    public KafkaUserHandler(KafkaUserService kafkaUserService) {
        this.kafkaUserService = kafkaUserService;
    }

    public Mono<ServerResponse> registerUsers(ServerRequest request){

        Mono<UsersRequest> registerUsersRequest$ = request.bodyToMono(UsersRequest.class);
        Mono<UserResponse> registerUsersResponse$ = registerUsersRequest$
                .flatMap(usersRequest -> kafkaUserService.execute(usersRequest));

        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(registerUsersResponse$, UserResponse.class);
    }
}
