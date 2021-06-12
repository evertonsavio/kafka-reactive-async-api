package dev.evertonsavio.app.services.implementations;

import dev.evertonsavio.app.domain.conveter.UserConverter;
import dev.evertonsavio.app.domain.data.DataBaseSequence;
import dev.evertonsavio.app.domain.data.User;
import dev.evertonsavio.app.domain.data.repository.facade.UserRepositoryFacade;
import dev.evertonsavio.app.models.request.UserRequest;
import dev.evertonsavio.app.models.response.UserResponse;
import dev.evertonsavio.app.services.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepositoryFacade userRepositoryFacade;

    public UserServiceImpl(UserRepositoryFacade userRepositoryFacade) {
        this.userRepositoryFacade = userRepositoryFacade;
    }

    @Override
    public Mono<UserResponse> execute(UserRequest request) {

        User user = UserConverter.convertFromRequest(request, UUID.randomUUID().toString());
        Mono<User> user$ = userRepositoryFacade.save(user);

        return user$.flatMap(userSaved -> Mono.just(new UserResponse(userSaved)));
    }

    @Override
    public Flux<User> execute() {

        return userRepositoryFacade.findAll();
    }

    @Override
    public Mono<DataBaseSequence> findNextSequence(String sequenceName) {
        return null;
    }
}
