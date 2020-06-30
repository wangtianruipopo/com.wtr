package com.wtr.cultivate.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wtr.cultivate.core.client.TestClient;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestClient client;
	
	@PostMapping("/testPost")
	public String testPost(@RequestBody Map<String, Object> params) {
		return client.testPost(params);
	}
	
	@GetMapping("/testGet")
	public String testGet() {
		Map<String, Object> params = new HashMap<>();
		params.put("a", "bbbb嗡嗡嗡");
		return client.testGet(params);
	}
}
