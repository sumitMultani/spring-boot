package com.example.demoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoe.model.User;
import com.example.demoe.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/user/id/{user-id}")
	public ResponseEntity<User> getUserById(@PathVariable("user-id") Long userId) {
		User user = userService.getUserById(userId);
		return new ResponseEntity<User>(user , HttpStatus.OK);
	}
}
