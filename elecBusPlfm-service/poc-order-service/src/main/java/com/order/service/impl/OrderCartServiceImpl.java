package com.order.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.common.base.BaseBiz;
import com.common.base.EntityUtils;
import com.common.enums.ConstantsEnum;
import com.common.msg.CodeMsg;
import com.common.msg.RrcResponse;
import com.domain.order.OrderCart;
import com.domain.order.model.OrderTransfModel;
import com.domain.order.model.request.AddShopingCartModel;
import com.order.client.ProducskuControllerClient;
import com.order.mapper.OrderCartMapper;
import com.order.service.OrderCartService;
import com.order.service.rabbitmq.RabbitmqSenderService;
import com.order.service.redis.RedisService;

import lombok.extern.slf4j.Slf4j;

/**
 * 购物车表
 *
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 13:36:27
 */
@Service
@Slf4j
public class OrderCartServiceImpl extends BaseBiz<OrderCartMapper,OrderCart> implements OrderCartService{
	
	@Autowired
	private ProducskuControllerClient producskuControllerClient;
	@Autowired
    private RedisService redisService;
	@Autowired
	private RabbitmqSenderService rabbitmqSenderService;
	/** 工作机器ID(0~31) */
	@Value("${snowflakeIdWorker.workerId}")
	private long workerId;

	/** 数据中心ID(0~31) */
	@Value("${snowflakeIdWorker.datacenterId}")
	private long datacenterId;

	@Override
	@Transactional
//	@LcnTransaction
	public RrcResponse addShopingCart(AddShopingCartModel addShopingCartModel) {
//		long start = System.currentTimeMillis();
//		log.info("加入购物车开始--------" + start);
		RrcResponse response = new RrcResponse(CodeMsg.SUCCESS);
		//校验参数
		OrderCart cart = OrderTransfModel.getOrderCart(addShopingCartModel);
		if (!validateForInsert(cart)) {
			return new RrcResponse(CodeMsg.POC_ERROR_PARAMETER);
		}
		//更新产品sku表商品数量
		RrcResponse resProdCount = producskuControllerClient.updateProdCount(cart.getSkuId(), cart.getProductCount());
		if (!resProdCount.isSuccess()) {
			return resProdCount;
		}
		try {
			// 入库
			cart.setStatus(ConstantsEnum.ORDERCART_STATUS_ADD.getIndexInt());
			EntityUtils.setCreatAndUpdatInfo(cart);
	        mapper.insertSelective(cart);
			// log.info("加入购物车结束--------" + (System.currentTimeMillis()-start));
//			int i = 1/0;
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			//执行失败 rabbimq补偿机制 商品数量加1
			rabbitmqSenderService.compensateProStockSend(cart);
			return new RrcResponse(CodeMsg.POC_ERROR_ADDCART);
		}
		
		return response;
	}

	@Override
	public Boolean validate(OrderCart entity) {
		
		return true;
	}

	@Override
	public Boolean validateForInsert(OrderCart entity) {
		if (entity==null||entity.getSkuId()==null||entity.getCustId()==null||entity.getSpuId()==null||entity.getShopId()==null
				||StringUtils.isBlank(entity.getProductName())||entity.getProductPrice()==null||entity.getProductCount()==null) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean validateForUpdate(OrderCart entity) {
		return true;
	}

	@Override
	public Boolean validateForDelete(OrderCart entity) {
		return true;
	}

	@Override
	public RrcResponse addShopingCartByRedis(AddShopingCartModel addShopingCartModel) {
		// 校验参数
		OrderCart cart = OrderTransfModel.getOrderCart(addShopingCartModel);
		if (!validateForInsert(cart)) {
			return new RrcResponse(CodeMsg.POC_ERROR_PARAMETER);
		}
		if (redisService.increment(cart.getSkuId()+"-stock", -1)>=0) {
			//异步处理订单
			log.info("我抢到了，恭喜我吧");
			//更新库存
			rabbitmqSenderService.updateProStockSend(cart);
			//加入购物车
			cart.setStatus(ConstantsEnum.ORDERCART_STATUS_ADD.getIndexInt());
			rabbitmqSenderService.createCartSend(cart);
			return new RrcResponse(CodeMsg.SUCCESS);
		}
		return  new RrcResponse(CodeMsg.POC_ERROR_STOCK_LOW);
	}
}