package com.application.repositories;

import com.application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	
	List<User> findByUsernameStartsWithIgnoreCase(String lastName);
	
}
