package com.order.config;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@Component
public class MQSenderConfig  implements ConfirmCallback,ReturnCallback{
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	@PostConstruct
	public void init(){
		rabbitTemplate.setReturnCallback(this);
		rabbitTemplate.setConfirmCallback(this);
	}
	
	@Bean(name="orderCart")
    public Queue queueMessage() {
        return new Queue("createCart");
    }

    @Bean(name="productSku")
    public Queue queueMessages() {
        return new Queue("updateProStock");
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }
    
    @Bean
    public TopicExchange exchangeDelay() {
    	TopicExchange topicExchange = new TopicExchange("exchange-delay");
    	topicExchange.setDelayed(true);
        return topicExchange;
    }

    @Bean
    Binding bindingExchangeMessage(@Qualifier("orderCart") Queue queueMessage) {
        return BindingBuilder.bind(queueMessage).to(exchange()).with("createCart");
    }

    @Bean
    Binding bindingExchangeMessages(@Qualifier("productSku") Queue queueMessages) {
        return BindingBuilder.bind(queueMessages).to(exchangeDelay()).with("updateProStock");//*表示一个词,#表示零个或多个词
    }
    

	@Override
	//如果消息没有到exchange,则confirm回调,ack=false
	//如果消息到达exchange,则confirm回调,ack=true
	//消费者手动进行确认
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		if (ack) {
			log.info("消息id:" + correlationData.getId()+"------消息发送确认成功");
		} else {
			log.info("消息id:" + correlationData.getId()+"------消息发送确认失败:" + cause);
		}
	}

	@Override
	//exchange到queue成功,则不回调return
	//exchange到queue失败,则回调return(需设置mandatory=true,否则不回回调,消息就丢了)
	public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
		log.info("消息主体 message : "+message);
		log.info("消息主体 replyCode : "+ replyCode);
		log.info("描述："+ replyText);
		log.info("消息使用的交换器 exchange : "+ exchange);
		log.info("消息使用的路由键 routing : "+ routingKey);
	}
}
