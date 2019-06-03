package com.order.service.rabbitmq;

import java.util.UUID;

import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.order.OrderCart;

@Service
public class RabbitmqSenderServiceImpl implements RabbitmqSenderService{

	@Autowired
    private RabbitTemplate template;
	@Override
	public boolean updateProStockSend(OrderCart cart) {
		CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
		//更新库存
		template.convertAndSend("exchange-delay", "updateProStock", cart, message ->{
	        message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
	        message.getMessageProperties().setDelay(1 * (60*1000));   // 毫秒为单位，指定此消息的延时时长
	        return message;
	    },correlationId);
		return true;
	}

	@Override
	public boolean createCartSend(OrderCart cart) {
		CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
		template.convertAndSend("exchange", "createCart", cart, correlationId);
		return true;
	}

	@Override
	public boolean compensateProStockSend(OrderCart cart) {
		CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
		template.convertAndSend("exchange", "compensateProStock", cart, correlationId);
		return false;
	}

}
