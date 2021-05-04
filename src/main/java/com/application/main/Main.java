package com.application.main;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import javax.sql.DataSource;

import com.vaadin.flow.component.page.AppShellConfigurator;

@SpringBootApplication
public class Main extends SpringBootServletInitializer implements AppShellConfigurator{
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
    }
    
    @Bean
    public DataSource datasource() {
    	return DataSourceBuilder.create()
    			.driverClassName("com.mysql.cj.jdbc.Driver")
    			.url("jdbc:mysql://localhost:3306/car_service")
    			.username("root")
    			.password("QgfM3R2rLtCr")
    			.build();
    }
    
}
