package dev.evertonsavio.app.routers;

import dev.evertonsavio.app.handlers.KafkaUserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static dev.evertonsavio.app.config.constants.URLMapping.POST_SAVE_REGISTERS;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class KafkaRouter {

    /*==================================================================================================================
    ROUTES: /user-service/... -> Kafka User Business Routes
    ==================================================================================================================*/
    @Bean
    public RouterFunction<ServerResponse> kafkaRoutes(KafkaUserHandler kafkaUserHandler){
        return RouterFunctions.route(
                POST(POST_SAVE_REGISTERS)
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                kafkaUserHandler::registerUsers);
    }
}/*===================================================================================================================*/
