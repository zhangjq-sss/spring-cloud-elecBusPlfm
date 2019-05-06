package com.product.config;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.common.util.JsonMapUtils;
import com.domain.order.OrderCart;
import com.product.service.ProducskuService;
import com.rabbitmq.client.Channel;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MQReceiverConfig {
	@Autowired
	private ProducskuService producskuService;

	@RabbitListener(queues = "updateProStock") // 监听器监听指定的Queue
	public void updateProStock(Channel channel, Message message) {
		try {
			OrderCart cart =(OrderCart) JsonMapUtils.toObject(message.getBody());
        	producskuService.updateProdCount(cart.getSkuId(), cart.getProductCount());
        	log.info("执行库存更新消息成功");
        } catch (Exception e) {
            log.error("执行库存更新消息失败-----" + e.getMessage());
            //丢弃这条消息
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
            
            //记录日志失败原因
            
        }finally {
        	//告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            try {
				channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
			} catch (IOException e) {
				log.error("回执库存更新信息失败---" + e.getMessage());
			}
		}
	}
}
