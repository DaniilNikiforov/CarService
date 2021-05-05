package com.application.services;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.router.RouteConfiguration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.ArrayList;

import com.application.repositories.UserRepository;
import com.application.exception.AuthException;
import com.application.entities.User;
import com.application.entities.Role;
import com.application.views.main.MainView;
import com.application.views.home.HomeView;
import com.application.views.admin.AdminView;
import com.application.views.login.LoginView;
import com.application.views.logout.LogoutView;


@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class AuthorizedRoute {
		private String route;
		private String name;
		private Class<? extends Component> view;
	}
	
	public void authenticate(String username, String password) throws AuthException {
        User user = userRepository.findByUsername(username);
        if (user != null && user.checkPassword(password, passwordEncoder)) {
			VaadinSession.getCurrent().setAttribute(User.class, user);
        	createRoutes(user.getRole());
        } else {
        	throw new AuthException("Invalid credentials");
        }
    }
	
    private void createRoutes(Role role) {
        getAuthorizedRoutes(role).stream()
                .forEach(route ->
                        RouteConfiguration.forSessionScope().setRoute(
                                route.getRoute(), route.getView(), MainView.class));
    }	
	
    public List<AuthorizedRoute> getAuthorizedRoutes(Role role) {
        var routes = new ArrayList<AuthorizedRoute>();

        if (role.getName().equals("USER")) {
        	routes.add(AuthorizedRoute.builder().route("home").name("Home").view(HomeView.class).build());
        	routes.add(AuthorizedRoute.builder().route("logout").name("Logout").view(LogoutView.class).build());         
        } 
        else if (role.getName().equals("ADMIN")) {
        	routes.add(AuthorizedRoute.builder().route("home").name("Home").view(HomeView.class).build());
            routes.add(AuthorizedRoute.builder().route("logout").name("Logout").view(LogoutView.class).build());
            routes.add(AuthorizedRoute.builder().route("admin").name("Admin").view(AdminView.class).build());
        }

        return routes;
    }
    
}
