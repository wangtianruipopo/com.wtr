package com.wtr.db.mysql.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages = {"com.wtr.*"},
	sqlSessionFactoryRef = "sqlSessionFactoryHosDataSource")
public class MybatisHosConfig {
	
	/**
	 * 自动读取DataSource配置文件
	 * @return
	 */
	@Primary
	@Bean(name = "datasource1")
	public DataSourceProperties hosProperties() {
		return new DataSourceProperties();
	}
	
	@Primary
	@Bean(name = "datasource1")
	@ConfigurationProperties("spring.datasource.datasource1")
	public DataSource hosDataSource(@Qualifier("datasource1") DataSourceProperties properties) {
		DataSource dataSource = properties.initializeDataSourceBuilder()
			.type(DruidDataSource.class).build();
		return dataSource;
	}
	
	@Primary
	@Bean(name = "sqlSessionFactoryDataSource1")
	public SqlSessionFactory sqlSessionFactoryHosDataSource(@Qualifier("hosDataSource")DataSource datasource1) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		configuration.setMapUnderscoreToCamelCase(true);
		factoryBean.setConfiguration(configuration);
		
		// 使用datasource1数据源, 连接datasource1库
		factoryBean.setDataSource(datasource1);
		
		// 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
		// 指定entity和mapper.xml的路径
//		factoryBean.setTypeAliasesPackage("com.wtr.db.mysql.*");
//		factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/datasource1/**/*Mapper.xml"));
		return factoryBean.getObject();
	}
	
	@Primary
	@Bean
	public SqlSessionTemplate sqlSessionTemplateDataSource1(@Qualifier("sqlSessionFactoryDataSource1") SqlSessionFactory sqlSessionTemplateDataSource1) throws Exception {
		//使用注解中配置的Factory
		SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionTemplateDataSource1);
		return template;
	}
	
	@Primary
	@Bean
	public PlatformTransactionManager datasource1TransactionManager(@Qualifier("hosDataSource") DataSource prodDataSource) {
		return new DataSourceTransactionManager(prodDataSource);
	}
	
}
