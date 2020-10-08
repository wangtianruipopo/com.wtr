package com.wtr.cultivate.business.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.wtr.cultivate.business.mapper.AbcMapper;
import com.wtr.cultivate.business.mapper.TestMapper;
import com.wtr.cultivate.core.client.TestClient;
import com.wtr.cultivate.entity.master.test.Abc;
import com.wtr.cultivate.entity.master.test.Test;

@RestController
public class TestService implements TestClient {

	@Autowired
	private TestMapper mapper;
	@Autowired
	private AbcMapper abcMapper;
	
	@Override
	public String testPost(Map<String, Object> params) {
		return "1";
	}
	
	@Override
	public String testGet(Map<String, Object> params) {
		Test test = mapper.selectById("861fbc54-03c2-11eb-bcfe-002b672bf27c");
		System.out.println(test.getName());
		Abc abc = abcMapper.selectById("1");
		System.err.println(abc.getName());
		return test.getName();
	}
	
}
