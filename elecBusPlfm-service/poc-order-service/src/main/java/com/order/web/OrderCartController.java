package com.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.base.BaseController;
import com.common.msg.RrcResponse;
import com.domain.order.OrderCart;
import com.domain.order.model.request.AddShopingCartModel;
import com.order.service.OrderCartService;
import com.order.service.impl.OrderCartServiceImpl;

@Controller
@RequestMapping("orderCart")
public class OrderCartController extends BaseController<OrderCartServiceImpl,OrderCart> {
	
	@Autowired
	private OrderCartService orderCartService;
	
	@ResponseBody
	@RequestMapping(value="/addShopingCart", method=RequestMethod.POST)
	public RrcResponse addShopingCart(AddShopingCartModel addShopingCartModel) {
		return orderCartService.addShopingCart(addShopingCartModel);
	}

}