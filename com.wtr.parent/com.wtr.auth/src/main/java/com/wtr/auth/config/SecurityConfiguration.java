package com.wtr.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService customUserDetailsService;
	
	/**
	 * 未登录
	 */
	@Autowired
	private AuthenticationEntryPoint ajaxAuthenticationEntryPoint;
	
	/**
	 * 登录成功
	 */
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	/**
	 * 登录失败
	 */
	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;
	
	/**
	 * 无权访问
	 */
	@Autowired
	private AccessDeniedHandler accessDeniedHandler;
	
	/**
	 * 注销
	 */
	@Autowired
	private LogoutSuccessHandler logoutSuccessHandler;
	
	/**
	 * 认证管理器
	 * 1、认证信息提供方式(用户名、密码、当前用户的资源权限)
	 * 2、可采用内存存储方式，也可能采用数据库方式
	 * @param auth
	 * @throws Exception
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService);
	}
	
	/**
	 * 资源权限配置
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.cors()
			.and()
			.csrf().disable()
			.httpBasic().authenticationEntryPoint(ajaxAuthenticationEntryPoint)
			.and().authorizeRequests()
			.anyRequest()
			// 其他 url 需要身份认证
			.authenticated()
			.and()
			// 开启登录
			.formLogin()
			.successHandler(authenticationSuccessHandler)
			.failureHandler(authenticationFailureHandler)
			.and()
			.logout()
			.logoutSuccessHandler(logoutSuccessHandler)
			.permitAll();
		// 无权访问 JSON 格式的数据
		http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}
	
}
