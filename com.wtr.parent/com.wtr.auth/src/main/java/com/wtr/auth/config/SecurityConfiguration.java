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
		// ����Ĭ�ϵļ��ܷ�ʽ
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * ��֤��������
	 * 1����֤��Ϣ�ṩ��ʽ���û��������롢��ǰ�û�����ԴȨ��
	 * 2���ɲ����ڴ�洢��ʽ��Ҳ���ܲ������ݿⷽʽ
	 * @param auth
	 * @throws Exception
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		String password = passwordEncoder().encode("321");
		System.out.println("����֮������룺 " + password);
		auth.inMemoryAuthentication().withUser("haha")
			.password(password).authorities("ADMIN");
	}
	
	/**
	 * ��ԴȨ������
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
			.and().authorizeRequests() // ��֤����
			.anyRequest().authenticated() // ���н���Ӧ�õ�HTTP����Ҫ������֤ 
		;
//		http.antMatcher("/**")
//			// �������󶼵þ�����֤����Ȩ
//			.authorizeRequests().anyRequest().authenticated()
//			.and().authorizeRequests().antMatchers("/", "/anon").permitAll()
//			.and()
//			.csrf().disable()
//			// �˳���URL
//			.logout().logoutUrl("/logout").permitAll()
//			// �˳��ɹ��󷵻ص�¼����
//			.logoutSuccessUrl("/login")
//		;
	}
	
}
