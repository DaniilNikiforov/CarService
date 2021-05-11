package com.application.views.component;

import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import com.application.entities.User;
import com.application.repositories.UserRepository;
import com.application.views.admin.AdminView.ChangeHandler;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import com.vaadin.flow.spring.annotation.SpringComponent;

@SpringComponent
public class UserEditor extends VerticalLayout implements KeyNotifier {
	
	private User user;

	@Autowired
	private UserRepository userRepository;
	
	private TextField name 				= new TextField("Name");
	private TextField surname 			= new TextField("Surname");
	private TextField username			= new TextField("Username");
	private TextField password 			= new TextField("Password");
	
	private Button save 				= new Button("Save", VaadinIcon.CHECK.create());
	private Button cancel 				= new Button("Cancel");
	private Button delete 				= new Button("Delete", VaadinIcon.TRASH.create());
	private HorizontalLayout actions 	= new HorizontalLayout(save, cancel, delete);
	
	private Binder<User> binder = new Binder<>(User.class);
	private ChangeHandler changeHandler;
	
	public UserEditor(UserRepository userRepository) {
		this.userRepository = userRepository;
		
		add(name, surname, username, password, actions);
		
		binder.bindInstanceFields(this);
		
		setSpacing(true);
		
		save.getElement().getThemeList().add("primary");
		delete.getElement().getThemeList().add("error");
		
		addKeyPressListener(Key.ENTER, e -> save());
		
		save.addClickListener(e -> save());
		delete.addClickListener(e -> delete());
		cancel.addClickListener(e -> editUser(user));
		setVisible(false);
	}

	
	private void delete() {
		userRepository.delete(user);
		changeHandler.onChange();
	}

	private void save() {
		userRepository.save(user);
		changeHandler.onChange();
	}
	
	public final void editUser(User u) {
		if (u == null) {
			setVisible(false);
			return;
		}
		final boolean persisted = u.getId() != null;
		if (persisted) {
			user = userRepository.findById(u.getId()).get();
		}
		else {
			user = u;
		}
		cancel.setVisible(persisted);

		binder.setBean(user);

		setVisible(true);

		name.focus();
	}
	
	public void setChangeHandler(ChangeHandler h) {
		changeHandler = h;
	}
}
