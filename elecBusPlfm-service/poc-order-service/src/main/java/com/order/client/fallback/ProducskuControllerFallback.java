package com.order.client.fallback;

import org.springframework.stereotype.Component;

import com.common.msg.CodeMsg;
import com.common.msg.RrcResponse;
import com.order.client.ProducskuControllerClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProducskuControllerFallback implements ProducskuControllerClient{

	@Override
	public RrcResponse updateProdCount(Integer skuId, int count) {
		log.info("更新库存失败");
		return new RrcResponse(CodeMsg.FAIL);
	}

}
