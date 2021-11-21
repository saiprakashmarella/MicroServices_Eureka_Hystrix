package com.example.demo.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Value("${spring.profiles.active}")
	private String profile;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		if(profile.equals("dev")) {
			web.ignoring().antMatchers("/**");
		}
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/add")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}

	
}
