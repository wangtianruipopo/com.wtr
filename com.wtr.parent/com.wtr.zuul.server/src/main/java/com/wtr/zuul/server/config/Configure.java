package com.wtr.zuul.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wtr.auth.config.SecurityConfiguration;

@Configuration
public class Configure {

	@Bean
	public SecurityConfiguration getSecruity() {
		return new SecurityConfiguration();
	}
	
}
