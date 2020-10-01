package com.wtr.cultivate.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class CultivateBusinessApplication {
	public static void main(String[] args) {
		SpringApplication.run(CultivateBusinessApplication.class, args);
	}
}