package com.application.services;

import com.application.repositories.UserRepository;
import com.application.repositories.RoleRepository;
import com.application.entities.User;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService{
	
	@Autowired
	private UserRepository 			userRepository;
	@Autowired
	private RoleRepository 			roleRepository;
	@Autowired
	private BCryptPasswordEncoder 	passwordEncoder;
	
	public boolean update(User u) {
		User userDb = userRepository.findByUsername(u.getUsername());
		
		if (userDb != null) {
			return false; 
		}
		
		u.setRole(roleRepository.findByName("USER"));
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		
		userRepository.save(u);
		
		return true;
	}
	
}
