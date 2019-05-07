package com.product.service.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqSenderServiceImpl implements RabbitmqSenderService{

	@Autowired
    private RabbitTemplate template;

}
