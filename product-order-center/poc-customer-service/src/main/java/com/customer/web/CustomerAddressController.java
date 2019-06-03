package com.customer.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.customer.service.impl.CustomerAddressServiceImpl;
import com.domain.customer.CustomerAddress;

@Controller
@RequestMapping("customerAddress")
public class CustomerAddressController extends BaseController<CustomerAddressServiceImpl,CustomerAddress> {

}