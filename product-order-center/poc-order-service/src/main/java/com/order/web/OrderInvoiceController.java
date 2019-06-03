package com.order.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.order.OrderInvoice;
import com.order.service.impl.OrderInvoiceServiceImpl;

@Controller
@RequestMapping("orderInvoice")
public class OrderInvoiceController extends BaseController<OrderInvoiceServiceImpl,OrderInvoice> {

}