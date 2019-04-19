package com.auth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auth.feign.impl.CustomerFeignFallBack;
import com.domain.customer.model.response.RespCustomerModel;

@FeignClient(name="poc-customer-service", fallback=CustomerFeignFallBack.class)
//@FeignClient("poc-customer-service")
public interface CustomerFeignController {

	@ResponseBody
	@RequestMapping(value="/customer/selectByUsernameAndPassword", method=RequestMethod.POST)
	RespCustomerModel selectByUsernameAndPassword(@RequestParam("username") String username, @RequestParam("password") String password);
}
