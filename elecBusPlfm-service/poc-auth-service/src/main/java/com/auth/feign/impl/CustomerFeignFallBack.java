package com.auth.feign.impl;

import org.springframework.stereotype.Component;

import com.auth.feign.CustomerFeignController;
import com.domain.customer.model.response.RespCustomerModel;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomerFeignFallBack implements CustomerFeignController{

	@Override
	public RespCustomerModel selectByUsernameAndPassword(String username, String password) {
		log.info("请求异常");
		return null;
	}


}
