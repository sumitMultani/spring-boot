package com.gain.java.knowledge.actuator.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthCheckup implements HealthIndicator{

	@Override
	public Health health() {
		return Health.up().withDetail("SUCCESS CODE", "201").build();
	}

}
