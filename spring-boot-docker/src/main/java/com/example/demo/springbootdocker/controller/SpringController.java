package com.example.demo.springbootdocker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")
public class SpringController {

	@GetMapping("/{message}")
	public String getMessage(@PathVariable String message){
		return message;
	}
}
