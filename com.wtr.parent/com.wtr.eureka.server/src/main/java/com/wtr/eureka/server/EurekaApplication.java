package com.wtr.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
* <b>Description:</b><br> Eureka服务启动类
* @author <a href="http://xxxx" target="_blank">wangtianrui</a>
* @version 1.0
* @Note
* <b>ProjectName:</b> com.wtr.eureka.server
* <br><b>PackageName:</b> com.wtr.eureka.server
* <br><b>ClassName:</b> EurekaApplication
* <br><b>Date:</b> 2020年6月20日 上午1:33:54
*/
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}
	
}
