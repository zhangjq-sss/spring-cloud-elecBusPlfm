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
		log.info("查询用户密码异常");
		return null;
	}

	@Override
	public boolean updateCustToken(Integer custId, String token) {
		log.info("更新用户token异常");
		return false;
	}

	@Override
	public RespCustomerModel selectByMobile(String mobile) {
		log.info("根据手机号查询用户异常");
		return null;
	}


}
