package dev.evertonsavio.app.routers;

import dev.evertonsavio.app.handlers.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class UserRouter {

    /*==================================================================================================================
    ROUTES: /user-service/... -> Register a new user
    ==================================================================================================================*/

    @Bean
    public RouterFunction<ServerResponse> userRoutes(UserHandler userHandler){
        return RouterFunctions.route(
                POST("/user-service/user")
                    .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                userHandler::registerUser);
    }

}
