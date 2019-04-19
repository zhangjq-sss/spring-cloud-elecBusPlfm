package com.order.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.order.OrderAfterSale;
import com.order.service.impl.OrderAfterSaleServiceImpl;

@Controller
@RequestMapping("orderAfterSale")
public class OrderAfterSaleController extends BaseController<OrderAfterSaleServiceImpl,OrderAfterSale> {

}