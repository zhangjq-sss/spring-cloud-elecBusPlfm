package com.customer.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.customer.service.impl.CustomerCertificationServiceImpl;
import com.domain.customer.CustomerCertification;

@Controller
@RequestMapping("customerCertification")
public class CustomerCertificationController extends BaseController<CustomerCertificationServiceImpl,CustomerCertification> {

}