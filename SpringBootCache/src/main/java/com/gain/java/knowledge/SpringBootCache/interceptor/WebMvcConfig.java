package com.gain.java.knowledge.SpringBootCache.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(executionTime());
	}
	
	@Bean
	public ExcecutionTimeInterceptor executionTime() {
		return new ExcecutionTimeInterceptor();
	}
}
