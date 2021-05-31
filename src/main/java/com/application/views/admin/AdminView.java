package com.application.views.admin;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.application.views.main.MainView;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.application.repositories.UserRepository;
import com.application.entities.User;

@PageTitle("Admin")
public class AdminView extends Div {

	@Autowired
	private UserRepository userRepository;
	
	private Grid<User> grid;
	
	private TextField filter;
	
    public AdminView(UserRepository userRepository) {
        addClassName("admin-view");
        
        this.userRepository = userRepository;
        this.grid = new Grid<>(User.class);
        this.filter = new TextField();
        
        HorizontalLayout actions = new HorizontalLayout(filter);
        
        actions.addClassName("header");
        
        add(actions, grid);
        grid.setHeight("600px");
		grid.setColumns("id", "name", "surname", "username");
		grid.getColumnByKey("id").setWidth("90px").setFlexGrow(0);
		
		filter.setPlaceholder("Filter by username");
		
		filter.setValueChangeMode(ValueChangeMode.EAGER);
		filter.addValueChangeListener(e -> listCustomers(e.getValue()));
		
		listCustomers(null);
    }
    
    private void listCustomers(String filterText) {
		if (StringUtils.isEmpty(filterText)) {
			grid.setItems(userRepository.findAll());
		}
		else {
			grid.setItems(userRepository.findByUsernameStartsWithIgnoreCase(filterText));
		}
	}
    
	public interface ChangeHandler {
		void onChange();
	}
    
}
