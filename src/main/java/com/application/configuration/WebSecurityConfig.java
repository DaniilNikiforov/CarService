package com.application.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.http.HttpMethod;

import com.application.services.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserService userService;
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
        .csrf().disable() // CSRF is handled by Vaadin: https://vaadin.com/framework/security
        .exceptionHandling().accessDeniedPage("/accessDenied")
        .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
        .and().logout().logoutSuccessUrl("/")
        .and()
        .authorizeRequests()
        // allow Vaadin URLs and the login URL without authentication
        .regexMatchers("/frontend/.*", "/VAADIN/.*", "/login.*", "/accessDenied").permitAll()
        .regexMatchers(HttpMethod.POST, "/\\?v-r=.*").permitAll()
        // deny any other URL until authenticated
        .antMatchers("/**").fullyAuthenticated();
	}

}
