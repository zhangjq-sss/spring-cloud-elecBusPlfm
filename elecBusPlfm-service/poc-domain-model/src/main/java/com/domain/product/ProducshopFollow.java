package com.domain.product;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 店铺关注表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 11:07:31
 */
@Table(name = "t_product_shop_follow")
public class ProducshopFollow implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //
    @Column(name = "shop_id")
    private Integer shopId;
	
	    //
    @Column(name = "cust_id")
    private Integer custId;
	
	    //
    @Column(name = "crt_time")
    private Date crtTime;
	
	    //
    @Column(name = "upd_time")
    private Date updTime;
	
	    //是否取消关注
    @Column(name = "deleted")
    private Boolean deleted;
	

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
	/**
	 * 设置：是否取消关注
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	/**
	 * 获取：是否取消关注
	 */
	public Boolean getDeleted() {
		return deleted;
	}
}
