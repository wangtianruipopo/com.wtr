package com.wtr.auth.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * 认证管理器
	 * 1、认证信息提供方式（用户名、密码、当前用户的资源权限
	 * 2、可采用内存存储方式，也可能采用数据库方式
	 * @param auth
	 * @throws Exception
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
        .inMemoryAuthentication()
        .passwordEncoder(new MyPasswordEncoder())
        .withUser("user")
        .password("password")
        .roles("USER");

	}
	
	/**
	 * 资源权限配置
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
			.and().authorizeRequests()
			.anyRequest().authenticated()
		;
	}
	
}
