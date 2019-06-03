package com.payment.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.payment.PaymentChanParam;
import com.payment.service.impl.PaymentChanParamServiceImpl;

@Controller
@RequestMapping("paymenchanParam")
public class PaymentChanParamController extends BaseController<PaymentChanParamServiceImpl,PaymentChanParam> {

}