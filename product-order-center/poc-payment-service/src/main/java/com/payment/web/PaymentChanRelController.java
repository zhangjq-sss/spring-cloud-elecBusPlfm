package com.payment.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.payment.PaymentChanRel;
import com.payment.service.impl.PaymentChanRelServiceImpl;

@Controller
@RequestMapping("paymenchanRel")
public class PaymentChanRelController extends BaseController<PaymentChanRelServiceImpl,PaymentChanRel> {

}