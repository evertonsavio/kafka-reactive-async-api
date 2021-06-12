package dev.evertonsavio.app.domain.data.repository.facade;

import dev.evertonsavio.app.domain.data.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepositoryFacade extends ReactiveMongoRepository<User, String> {

	Mono<User> save(User user);
	Flux<User> findAll();
	
}
