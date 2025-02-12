package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
* The controller will ensure that the class will control how the object will be used
* it is done using 2 parts
* 	1. get mapping
*  2. request parameters
*/

@RestController
public class GreetingController {
	private static final String template="Hello, %s!";
	private static final String surname="%s!";
	private static final String location="%s!";
	//AtomicLong is data type that will handle huge data
	private final AtomicLong atomicLong=new AtomicLong();
	
	@GetMapping("/getting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name,
			@RequestParam(value = "surname", defaultValue = "Hyderbad") String surname,
            @RequestParam(value = "location", defaultValue = "21") String location)
	{ 	
		String message = String.format("Hello, %s %s! You are located in %s.", name, surname, location);
		return new Greeting(atomicLong.incrementAndGet(), message);
		//return new Greeting(atomicLong.incrementAndGet(), String.format(template, name, surname, location)); 	
	}
}