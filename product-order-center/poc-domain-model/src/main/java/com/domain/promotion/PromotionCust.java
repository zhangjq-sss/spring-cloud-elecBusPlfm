package com.domain.promotion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 用户优惠券派发或使用表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 14:31:09
 */
@Table(name = "t_promotion_cust")
public class PromotionCust implements Serializable {
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
    @Column(name = "order_no")
    private String orderNo;
	
	    //优惠券金额
    @Column(name = "coupon_amount")
    private BigDecimal couponAmount;
	
	    //实际抵扣金额
    @Column(name = "real_amount")
    private BigDecimal realAmount;
	
	    //
    @Column(name = "expire_time")
    private Date expireTime;
	
	    //
    @Column(name = "valid_time")
    private Date validTime;
	
	    //状态 0未使用 1已使用 2过期
    @Column(name = "status")
    private Integer status;
	
	    //
    @Column(name = "version")
    private Integer version;
	
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
	 * 设置：优惠券金额
	 */
	public void setCouponAmount(BigDecimal couponAmount) {
		this.couponAmount = couponAmount;
	}
	/**
	 * 获取：优惠券金额
	 */
	public BigDecimal getCouponAmount() {
		return couponAmount;
	}
	/**
	 * 设置：实际抵扣金额
	 */
	public void setRealAmount(BigDecimal realAmount) {
		this.realAmount = realAmount;
	}
	/**
	 * 获取：实际抵扣金额
	 */
	public BigDecimal getRealAmount() {
		return realAmount;
	}
	/**
	 * 设置：
	 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	/**
	 * 获取：
	 */
	public Date getExpireTime() {
		return expireTime;
	}
	/**
	 * 设置：
	 */
	public void setValidTime(Date validTime) {
		this.validTime = validTime;
	}
	/**
	 * 获取：
	 */
	public Date getValidTime() {
		return validTime;
	}
	/**
	 * 设置：状态 0未使用 1已使用 2过期
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 0未使用 1已使用 2过期
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * 获取：
	 */
	public Integer getVersion() {
		return version;
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
