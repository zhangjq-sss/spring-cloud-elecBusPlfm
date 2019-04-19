package com.order.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.order.OrderLogistics;
import com.order.service.impl.OrderLogisticsServiceImpl;

@Controller
@RequestMapping("orderLogistics")
public class OrderLogisticsController extends BaseController<OrderLogisticsServiceImpl,OrderLogistics> {

}