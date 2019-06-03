package com.customer.service.impl;

import org.springframework.stereotype.Service;

import com.common.base.BaseBiz;
import com.customer.mapper.CustomerAddressMapper;
import com.domain.customer.CustomerAddress;

/**
 * 客户地址表
 *
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 11:29:51
 */
@Service
public class CustomerAddressServiceImpl extends BaseBiz<CustomerAddressMapper,CustomerAddress> {
}