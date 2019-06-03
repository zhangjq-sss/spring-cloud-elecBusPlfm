package com.domain.order.model.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AddShopingCartModel {
	private Integer skuId;

	//
	private Integer spuId;

	//
	private Integer custId;

	//
	private Integer shopId;

	// 商品名称
	private String productName;

	// 商品数量
	private Integer productCount;

	// 商品价格
	private BigDecimal productPrice;
}
