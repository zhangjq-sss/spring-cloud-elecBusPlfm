package com.product.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.common.base.BaseBiz;
import com.common.msg.CodeMsg;
import com.common.msg.RrcResponse;
import com.domain.product.Producsku;
import com.product.mapper.ProducskuMapper;
import com.product.service.ProducskuService;

import tk.mybatis.mapper.entity.Example;

/**
 * sku表
 *
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-15 16:23:23
 */
@Service
public class ProducskuServiceImpl extends BaseBiz<ProducskuMapper,Producsku> implements ProducskuService{

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
		if (!(mapper.updateByExampleSelective(record, example)>0?true:false)) {
			return new RrcResponse(CodeMsg.POC_ERROR_UPDATESTOCK);
		}
//		int a = 1/0;
		return new RrcResponse(CodeMsg.SUCCESS);
	}
}