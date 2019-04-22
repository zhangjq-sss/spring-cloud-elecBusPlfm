package com.customer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.base.BaseController;
import com.customer.service.CustomerService;
import com.customer.service.impl.CustomerServiceImpl;
import com.domain.customer.Customer;
import com.domain.customer.model.response.RespCustomerModel;

@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController<CustomerServiceImpl,Customer> {

	@Autowired
	private CustomerService customerService;
	
	@ResponseBody
	@RequestMapping(value="/selectByUsernameAndPassword", method=RequestMethod.POST)
	public RespCustomerModel selectByUsernameAndPassword(String username, String password) {
		return customerService.selectByUsernameAndPassword(username, password);
	}
	
	@ResponseBody
	@RequestMapping(value="/updateCustToken", method=RequestMethod.POST)
	public boolean updateCustToken(Integer custId, String token) {
		return customerService.updateCustToken(custId, token);
	}
}