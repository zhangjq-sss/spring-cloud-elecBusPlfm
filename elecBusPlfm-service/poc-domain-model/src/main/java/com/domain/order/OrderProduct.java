package com.domain.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 订单产品表-下单之后
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 13:36:27
 */
@Table(name = "t_order_product")
public class OrderProduct implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //
    @Column(name = "order_no")
    private String orderNo;
	
	    //
    @Column(name = "spu_id")
    private Integer spuId;
	
	    //
    @Column(name = "sku_id")
    private Integer skuId;
	
	    //
    @Column(name = "shop_id")
    private Integer shopId;
	
	    //sku产品名称
    @Column(name = "product_name")
    private String productName;
	
	    //sku产品数量
    @Column(name = "product_count")
    private Integer productCount;
	
	    //sku产品单个价格
    @Column(name = "product_price")
    private BigDecimal productPrice;
	
	    //
    @Column(name = "crt_time")
    private Date crtTime;
	
	    //
    @Column(name = "upd_time")
    private Date updTime;
	

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：
	 */
	public void setSpuId(Integer spuId) {
		this.spuId = spuId;
	}
	/**
	 * 获取：
	 */
	public Integer getSpuId() {
		return spuId;
	}
	/**
	 * 设置：
	 */
	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}
	/**
	 * 获取：
	 */
	public Integer getSkuId() {
		return skuId;
	}
	/**
	 * 设置：
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：sku产品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 获取：sku产品名称
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * 设置：sku产品数量
	 */
	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}
	/**
	 * 获取：sku产品数量
	 */
	public Integer getProductCount() {
		return productCount;
	}
	/**
	 * 设置：sku产品单个价格
	 */
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	/**
	 * 获取：sku产品单个价格
	 */
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	/**
	 * 设置：
	 */
	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}
	/**
	 * 获取：
	 */
	public Date getCrtTime() {
		return crtTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdTime() {
		return updTime;
	}
}
