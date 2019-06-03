package com.domain.order.model;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.domain.order.OrderCart;
import com.domain.order.model.request.AddShopingCartModel;

public class OrderTransfModel {
	public static OrderCart getOrderCart(AddShopingCartModel addShopingCartModel) {
		if (addShopingCartModel==null) {
			return null;
		}
		OrderCart orderCart = new OrderCart();
		try {
			BeanUtils.copyProperties(orderCart, addShopingCartModel);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
		return orderCart;
	}
}
