package com.domain.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 购物车表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 13:36:27
 */
@Table(name = "t_order_cart")
public class OrderCart implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //
    @Column(name = "sku_id")
    private Integer skuId;
	
	    //
    @Column(name = "spu_id")
    private Integer spuId;
	
	    //
    @Column(name = "cust_id")
    private Integer custId;
	
	    //
    @Column(name = "shop_id")
    private Integer shopId;
	
	    //商品名称
    @Column(name = "product_name")
    private String productName;
	
	    //商品数量
    @Column(name = "product_count")
    private Integer productCount;
	
	    //商品价格
    @Column(name = "product_price")
    private BigDecimal productPrice;
	
	    //0 新加入 1 商品过期失效 2 商品数量为0 下单之后对应商品就不应该显示在购物车了
    @Column(name = "status")
    private Integer status;
	
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
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	/**
	 * 获取：
	 */
	public Integer getCustId() {
		return custId;
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
	 * 设置：商品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 获取：商品名称
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * 设置：商品数量
	 */
	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}
	/**
	 * 获取：商品数量
	 */
	public Integer getProductCount() {
		return productCount;
	}
	/**
	 * 设置：商品价格
	 */
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	/**
	 * 获取：商品价格
	 */
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	/**
	 * 设置：0 新加入 1 商品过期失效 2 商品数量为0 下单之后对应商品就不应该显示在购物车了
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：0 新加入 1 商品过期失效 2 商品数量为0 下单之后对应商品就不应该显示在购物车了
	 */
	public Integer getStatus() {
		return status;
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
