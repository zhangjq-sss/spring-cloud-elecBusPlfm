package com.order.service.rabbitmq;

import com.domain.order.OrderCart;

public interface RabbitmqSenderService {
	
	boolean updateProStockSend(OrderCart cart);
	
	boolean createCartSend(OrderCart cart);
	
	//补偿机制商品数量+1
	boolean compensateProStockSend(OrderCart cart);
}
