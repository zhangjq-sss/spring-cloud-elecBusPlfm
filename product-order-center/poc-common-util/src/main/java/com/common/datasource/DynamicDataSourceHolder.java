package com.common.datasource;

public class DynamicDataSourceHolder {
	
	private static final ThreadLocal<String> HOLDER = new ThreadLocal<String>();
	
	public static String get(){
		return HOLDER.get();
	}
	public static void set(String name){
		HOLDER.set(name);
	}
	
	public static void remove(){
		HOLDER.remove();
	}
}
