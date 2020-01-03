package com.gain.java.knowledge.actuator.controller;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="gainjavaknowledge", enableByDefault=true)
public class CustomEndpoints {

	@ReadOperation
	public UserDetail getDetails(){
		return new UserDetail(1, "karan", "gain java");
	}
}
