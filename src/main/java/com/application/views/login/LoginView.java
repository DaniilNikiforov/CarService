package com.application.views.login;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.application.views.main.MainView;

@Route(value = "login", layout = MainView.class)
@PageTitle("Login")
public class LoginView extends Div {

    public LoginView() {
        addClassName("login-view");
        
        H1 welcomeTitle					= new H1("Welcome!");
        TextField usernameField 		= new TextField("Username");
        PasswordField passwordField 	= new PasswordField("Password");
        Button button					= new Button("Login");
        
        add(welcomeTitle);
        add(usernameField);
        add(passwordField);
        add(button);
        
    }

}
