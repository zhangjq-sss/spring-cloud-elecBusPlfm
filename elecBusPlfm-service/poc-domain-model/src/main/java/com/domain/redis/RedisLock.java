package com.domain.redis;

import lombok.Data;

@Data
public class RedisLock {
	private String name;
    private String value;
	public RedisLock(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
    
}
