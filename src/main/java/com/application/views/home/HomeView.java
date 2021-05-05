package com.application.views.home;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.application.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Home")
public class HomeView extends Div {

    public HomeView() {
        addClassName("home-view");
        add(new Text("Content placeholder"));
    }

}
