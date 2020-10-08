package com.wtr.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wtr.auth.mapper.UserMapper;
import com.wtr.auth.po.User;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.err.println("请求用户名：" + username);
		User user = mapper.selectByUsername(username);
		// 1、根据请求用户名向数据库中查询用户信息
		if (user == null) {
			throw new UsernameNotFoundException("用户名或密码错误"); 
		}
		
		// 如果有此用户信息, 假设数据库查询到的用户密码是 1234 
//		String password = passwordEncoder.encode("1234");
		
		// 2、查询用户权限
		
		// 3、封装用户信息: username用户名,password数据库中的密码,authorities资源权限标识符
		// SpringSecurity 底层会校验是否身份合法。
//		return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN"));
		return user;
	}

}
