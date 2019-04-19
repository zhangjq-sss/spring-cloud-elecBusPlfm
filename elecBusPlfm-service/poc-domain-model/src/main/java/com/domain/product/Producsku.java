package com.domain.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;


/**
 * sku表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 11:07:31
 */
@Table(name = "t_product_sku")
public class Producsku implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Long id;
	
	    //sku编号,唯一
    @Column(name = "sku_no")
    private String skuNo;
	
	    //sku名称(冗余spu_name)
    @Column(name = "sku_name")
    private String skuName;
	
	    //售价
    @Column(name = "price")
    private BigDecimal price;
	
	    //库存
    @Column(name = "stock")
    private Integer stock;
	
	    //商铺id,为0表示自营
    @Column(name = "shop_id")
    private Long shopId;
	
	    //spu_id
    @Column(name = "spu_id")
    private Long spuId;
	
	    //
    @Column(name = "crt_time")
    private Date crtTime;
	
	    //
    @Column(name = "upd_time")
    private Date updTime;
	

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：sku编号,唯一
	 */
	public void setSkuNo(String skuNo) {
		this.skuNo = skuNo;
	}
	/**
	 * 获取：sku编号,唯一
	 */
	public String getSkuNo() {
		return skuNo;
	}
	/**
	 * 设置：sku名称(冗余spu_name)
	 */
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	/**
	 * 获取：sku名称(冗余spu_name)
	 */
	public String getSkuName() {
		return skuName;
	}
	/**
	 * 设置：售价
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：售价
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：库存
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	/**
	 * 获取：库存
	 */
	public Integer getStock() {
		return stock;
	}
	/**
	 * 设置：商铺id,为0表示自营
	 */
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：商铺id,为0表示自营
	 */
	public Long getShopId() {
		return shopId;
	}
	/**
	 * 设置：spu_id
	 */
	public void setSpuId(Long spuId) {
		this.spuId = spuId;
	}
	/**
	 * 获取：spu_id
	 */
	public Long getSpuId() {
		return spuId;
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
