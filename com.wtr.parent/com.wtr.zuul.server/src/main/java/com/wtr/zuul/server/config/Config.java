package com.wtr.zuul.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.wtr.auth.config.MyPasswordEncoder;
import com.wtr.auth.config.SecurityConfiguration;
import com.wtr.auth.user.UserService;

@Configuration
public class Config {

	@Bean
	public PasswordEncoder getMyPasswordEncoder() {
		return new MyPasswordEncoder();
	}
	
	@Bean
	public UserService getUserDetailsService() {
		return new UserService();
	}
	
	@Bean
	public SecurityConfiguration getSecruity() {
		return new SecurityConfiguration();
	}
	
}
