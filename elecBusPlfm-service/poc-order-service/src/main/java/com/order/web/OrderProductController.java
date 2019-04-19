package com.order.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.order.OrderProduct;
import com.order.service.impl.OrderProductServiceImpl;

@Controller
@RequestMapping("orderProduct")
public class OrderProductController extends BaseController<OrderProductServiceImpl,OrderProduct> {

}