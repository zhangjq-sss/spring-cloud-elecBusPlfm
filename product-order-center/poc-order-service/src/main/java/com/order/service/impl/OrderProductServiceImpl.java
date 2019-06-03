package com.order.service.impl;

import org.springframework.stereotype.Service;

import com.common.base.BaseBiz;
import com.domain.order.OrderProduct;
import com.order.mapper.OrderProductMapper;

/**
 * 订单产品表-下单之后
 *
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 13:36:27
 */
@Service
public class OrderProductServiceImpl extends BaseBiz<OrderProductMapper,OrderProduct> {
}