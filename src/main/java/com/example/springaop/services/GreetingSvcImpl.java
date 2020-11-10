package com.example.springaop.services;

import org.springframework.stereotype.Service;

import com.example.springaop.services.intf.GreetingSvc;

@Service("greeting.real")
public class GreetingSvcImpl implements GreetingSvc {

	@Override
	public String sayHello(String str) {
		return "Real say " + str;
	}

}
