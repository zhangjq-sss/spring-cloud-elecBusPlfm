package com.order.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.order.OrderLogisticsFlow;
import com.order.service.impl.OrderLogisticsFlowServiceImpl;

@Controller
@RequestMapping("orderLogisticsFlow")
public class OrderLogisticsFlowController extends BaseController<OrderLogisticsFlowServiceImpl,OrderLogisticsFlow> {

}