package com.application.views.admin;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.application.views.main.MainView;

@Route(value = "admin", layout = MainView.class)
@PageTitle("Admin")
public class AdminView extends Div {

    public AdminView() {
        addClassName("admin-view");
        add(new Text("Content placeholder"));
    }

}
