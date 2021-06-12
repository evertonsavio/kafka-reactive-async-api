package dev.evertonsavio.app.services.implementations;

import dev.evertonsavio.app.domain.data.DataBaseSequence;
import dev.evertonsavio.app.models.request.UserRequest;
import dev.evertonsavio.app.models.response.UserResponse;
import dev.evertonsavio.app.services.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public Mono<UserResponse> execute(UserRequest request) {
        return null;
    }

    @Override
    public Mono<DataBaseSequence> findNextSequence(String sequenceName) {
        return null;
    }
}
