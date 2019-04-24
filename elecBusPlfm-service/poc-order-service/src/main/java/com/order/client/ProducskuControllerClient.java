package com.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.msg.RrcResponse;
import com.order.client.fallback.ProducskuControllerFallback;

@FeignClient(name = "poc-product-service", path = "/producsku", fallback = ProducskuControllerFallback.class)
public interface ProducskuControllerClient {

	@PostMapping("/updateProdCount")
	public RrcResponse updateProdCount(@RequestParam("skuId") Integer skuId, @RequestParam("count") int count);
}
