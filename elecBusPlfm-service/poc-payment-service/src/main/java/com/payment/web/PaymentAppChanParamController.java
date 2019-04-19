package com.payment.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.payment.PaymentAppChanParam;
import com.payment.service.impl.PaymentAppChanParamServiceImpl;

@Controller
@RequestMapping("paymenappChanParam")
public class PaymentAppChanParamController extends BaseController<PaymentAppChanParamServiceImpl,PaymentAppChanParam> {

}