package dev.evertonsavio.app.domain.data.repository.facade;

import java.util.List;

import dev.evertonsavio.app.domain.data.User;

public interface UserRepositoryFacade {

	public User save(User user);
	
	public List<User> findAll();
	
}
