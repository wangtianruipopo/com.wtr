package com.wtr.cultivate.business.service;

import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import com.wtr.cultivate.core.client.TestClient;

@RestController
public class TestService implements TestClient {

	@Override
	public String testPost(Map<String, Object> params) {
		return "1";
	}
	
	@Override
	public String testGet(Map<String, Object> params) {
		return params.toString();
	}
	
}
