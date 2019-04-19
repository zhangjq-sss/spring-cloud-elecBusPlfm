package com.order.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.order.OrderCart;
import com.order.service.impl.OrderCartServiceImpl;

@Controller
@RequestMapping("orderCart")
public class OrderCartController extends BaseController<OrderCartServiceImpl,OrderCart> {

}