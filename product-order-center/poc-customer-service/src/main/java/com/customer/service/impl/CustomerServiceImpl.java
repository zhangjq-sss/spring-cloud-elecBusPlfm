package com.customer.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.common.base.BaseBiz;
import com.customer.mapper.CustomerMapper;
import com.customer.service.CustomerService;
import com.domain.customer.Customer;
import com.domain.customer.model.CustTransfModel;
import com.domain.customer.model.response.RespCustomerModel;

import tk.mybatis.mapper.entity.Example;

/**
 * 客户表
 *
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 11:29:51
 */
@Service
public class CustomerServiceImpl extends BaseBiz<CustomerMapper,Customer> implements CustomerService{

	@Override
	public RespCustomerModel selectByUsernameAndPassword(String username, String password) {
		Example example = new Example(Customer.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("username", username);
		criteria.andEqualTo("password", password);
		List<Customer> list = mapper.selectByExample(example);
		if (list==null||list.size()==0) {
			return null;
		}
		return CustTransfModel.getRespCustomerModel(list.get(0));
	}

	@Override
	public boolean updateCustToken(Integer custId, String token) {
		Example example = new Example(Customer.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("id", custId);
		Customer record = new Customer();
		record.setToken(token);
		record.setUpdTime(new Date());
		return mapper.updateByExampleSelective(record, example)>0?true:false;
	}

	@Override
	public RespCustomerModel selectByMobile(String mobile) {
		Example example = new Example(Customer.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("mobile", mobile);
		List<Customer> list = mapper.selectByExample(example);
		if (list==null||list.size()==0) {
			return null;
		}
		return CustTransfModel.getRespCustomerModel(list.get(0));
	}
}