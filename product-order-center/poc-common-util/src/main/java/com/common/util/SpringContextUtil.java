package com.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware {
	private static ApplicationContext appContext; 

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		appContext = applicationContext;
	}
	
	public static ApplicationContext getApplicationContext() {
		return appContext;
	}
	
	public static Object getBean(String name) {
		return appContext.getBean(name);
	}
}
