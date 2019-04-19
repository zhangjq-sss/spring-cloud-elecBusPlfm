package com.payment.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.payment.PaymentRecord;
import com.payment.service.impl.PaymentRecordServiceImpl;

@Controller
@RequestMapping("paymenrecord")
public class PaymentRecordController extends BaseController<PaymentRecordServiceImpl,PaymentRecord> {

}