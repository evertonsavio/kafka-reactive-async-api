package dev.evertonsavio.app.listeners.impl;

import com.google.gson.Gson;
import dev.evertonsavio.app.domain.data.User;
import dev.evertonsavio.app.domain.data.repository.facade.UserRepositoryFacade;
import dev.evertonsavio.app.listeners.UserListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static dev.evertonsavio.app.config.constants.KafkaConstants.TOPIC_REGISTER;

@Component
public class UserListenerImpl implements UserListener {

    private UserRepositoryFacade userRepositoryFacade;

    public UserListenerImpl(UserRepositoryFacade userRepositoryFacade) {
        this.userRepositoryFacade = userRepositoryFacade;
    }

    /*==================================================================================================================
    ==================================================================================================================*/
    @Override
    @KafkaListener(id = "kafkaTopicListener", topics = TOPIC_REGISTER)
    public void consumeMessage(@Payload String message) {

        Gson gson = new Gson();
        User user = gson.fromJson(message, User.class);

        userRepositoryFacade.save(user).subscribe();
    }
}/*===================================================================================================================*/
