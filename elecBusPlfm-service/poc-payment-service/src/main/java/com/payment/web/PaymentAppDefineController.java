package com.payment.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.payment.PaymentAppDefine;
import com.payment.service.impl.PaymentAppDefineServiceImpl;

@Controller
@RequestMapping("paymenappDefine")
public class PaymentAppDefineController extends BaseController<PaymentAppDefineServiceImpl,PaymentAppDefine> {

}