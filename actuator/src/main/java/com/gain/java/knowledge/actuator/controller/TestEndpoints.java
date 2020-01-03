package com.gain.java.knowledge.actuator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")
public class TestEndpoints {

	@GetMapping
	public String getMessage(){
		return "Gain Java Knowledge";
	}
}
