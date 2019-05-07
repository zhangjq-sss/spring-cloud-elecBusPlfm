package com.product.service;

import com.common.base.ICRUDService;
import com.common.msg.RrcResponse;
import com.domain.product.Producsku;

public interface ProducskuService extends ICRUDService<Producsku>{

	/**
	 * 更新sku产品数量
	 * @param skuId
	 * @param count 增减数量
	 * @param version
	 * @return
	 */
	RrcResponse updateProdCount(Integer skuId, int count);
	
	RrcResponse setProCountInRedis(Integer skuId, int stock);
	
	/**
	 * 补偿数量+1
	 * @param skuId
	 * @param count
	 * @return
	 */
	boolean compensateProStock(Integer skuId, int count);
	
}
