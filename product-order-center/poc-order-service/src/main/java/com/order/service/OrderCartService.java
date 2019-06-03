package com.order.service;

import com.common.base.ICRUDService;
import com.common.msg.RrcResponse;
import com.domain.order.OrderCart;
import com.domain.order.model.request.AddShopingCartModel;

public interface OrderCartService extends ICRUDService<OrderCart>{

	RrcResponse addShopingCart(AddShopingCartModel addShopingCartModel);
	
	RrcResponse addShopingCartByRedis(AddShopingCartModel addShopingCartModel);
}
