package com.wtr.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wtr.auth.po.User;

@Mapper
public interface UserMapper extends BaseMapper<User>{

	@Select(" select id," +
			"		username," +
			"		password," +
			"		nickname," +
			"		create_date," +
			"		last_login_time," +
			"		last_login_adress," +
			"		account_non_expired," +
			"		account_non_locked," +
			"		credentials_non_expired," +
			"		enabled" +
			" from user where username = #{username}"
	)
	User selectByUsername(String username);
	
}
