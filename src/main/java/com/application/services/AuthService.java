package com.application.services;

import com.vaadin.server.VaadinSession;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.component.Component;

import org.springframework.stereotype.Service;

import com.application.repositories.UserRepository;
import com.application.exception.AuthException;
import com.application.entities.User;
import com.application.entities.Role;

import java.util.List;
import java.util.ArrayList;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import com.application.views.*;

@Service
public class AuthService {

	private final UserRepository userRepository;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class AuthorizedRoute {
		private String route;
		private String name;
		private Class<? extends Component> view;
	}
	
	public AuthService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void authenticate (String username, String password) throws AuthException {
		User user = userRepository.getByUsername(username);
		
		if (user == null || !user.checkPassword(password)) {
			user = new User(username, password);
			
			userRepository.save(user);
			
			throw new AuthException("Invalid credentials");
		}
		
		VaadinSession.getCurrent().setAttribute(User.class, user);
		createRoutes(user.getRole());
	}
	
	private void createRoutes(Role role) {
		getAuthorizedRoutes(role).stream()
			.forEach(route ->
				RouteConfiguration.forSessionScope()
				.setRoute(route.getRoute(), route.getView(), MainView.class));
	}
	
	private List<AuthorizedRoute> getAuthorizedRoutes(Role role) {
		List<AuthorizedRoute> routes = new ArrayList<AuthorizedRoute>();
		
		if (role.getName().equals("user")) {
			routes.add(new AuthorizedRoute("home", "Home", HomeView.class));
			routes.add(new AuthorizedRoute("logout", "Logout", LogoutView.class));
		}
		else if (role.getName().equals("admin")) {
			routes.add(new AuthorizedRoute("home", "Home", HomeView.class));
			routes.add(new AuthorizedRoute("logout", "Logout", LogoutView.class));
			routes.add(new AuthorizedRoute("admin", "Admin", AdminView.class));
		}
		
		return routes;
	}
	
}
