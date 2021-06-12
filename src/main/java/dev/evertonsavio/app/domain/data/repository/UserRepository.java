package dev.evertonsavio.app.domain.data.repository;

import dev.evertonsavio.app.domain.data.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

}
