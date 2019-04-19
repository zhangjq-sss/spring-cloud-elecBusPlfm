package com.domain.promotion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 优惠券码表-针对发放优惠码的商户
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 14:31:09
 */
@Table(name = "t_promotion_coupon_code")
public class PromotionCouponCode implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //
    @Column(name = "cust_id")
    private Integer custId;
	
	    //
    @Column(name = "coupon_id")
    private Integer couponId;
	
	    //
    @Column(name = "coupon_code")
    private String couponCode;
	
	    //
    @Column(name = "coupon_amount")
    private BigDecimal couponAmount;
	
	    //是否领取 0 未领取 1已领取
    @Column(name = "status")
    private Integer status;
	
	    //
    @Column(name = "crt_time")
    private Date crtTime;
	
	    //优惠券金额
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
	 * 设置：
	 */
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	/**
	 * 获取：
	 */
	public String getCouponCode() {
		return couponCode;
	}
	/**
	 * 设置：
	 */
	public void setCouponAmount(BigDecimal couponAmount) {
		this.couponAmount = couponAmount;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getCouponAmount() {
		return couponAmount;
	}
	/**
	 * 设置：是否领取 0 未领取 1已领取
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：是否领取 0 未领取 1已领取
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
	 * 设置：优惠券金额
	 */
	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}
	/**
	 * 获取：优惠券金额
	 */
	public Date getUpdTime() {
		return updTime;
	}
}
