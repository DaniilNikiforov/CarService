package com.application.services;

import com.application.repositories.UserRepository;
import com.application.entities.User;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	public void update(User u) {
		userRepository.save(u);
	}
	
}
