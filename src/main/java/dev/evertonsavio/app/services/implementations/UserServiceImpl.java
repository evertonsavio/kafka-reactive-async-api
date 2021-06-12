package dev.evertonsavio.app.services.implementations;

import dev.evertonsavio.app.domain.conveter.UserConverter;
import dev.evertonsavio.app.domain.data.DataBaseSequence;
import dev.evertonsavio.app.domain.data.User;
import dev.evertonsavio.app.models.request.UserRequest;
import dev.evertonsavio.app.models.response.UserResponse;
import dev.evertonsavio.app.services.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public Mono<UserResponse> execute(UserRequest request) {

        User user = UserConverter.convertFromRequest(request, UUID.randomUUID().toString());

        System.out.println(user.getEmail());
        System.out.println(user.getAddress());

        return Mono.empty();
    }

    @Override
    public Mono<DataBaseSequence> findNextSequence(String sequenceName) {
        return null;
    }
}
