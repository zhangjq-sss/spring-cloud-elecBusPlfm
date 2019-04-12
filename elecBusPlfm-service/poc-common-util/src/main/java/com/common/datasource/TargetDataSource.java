package com.common.datasource;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface TargetDataSource {
	
	/**
	 * @see DataSourceAdvice#before(java.lang.reflect.Method, Object[], Object)
	 * @see DynamicDataSource#determineCurrentLookupKey()
	 * @return 指定数据源key
	 */
	String value();
	
}
