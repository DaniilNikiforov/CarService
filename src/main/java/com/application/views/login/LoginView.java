package com.application.views.login;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.component.notification.Notification;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.services.AuthService;
import com.application.services.UserService;
import com.application.exception.AuthException;
import com.application.entities.User;

@Route(value = "login")
@PageTitle("Login")
public class LoginView extends Div {

	@Autowired
	private AuthService authService;
	@Autowired
	private UserService userService;
	
    public LoginView() {
        addClassName("login-view");
        
        H1 welcomeTitle					= new H1("Welcome!");
        welcomeTitle.addClassName("title");
        
        TextField usernameField 		= new TextField("Username");
        PasswordField passwordField 	= new PasswordField("Password");
        Button button					= new Button("Login");
     
        button.addClickListener(event -> {   				
        	try {
//        		User user = User.builder().password("dhdghb783").username("flywater").name("Daniil").surname("Nykyforov").build();
//        		userService.update(user);
//                User user1 = User.builder().password("dhdghb7834").username("geek").name("Jack").surname("Kon").build();
//                userService.update(user1);
//                User user2 = User.builder().password("dhdghb7835").username("kpi").name("Rayan").surname("Vinsly").build();
//                userService.update(user2);
//                User user3 = User.builder().password("dhdghb7836").username("icecream").name("Konor").surname("Black").build();
//                userService.update(user3);
//                User user4 = User.builder().password("dhdghb7837").username("millennial").name("Jon").surname("Algol").build();
//                userService.update(user4);

                User user = User.builder().password("dhdghb783").username("digger").name("Nick").surname("Hopkins").build();
        		userService.update(user);
        		
        		authService.authenticate(usernameField.getValue(), passwordField.getValue());
        		UI.getCurrent().navigate("home");
        	}
        	catch (AuthException exc) {
        		Notification.show(exc.getMessage());
        	}
        });
        
        add(welcomeTitle);
        add(usernameField);
        add(passwordField);
        add(button);
        
    }

}
