package dev.evertonsavio.app.services.implementations;

import dev.evertonsavio.app.config.amqp.UserAmqpMessage;
import dev.evertonsavio.app.models.request.UserRequest;
import dev.evertonsavio.app.models.request.UsersRequest;
import dev.evertonsavio.app.models.response.UserResponse;
import dev.evertonsavio.app.producers.KafkaProducer;
import dev.evertonsavio.app.services.KafkaUserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

import static dev.evertonsavio.app.config.constants.KafkaConstants.TOPIC_REGISTER;

@Service
public class KafkaUserServiceImpl implements KafkaUserService {

    private KafkaProducer kafkaProducer;

    public KafkaUserServiceImpl(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public Mono<UserResponse> execute(UsersRequest request) {

        List<UserRequest> users = request.getUsers();
        System.out.println("QTD de users: " + users.size());

        kafkaProducer.send(TOPIC_REGISTER, UUID.randomUUID().toString() , new UserAmqpMessage(request.getUsers()).toString());

        return Mono.empty();
    }
}
