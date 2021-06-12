package dev.evertonsavio.app.routers;

import dev.evertonsavio.app.handlers.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static dev.evertonsavio.app.config.constants.URLMapping.GET_LIST_REGISTER;
import static dev.evertonsavio.app.config.constants.URLMapping.POST_SAVE_REGISTER;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class UserRouter {

    /*==================================================================================================================
    ROUTES: /user-service/... -> User Business Routes
    ==================================================================================================================*/
    @Bean
    public RouterFunction<ServerResponse> userRoutes(UserHandler userHandler){
        return RouterFunctions.route(
                POST(POST_SAVE_REGISTER)
                    .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                userHandler::registerUser).andRoute(
                GET(GET_LIST_REGISTER)
                    .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                userHandler::listUsers);
    }
}/*===================================================================================================================*/
