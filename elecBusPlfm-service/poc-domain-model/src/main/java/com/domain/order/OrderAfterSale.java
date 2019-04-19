package com.domain.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 订单售后表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 13:36:27
 */
@Table(name = "t_order_after_sale")
public class OrderAfterSale implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //
    @Column(name = "order_no")
    private String orderNo;
	
	    //申请售后数量
    @Column(name = "after_salse_count")
    private Integer afterSalseCount;
	
	    //售后类型 1 退货 2 换货
    @Column(name = "after_sale_type")
    private Integer afterSaleType;
	
	    //原因
    @Column(name = "reason")
    private String reason;
	
	    //问题描述
    @Column(name = "problem_desc")
    private String problemDesc;
	
	    //退款金额
    @Column(name = "refund_amount")
    private BigDecimal refundAmount;
	
	    //退款方式 1原路返回 2银行卡 
    @Column(name = "refund_amount_type")
    private Integer refundAmountType;
	
	    //取件地址
    @Column(name = "pickup_address")
    private String pickupAddress;
	
	    //取件人电话
    @Column(name = "pickup_phone")
    private String pickupPhone;
	
	    //取件人姓名
    @Column(name = "pickup_name")
    private String pickupName;
	
	    //退换取件方式 1上门取件 2寄件到商家
    @Column(name = "refund_pickup_type")
    private Integer refundPickupType;
	
	    //收货地址--换货
    @Column(name = "receive_address")
    private String receiveAddress;
	
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
	 * 设置：申请售后数量
	 */
	public void setAfterSalseCount(Integer afterSalseCount) {
		this.afterSalseCount = afterSalseCount;
	}
	/**
	 * 获取：申请售后数量
	 */
	public Integer getAfterSalseCount() {
		return afterSalseCount;
	}
	/**
	 * 设置：售后类型 1 退货 2 换货
	 */
	public void setAfterSaleType(Integer afterSaleType) {
		this.afterSaleType = afterSaleType;
	}
	/**
	 * 获取：售后类型 1 退货 2 换货
	 */
	public Integer getAfterSaleType() {
		return afterSaleType;
	}
	/**
	 * 设置：原因
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * 获取：原因
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * 设置：问题描述
	 */
	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}
	/**
	 * 获取：问题描述
	 */
	public String getProblemDesc() {
		return problemDesc;
	}
	/**
	 * 设置：退款金额
	 */
	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}
	/**
	 * 获取：退款金额
	 */
	public BigDecimal getRefundAmount() {
		return refundAmount;
	}
	/**
	 * 设置：退款方式 1原路返回 2银行卡 
	 */
	public void setRefundAmountType(Integer refundAmountType) {
		this.refundAmountType = refundAmountType;
	}
	/**
	 * 获取：退款方式 1原路返回 2银行卡 
	 */
	public Integer getRefundAmountType() {
		return refundAmountType;
	}
	/**
	 * 设置：取件地址
	 */
	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}
	/**
	 * 获取：取件地址
	 */
	public String getPickupAddress() {
		return pickupAddress;
	}
	/**
	 * 设置：取件人电话
	 */
	public void setPickupPhone(String pickupPhone) {
		this.pickupPhone = pickupPhone;
	}
	/**
	 * 获取：取件人电话
	 */
	public String getPickupPhone() {
		return pickupPhone;
	}
	/**
	 * 设置：取件人姓名
	 */
	public void setPickupName(String pickupName) {
		this.pickupName = pickupName;
	}
	/**
	 * 获取：取件人姓名
	 */
	public String getPickupName() {
		return pickupName;
	}
	/**
	 * 设置：退换取件方式 1上门取件 2寄件到商家
	 */
	public void setRefundPickupType(Integer refundPickupType) {
		this.refundPickupType = refundPickupType;
	}
	/**
	 * 获取：退换取件方式 1上门取件 2寄件到商家
	 */
	public Integer getRefundPickupType() {
		return refundPickupType;
	}
	/**
	 * 设置：收货地址--换货
	 */
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	/**
	 * 获取：收货地址--换货
	 */
	public String getReceiveAddress() {
		return receiveAddress;
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
