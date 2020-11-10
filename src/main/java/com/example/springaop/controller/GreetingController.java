package com.example.springaop.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springaop.beans.Greeting;
import com.example.springaop.services.intf.GreetingSvc;

@RestController
public class GreetingController {
	
	@Autowired
	@Qualifier("greeting.real")
	private GreetingSvc greetingSvc;

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/greetingSvc")
	public String greetingSvc(@RequestParam(value = "name", defaultValue = "World") String name) {
		return greetingSvc.sayHello("Derrick");
	}
}