package com.wtr.cultivate.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
* <b>Description:</b><br> 
* @author <a href="http://xxxx" target="_blank">wangtianrui</a>
* @version 1.0
* @Note
* <b>ProjectName:</b> com.wtr.cultivate.web
* <br><b>PackageName:</b> com.wtr.cultivate.web
* <br><b>ClassName:</b> CultivateWebApplication
* <br><b>Date:</b> 2020年6月20日 上午2:03:17
*/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients({"com.wtr"})
public class CultivateWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(CultivateWebApplication.class, args);
	}
}
