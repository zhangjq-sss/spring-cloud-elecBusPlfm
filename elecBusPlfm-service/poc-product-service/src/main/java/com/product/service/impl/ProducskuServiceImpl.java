package com.product.service.impl;

import org.springframework.stereotype.Service;

import com.common.base.BaseBiz;
import com.domain.product.Producsku;
import com.product.mapper.ProducskuMapper;
import com.product.service.ProducskuService;

/**
 * sku表
 *
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-15 16:23:23
 */
@Service
public class ProducskuServiceImpl extends BaseBiz<ProducskuMapper,Producsku> implements ProducskuService{
}