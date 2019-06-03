package com.payment.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.payment.PaymentLog;
import com.payment.service.impl.PaymentLogServiceImpl;

@Controller
@RequestMapping("paymenlog")
public class PaymentLogController extends BaseController<PaymentLogServiceImpl,PaymentLog> {

}