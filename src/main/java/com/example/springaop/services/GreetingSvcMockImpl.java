package com.example.springaop.services;

import org.springframework.stereotype.Service;

import com.example.springaop.services.intf.GreetingSvc;

@Service("greeting.mock")
public class GreetingSvcMockImpl implements GreetingSvc {

	@Override
	public String sayHello(String str) {
		return "Mock say " + str;
	}

}
