package com.domain.promotion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 优惠券使用范围表-针对不同店铺 产品 品牌等等
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 14:31:09
 */
@Table(name = "t_promotion_coupon_scope")
public class PromotionCouponScope implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //
    @Column(name = "coupon_id")
    private Integer couponId;
	
	    //范围id 店铺 产品 品牌 种类
    @Column(name = "scope_id")
    private Integer scopeId;
	

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
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	/**
	 * 获取：
	 */
	public Integer getCouponId() {
		return couponId;
	}
	/**
	 * 设置：范围id 店铺 产品 品牌 种类
	 */
	public void setScopeId(Integer scopeId) {
		this.scopeId = scopeId;
	}
	/**
	 * 获取：范围id 店铺 产品 品牌 种类
	 */
	public Integer getScopeId() {
		return scopeId;
	}
}
