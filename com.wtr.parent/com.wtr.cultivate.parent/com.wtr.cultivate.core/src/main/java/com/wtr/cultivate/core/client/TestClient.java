package com.wtr.cultivate.core.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "cultivateBusiness", url = "http://localhost:10001/")
@RequestMapping("/testClient")
public interface TestClient {

	@PostMapping("/testPost")
	String testPost(@RequestBody Map<String, Object> params);
	
	@PostMapping("/testGet")
	String testGet(@RequestBody Map<String, Object> params);
	
}
