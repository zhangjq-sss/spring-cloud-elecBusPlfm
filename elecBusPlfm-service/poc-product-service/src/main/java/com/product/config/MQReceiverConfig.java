package com.product.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.domain.order.OrderCart;
import com.product.service.ProducskuService;

@Configuration
public class MQReceiverConfig {
	@Autowired
	private ProducskuService producskuService;

	@RabbitListener(queues = "updateProStock") // 监听器监听指定的Queue
	public void updateProStock(OrderCart cart) {
		producskuService.updateProdCount(cart.getSkuId(), cart.getProductCount());
	}
}
