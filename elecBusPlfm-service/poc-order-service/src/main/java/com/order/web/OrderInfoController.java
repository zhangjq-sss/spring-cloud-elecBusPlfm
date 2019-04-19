package com.order.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.order.OrderInfo;
import com.order.service.impl.OrderInfoServiceImpl;

@Controller
@RequestMapping("orderInfo")
public class OrderInfoController extends BaseController<OrderInfoServiceImpl,OrderInfo> {

}