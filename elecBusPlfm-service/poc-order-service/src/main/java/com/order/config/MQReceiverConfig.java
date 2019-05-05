package com.order.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.domain.order.OrderCart;
import com.order.service.impl.OrderCartServiceImpl;

@Configuration
public class MQReceiverConfig {
	@Autowired
	private OrderCartServiceImpl orderCartService;
	
	@RabbitListener(queues = "createCart") // 监听器监听指定的Queue
	public void orderCart(OrderCart cart) {
		orderCartService.insertSelective(cart);
	}

}
