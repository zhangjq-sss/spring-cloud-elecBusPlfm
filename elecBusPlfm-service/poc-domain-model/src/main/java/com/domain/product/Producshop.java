package com.domain.product;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 店铺表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 11:07:31
 */
@Table(name = "t_product_shop")
public class Producshop implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Long id;
	
	    //店铺名称
    @Column(name = "shop_name")
    private String shopName;
	
	    //店铺地址
    @Column(name = "shop_address")
    private String shopAddress;
	
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
	 * 设置：店铺名称
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	/**
	 * 获取：店铺名称
	 */
	public String getShopName() {
		return shopName;
	}
	/**
	 * 设置：店铺地址
	 */
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	/**
	 * 获取：店铺地址
	 */
	public String getShopAddress() {
		return shopAddress;
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
