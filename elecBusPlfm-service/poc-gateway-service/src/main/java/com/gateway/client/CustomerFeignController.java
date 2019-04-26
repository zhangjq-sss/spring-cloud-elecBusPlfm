package com.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.domain.customer.model.response.RespCustomerModel;
import com.gateway.client.fallback.CustomerFeignFallBack;

@FeignClient(name="poc-customer-service", fallback=CustomerFeignFallBack.class)
//@FeignClient("poc-customer-service")
public interface CustomerFeignController {

	@ResponseBody
	@RequestMapping(value="/customer/selectByUsernameAndPassword", method=RequestMethod.POST)
	RespCustomerModel selectByUsernameAndPassword(@RequestParam("username") String username, @RequestParam("password") String password);
	
	@ResponseBody
	@RequestMapping(value="/customer/updateCustToken", method=RequestMethod.POST)
	public boolean updateCustToken(@RequestParam("custId") Integer custId, @RequestParam("token") String token) ;
	
	@ResponseBody
	@RequestMapping(value="/customer/selectByMobile", method=RequestMethod.POST)
	RespCustomerModel selectByMobile(@RequestParam("mobile") String mobile);
}
