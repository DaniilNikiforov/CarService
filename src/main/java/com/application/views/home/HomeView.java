package com.application.views.home;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.VaadinSession;
import com.application.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.services.CarService;
import com.application.services.ColorService;
import com.application.services.CarTypeService;
import com.application.entities.User;
import com.application.entities.Car;

@PageTitle("Home")
public class HomeView extends Div {

	@Autowired
	private CarService carService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private CarTypeService carTypeService;
	
	private User user = VaadinSession.getCurrent().getAttribute(User.class);
	
    public HomeView(CarService carService, ColorService colorService, CarTypeService carTypeService) {
        
    	this.carService = carService;
    	this.colorService = colorService;
    	this.carTypeService = carTypeService;
    	
    	setClassName("home-view");
        
        H1 title = new H1("Configure you car!");
        
        VerticalLayout layout = new VerticalLayout();
        
        IntegerField weightField = new IntegerField("Weight");
        weightField.setMin(100);
        
        RadioButtonGroup<String> colorRadioGroup = new RadioButtonGroup<String>();
        
        colorRadioGroup.setLabel("Color");
        colorRadioGroup.setItems("Red", "Green", "Blue");
        colorRadioGroup.setValue("Red");
        
    	RadioButtonGroup<String> typeRadioGroup = new RadioButtonGroup<String>();
        
    	typeRadioGroup.setLabel("Type");
        typeRadioGroup.setItems("Jeep", "Sportcar", "Truck");
        typeRadioGroup.setValue("Red");
        
        
        Button button = new Button("Order!");
		
		button.addClickListener(event -> {
        	Car car = Car.builder()
        	.weight(weightField.getValue())
        	.color(colorService.getColorByName(colorRadioGroup.getValue().toUpperCase()).get())
        	.carType(carTypeService.getCarTypeByName(typeRadioGroup.getValue().toUpperCase()).get())
        	.owner(user)
        	.build();
        	
        	carService.createOrder(car);
        });
        
        layout.add(weightField, colorRadioGroup, typeRadioGroup, button);
        
        add(title, layout);
        
    }

}
