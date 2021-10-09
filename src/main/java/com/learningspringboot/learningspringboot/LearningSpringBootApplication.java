package com.learningspringboot.learningspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class LearningSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringBootApplication.class, args);
	}

	@RequestMapping("/by")
	String sayBy() {
		return "BYE BYE";
	}

	@GetMapping("/available")
	String sayAvailable() {
		return "available";
	}

}

@RestController
class HelloController {

	@GetMapping("/hello")
	String sayHello() {
		return "Hello";
	}

}
