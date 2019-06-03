package com.domain.product.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProducskuDetailModel {
	private Long id;

	// sku编号,唯一
	private String skuNo;

	// sku名称(冗余spu_name)
	private String skuName;

	// 售价
	private BigDecimal price;

	// 库存
	private Integer stock;

	// 商铺id,为0表示自营
	private Long shopId;

	// spu_id
	private Long spuId;
	
	

}
