package com.gain.java.knowledge.SpringBootCache.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ExcecutionTimeInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(ExcecutionTimeInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("----pre Handle----");
		logger.info("Request URL : "+request.getRequestURI());
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		logger.info("----post Handle----");
		logger.info("Request URL : "+request.getRequestURI());
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		logger.info("----after completion Handle----");
		logger.info("Request URL : "+request.getRequestURI());
		long executed = System.currentTimeMillis() - (long) request.getAttribute("startTime");
		logger.info("exection time ms : {}", executed);
	}

	
}
