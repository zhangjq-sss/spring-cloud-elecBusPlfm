package com.customer.service;

import com.domain.customer.model.response.RespCustomerModel;

public interface CustomerService {

	RespCustomerModel selectByUsernameAndPassword(String username, String password);
	
	boolean updateCustToken(Integer custId, String token);
	
	RespCustomerModel selectByMobile(String mobile);
}
