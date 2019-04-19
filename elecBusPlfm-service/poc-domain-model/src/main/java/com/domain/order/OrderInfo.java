package com.domain.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 订单信息表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 13:36:27
 */
@Table(name = "t_order_info")
public class OrderInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //
    @Column(name = "order_no")
    private String orderNo;
	
	    //
    @Column(name = "item_count")
    private Integer itemCount;
	
	    //
    @Column(name = "cust_id")
    private Integer custId;
	
	    //
    @Column(name = "shop_id")
    private Integer shopId;
	
	    //下单时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "crt_time")
    private Date crtTime;
	
	    //0 表示还未支付 支付方式（1：支付宝，2：微信，3：银行卡...）
    @Column(name = "pay_type")
    private Integer payType;
	
	    //外部订单号
    @Column(name = "out_trade_no")
    private String outTradeNo;
	
	    //支付时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "pay_time")
    private Date payTime;
	
	    //邮寄方式
    @Column(name = "mail_method")
    private Integer mailMethod;
	
	    //期望配送日期
    @Column(name = "expect_marl_time")
    private Date expectMarlTime;
	
	    //商品总额
    @Column(name = "total_price")
    private BigDecimal totalPrice;
	
	    //配送费用
    @Column(name = "mail_fee")
    private BigDecimal mailFee;
	
	    //总共优惠金额
    @Column(name = "total_discount_fee")
    private BigDecimal totalDiscountFee;
	
	    //实际支付费用
    @Column(name = "actual_pay_amount")
    private BigDecimal actualPayAmount;
	
	    //版本号
    @Column(name = "version")
    private Integer version;
	
	    //0 待支付 10支付成功 11待收货 20超时未支付 30手动取消支付
    @Column(name = "status")
    private Integer status;
	
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
	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}
	/**
	 * 获取：
	 */
	public Integer getItemCount() {
		return itemCount;
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
	 * 设置：下单时间
	 */
	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}
	/**
	 * 获取：下单时间
	 */
	public Date getCrtTime() {
		return crtTime;
	}
	/**
	 * 设置：0 表示还未支付 支付方式（1：支付宝，2：微信，3：银行卡...）
	 */
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	/**
	 * 获取：0 表示还未支付 支付方式（1：支付宝，2：微信，3：银行卡...）
	 */
	public Integer getPayType() {
		return payType;
	}
	/**
	 * 设置：外部订单号
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	/**
	 * 获取：外部订单号
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}
	/**
	 * 设置：支付时间
	 */
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	/**
	 * 获取：支付时间
	 */
	public Date getPayTime() {
		return payTime;
	}
	/**
	 * 设置：邮寄方式
	 */
	public void setMailMethod(Integer mailMethod) {
		this.mailMethod = mailMethod;
	}
	/**
	 * 获取：邮寄方式
	 */
	public Integer getMailMethod() {
		return mailMethod;
	}
	/**
	 * 设置：期望配送日期
	 */
	public void setExpectMarlTime(Date expectMarlTime) {
		this.expectMarlTime = expectMarlTime;
	}
	/**
	 * 获取：期望配送日期
	 */
	public Date getExpectMarlTime() {
		return expectMarlTime;
	}
	/**
	 * 设置：商品总额
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * 获取：商品总额
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	/**
	 * 设置：配送费用
	 */
	public void setMailFee(BigDecimal mailFee) {
		this.mailFee = mailFee;
	}
	/**
	 * 获取：配送费用
	 */
	public BigDecimal getMailFee() {
		return mailFee;
	}
	/**
	 * 设置：总共优惠金额
	 */
	public void setTotalDiscountFee(BigDecimal totalDiscountFee) {
		this.totalDiscountFee = totalDiscountFee;
	}
	/**
	 * 获取：总共优惠金额
	 */
	public BigDecimal getTotalDiscountFee() {
		return totalDiscountFee;
	}
	/**
	 * 设置：实际支付费用
	 */
	public void setActualPayAmount(BigDecimal actualPayAmount) {
		this.actualPayAmount = actualPayAmount;
	}
	/**
	 * 获取：实际支付费用
	 */
	public BigDecimal getActualPayAmount() {
		return actualPayAmount;
	}
	/**
	 * 设置：版本号
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * 获取：版本号
	 */
	public Integer getVersion() {
		return version;
	}
	/**
	 * 设置：0 待支付 10支付成功 11待收货 20超时未支付 30手动取消支付
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：0 待支付 10支付成功 11待收货 20超时未支付 30手动取消支付
	 */
	public Integer getStatus() {
		return status;
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
