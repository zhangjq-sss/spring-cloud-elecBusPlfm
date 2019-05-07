package com.product.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.common.base.BaseBiz;
import com.common.msg.CodeMsg;
import com.common.msg.RrcResponse;
import com.domain.product.Producsku;
import com.product.mapper.ProducskuMapper;
import com.product.service.ProducskuService;
import com.product.service.RedisService;

import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.entity.Example;

/**
 * sku表
 *
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-15 16:23:23
 */
@Slf4j
@Service
public class ProducskuServiceImpl extends BaseBiz<ProducskuMapper,Producsku> implements ProducskuService{
	
	 //乐观锁冲突最大重试次数
    private static final int DEFAULT_MAX_RETRIES = 1;
    @Autowired
    private RedisService redisService;

	@Override
	public Boolean validate(Producsku entity) {
		return true;
	}

	@Override
	public Boolean validateForInsert(Producsku entity) {
		return true;
	}

	@Override
	public Boolean validateForUpdate(Producsku entity) {
		return true;
	}

	@Override
	public Boolean validateForDelete(Producsku entity) {
		return true;
	}

	@Override
	@Transactional
//	@LcnTransaction
	public RrcResponse updateProdCount(Integer skuId, int count) {
		int retriesTimes = 0;
		do {
			//校验当前产品数量是否大于加入购物车数量
			Producsku sku = selectById(skuId);
			if (sku==null) {
				return new RrcResponse(CodeMsg.POC_ERROR_PARAMETER);
			}
			int stock = sku.getStock().intValue();
			if (stock==0||stock<count) {
				return new RrcResponse(CodeMsg.POC_ERROR_STOCK_LOW);
			}
			Example example = new Example(Producsku.class);
			Example.Criteria criteria = example.createCriteria();
			criteria.andEqualTo("id", skuId);
			criteria.andEqualTo("version", sku.getVersion());
			Producsku record = new Producsku();
			record.setStock(sku.getStock()-count);
			record.setUpdTime(new Date());
			record.setVersion(sku.getVersion()+1);
			retriesTimes++;
			int ret = mapper.updateByExampleSelective(record, example);
			if (ret>0) {
				return new RrcResponse(CodeMsg.SUCCESS);
			}
		} while (retriesTimes<DEFAULT_MAX_RETRIES);
//		int a = 1/0;
		return new RrcResponse(CodeMsg.POC_ERROR_UPDATESTOCK);
	}

	@Override
	public RrcResponse setProCountInRedis(Integer skuId, int stock) {
		redisService.increment(skuId+"-"+ "stock", stock);
		return new RrcResponse(CodeMsg.SUCCESS);
	}

	@Override
	@Transactional
	public boolean compensateProStock(Integer skuId, int count) {
		int retriesTimes = 0;
		do {
			//校验当前产品数量是否大于加入购物车数量
			Producsku sku = selectById(skuId);
			if (sku==null) {
				return false;
			}
			Example example = new Example(Producsku.class);
			Example.Criteria criteria = example.createCriteria();
			criteria.andEqualTo("id", skuId);
			criteria.andEqualTo("version", sku.getVersion());
			Producsku record = new Producsku();
			record.setStock(sku.getStock()+count);
			record.setUpdTime(new Date());
			record.setVersion(sku.getVersion()+1);
			retriesTimes++;
			int ret = mapper.updateByExampleSelective(record, example);
			if (ret>0) {
				return true;
			}
		}while (retriesTimes<DEFAULT_MAX_RETRIES);
		
		return false;
	}
	
	
}