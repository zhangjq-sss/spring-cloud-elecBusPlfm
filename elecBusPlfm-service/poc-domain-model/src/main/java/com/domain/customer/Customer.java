package com.domain.customer;

import lombok.Data;

@Data
public class Customer {
	private Long id;
	private String username;
	private String password;
	private String mobile;
	private String openid;
	private boolean isLockedType;
	private boolean isUserStatus;
	private String token;
	
	public static Customer varifyCustomerByPassword(String username, String password) {
		Customer customer = new Customer();
        customer.setId(1l);
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setLockedType(false);
        customer.setUserStatus(false);
        return customer;
	}
	
	public static Customer varifyCustomerByOpeinid(String openid) {
		Customer customer = new Customer();
        customer.setId(2l);
        customer.setUsername("zjq");
        customer.setOpenid(openid);
        customer.setLockedType(false);
        customer.setUserStatus(false);
        return customer;
	}
	
	public static Customer varifyCustomerByToken(String token) {
		Customer customer = new Customer();
        customer.setId(2l);
        customer.setUsername("lxq");
        customer.setToken(token);
        customer.setLockedType(false);
        customer.setUserStatus(false);
        return customer;
	}
}
