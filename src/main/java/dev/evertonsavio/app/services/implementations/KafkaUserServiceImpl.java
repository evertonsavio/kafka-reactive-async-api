package dev.evertonsavio.app.services.implementations;

import dev.evertonsavio.app.config.amqp.UserAmqpMessage;
import dev.evertonsavio.app.domain.conveter.UserConverter;
import dev.evertonsavio.app.domain.data.User;
import dev.evertonsavio.app.models.request.UserRequest;
import dev.evertonsavio.app.models.request.UsersRequest;
import dev.evertonsavio.app.models.response.UserResponse;
import dev.evertonsavio.app.services.KafkaUserService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

import static dev.evertonsavio.app.config.constants.KafkaConstants.TOPIC_REGISTER;

@Service
public class KafkaUserServiceImpl implements KafkaUserService {

    private KafkaTemplate kafkaTemplate;

    public KafkaUserServiceImpl(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /*==================================================================================================================
    ==================================================================================================================*/
    @Override
    public Mono<UserResponse> execute(UsersRequest request) {

        List<UserRequest> users = request.getUsers();
        System.out.println("QTD de users: " + users.size());

        request.getUsers().stream().parallel().forEach(userRequest -> {
            User user = UserConverter.convertFromRequest(userRequest, UUID.randomUUID().toString());
            this.kafkaTemplate.send(TOPIC_REGISTER, user.getId(), user);
        });

        return Mono.empty();
    }
}/*===================================================================================================================*/
