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
        		User user = User.builder().password("efew213,.,").username("wedwq;ld,.").build();
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
