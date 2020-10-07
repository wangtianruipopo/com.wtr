package com.wtr.cultivate.business.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wtr.db.mysql.config.MybatisHosConfig;

@Configuration
@MapperScan(basePackages = {"com.wtr.cultivate.business.po"}, sqlSessionFactoryRef = "sqlSessionFactoryHosDataSource")
public class Config {

	@Bean
	public MybatisHosConfig basisDataSourceConfig() {
		return new MybatisHosConfig();
	}
	
}
