package com.wtr.cultivate.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wtr.cultivate.core.client.TestClient;
import com.wtr.cultivate.web.A;

@RestController
@RequestMapping("/test")
public class TestController {

	public static void main(String[] args) {
		System.out.println(B.b(() -> {return "123";}));
		var list = "2";
		System.out.println(list.getClass());
		String key = "1";
		var mapper = new ObjectMapper();
	}
	
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
	private static class B {
		public static String b(A a) {
			return a.a();
		}
	}
}

