package com.wtr.cultivate.core.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cultivateBusiness")
@RequestMapping("/testClient")
public interface TestClient {

	@PostMapping("/testPost")
	String testPost(@RequestBody Map<String, Object> params);
	
	@GetMapping("/testGet")
	String testGet(@RequestParam("params") Map<String, Object> params);
	
}
