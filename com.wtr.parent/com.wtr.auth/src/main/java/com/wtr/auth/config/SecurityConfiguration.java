package com.wtr.auth.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@EnableOAuth2Sso
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		// 设置默认的加密方式
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * 认证管理器：
	 * 1、认证信息提供方式（用户名、密码、当前用户的资源权限
	 * 2、可采用内存存储方式，也可能采用数据库方式
	 * @param auth
	 * @throws Exception
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		String password = passwordEncoder().encode("321");
		System.out.println("加密之后的密码： " + password);
		auth.inMemoryAuthentication().withUser("haha")
			.password(password).authorities("ADMIN");
	}
	
	/**
	 * 资源权限配置
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
			.and().authorizeRequests() // 认证请求
			.anyRequest().authenticated() // 所有进入应用的HTTP请求都要进行认证 
		;
//		http.antMatcher("/**")
//			// 所有请求都得经过认证和授权
//			.authorizeRequests().anyRequest().authenticated()
//			.and().authorizeRequests().antMatchers("/", "/anon").permitAll()
//			.and()
//			.csrf().disable()
//			// 退出的URL
//			.logout().logoutUrl("/logout").permitAll()
//			// 退出成功后返回登录界面
//			.logoutSuccessUrl("/login")
//		;
	}
	
}
