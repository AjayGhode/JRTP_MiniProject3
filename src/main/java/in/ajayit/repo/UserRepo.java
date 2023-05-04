package in.ajayit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ajayit.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	
	public User findByEmail(String email);
}