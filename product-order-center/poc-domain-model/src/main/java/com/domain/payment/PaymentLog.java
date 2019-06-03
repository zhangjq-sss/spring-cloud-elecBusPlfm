package com.domain.payment;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 支付日志表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 14:12:24
 */
@Table(name = "t_payment_log")
public class PaymentLog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //日志ID
    @Id
    private Long id;
	
	    //支付记录id
    @Column(name = "pay_record_id")
    private Long payRecordId;
	
	    //订单号
    @Column(name = "order_no")
    private String orderNo;
	
	    //第三方交易号
    @Column(name = "third_no")
    private String thirdNo;
	
	    //返回xml
    @Column(name = "result_msg")
    private String resultMsg;
	
	    //返回码
    @Column(name = "result_code")
    private String resultCode;
	
	    //IP地址
    @Column(name = "pay_ip")
    private String payIp;
	
	    //操作类型 1 支付 2退款
    @Column(name = "oper_type")
    private Integer operType;
	
	    //返回类型 1同步 2异步
    @Column(name = "rsp_type")
    private Integer rspType;
	
	    //创建时间
    @Column(name = "crt_time")
    private Date crtTime;
	
	    //
    @Column(name = "upd_time")
    private Date updTime;
	
	    //备注
    @Column(name = "remark")
    private String remark;
	

	/**
	 * 设置：日志ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：日志ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：支付记录id
	 */
	public void setPayRecordId(Long payRecordId) {
		this.payRecordId = payRecordId;
	}
	/**
	 * 获取：支付记录id
	 */
	public Long getPayRecordId() {
		return payRecordId;
	}
	/**
	 * 设置：订单号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：订单号
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：第三方交易号
	 */
	public void setThirdNo(String thirdNo) {
		this.thirdNo = thirdNo;
	}
	/**
	 * 获取：第三方交易号
	 */
	public String getThirdNo() {
		return thirdNo;
	}
	/**
	 * 设置：返回xml
	 */
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	/**
	 * 获取：返回xml
	 */
	public String getResultMsg() {
		return resultMsg;
	}
	/**
	 * 设置：返回码
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	/**
	 * 获取：返回码
	 */
	public String getResultCode() {
		return resultCode;
	}
	/**
	 * 设置：IP地址
	 */
	public void setPayIp(String payIp) {
		this.payIp = payIp;
	}
	/**
	 * 获取：IP地址
	 */
	public String getPayIp() {
		return payIp;
	}
	/**
	 * 设置：操作类型 1 支付 2退款
	 */
	public void setOperType(Integer operType) {
		this.operType = operType;
	}
	/**
	 * 获取：操作类型 1 支付 2退款
	 */
	public Integer getOperType() {
		return operType;
	}
	/**
	 * 设置：返回类型 1同步 2异步
	 */
	public void setRspType(Integer rspType) {
		this.rspType = rspType;
	}
	/**
	 * 获取：返回类型 1同步 2异步
	 */
	public Integer getRspType() {
		return rspType;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}
	/**
	 * 获取：创建时间
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
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
}
