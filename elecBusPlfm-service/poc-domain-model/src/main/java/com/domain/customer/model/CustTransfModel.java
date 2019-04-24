package com.domain.customer.model;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.domain.customer.Customer;
import com.domain.customer.model.response.RespCustomerModel;

public class CustTransfModel {

	public static RespCustomerModel getRespCustomerModel(Customer customer) {
		if (customer==null) {
			return null;
		}
		RespCustomerModel respCustomerModel = new RespCustomerModel();
		try {
			BeanUtils.copyProperties(respCustomerModel, customer);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
		respCustomerModel.setCustId(customer.getId());
		return respCustomerModel;
	}
}
