package org.spring.springboot.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.Interceptor.TestInterceptor;

@WebListener
public class TestListener implements HttpSessionListener {

	private static final Logger logger = LoggerFactory.getLogger(TestInterceptor.class);
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		logger.info("-----TestListener----------------Session 被创建-------------------");

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		logger.info("-----TestListener----------------Session 被销毁-------------------");

	}

}
