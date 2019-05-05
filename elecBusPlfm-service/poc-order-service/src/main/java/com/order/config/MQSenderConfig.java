package com.order.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQSenderConfig {
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
    Binding bindingExchangeMessage(@Qualifier("orderCart") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("createCart");
    }

    @Bean
    Binding bindingExchangeMessages(@Qualifier("productSku") Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("updateProStock");//*表示一个词,#表示零个或多个词
    }
}
