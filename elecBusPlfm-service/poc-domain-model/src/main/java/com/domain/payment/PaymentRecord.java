package com.domain.payment;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;


/**
 * 支付记录表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 14:15:24
 */
@Table(name = "t_payment_record")
public class PaymentRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //支付记录id
    @Id
    private Integer id;
	
	    //订单code
    @Column(name = "order_no")
    private String orderNo;
	
	    //渠道id
    @Column(name = "chan_id")
    private Integer chanId;
	
	    //支付状态 0支付中 1支付成功 -1支付失败 -2支付超时 -3支付取消 3部分退款中 3退款成功
    @Column(name = "pay_status")
    private Integer payStatus;
	
	    //第三方交易号 第三方返回
    @Column(name = "third_no")
    private String thirdNo;
	
	    //支付金额
    @Column(name = "pay_fee")
    private BigDecimal payFee;
	
	    //退款金额
    @Column(name = "refund_fee")
    private BigDecimal refundFee;
	
	    //银行卡号
    @Column(name = "bank_card")
    private String bankCard;
	
	    //银行代码
    @Column(name = "bank_code")
    private String bankCode;
	
	    //银行名称
    @Column(name = "bank_name")
    private String bankName;
	
	    //版本号
    @Column(name = "version")
    private Integer version;
	
	    //充值完成时间
    @Column(name = "rech_complete_date")
    private Date rechCompleteDate;
	
	    //退款完成时间
    @Column(name = "refu_complete_date")
    private Date refuCompleteDate;
	
	    //回执代码
    @Column(name = "result_code")
    private String resultCode;
	
	    //失败原因
    @Column(name = "remark")
    private String remark;
	
	    //创建时间
    @Column(name = "crt_time")
    private Date crtTime;
	
	    //操作时间
    @Column(name = "upd_time")
    private Date updTime;
	

	/**
	 * 设置：支付记录id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：支付记录id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：订单code
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：订单code
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：渠道id
	 */
	public void setChanId(Integer chanId) {
		this.chanId = chanId;
	}
	/**
	 * 获取：渠道id
	 */
	public Integer getChanId() {
		return chanId;
	}
	/**
	 * 设置：支付状态 0支付中 1支付成功 -1支付失败 -2支付超时 -3支付取消 3部分退款中 3退款成功
	 */
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	/**
	 * 获取：支付状态 0支付中 1支付成功 -1支付失败 -2支付超时 -3支付取消 3部分退款中 3退款成功
	 */
	public Integer getPayStatus() {
		return payStatus;
	}
	/**
	 * 设置：第三方交易号 第三方返回
	 */
	public void setThirdNo(String thirdNo) {
		this.thirdNo = thirdNo;
	}
	/**
	 * 获取：第三方交易号 第三方返回
	 */
	public String getThirdNo() {
		return thirdNo;
	}
	/**
	 * 设置：支付金额
	 */
	public void setPayFee(BigDecimal payFee) {
		this.payFee = payFee;
	}
	/**
	 * 获取：支付金额
	 */
	public BigDecimal getPayFee() {
		return payFee;
	}
	/**
	 * 设置：退款金额
	 */
	public void setRefundFee(BigDecimal refundFee) {
		this.refundFee = refundFee;
	}
	/**
	 * 获取：退款金额
	 */
	public BigDecimal getRefundFee() {
		return refundFee;
	}
	/**
	 * 设置：银行卡号
	 */
	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}
	/**
	 * 获取：银行卡号
	 */
	public String getBankCard() {
		return bankCard;
	}
	/**
	 * 设置：银行代码
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	/**
	 * 获取：银行代码
	 */
	public String getBankCode() {
		return bankCode;
	}
	/**
	 * 设置：银行名称
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * 获取：银行名称
	 */
	public String getBankName() {
		return bankName;
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
	 * 设置：充值完成时间
	 */
	public void setRechCompleteDate(Date rechCompleteDate) {
		this.rechCompleteDate = rechCompleteDate;
	}
	/**
	 * 获取：充值完成时间
	 */
	public Date getRechCompleteDate() {
		return rechCompleteDate;
	}
	/**
	 * 设置：退款完成时间
	 */
	public void setRefuCompleteDate(Date refuCompleteDate) {
		this.refuCompleteDate = refuCompleteDate;
	}
	/**
	 * 获取：退款完成时间
	 */
	public Date getRefuCompleteDate() {
		return refuCompleteDate;
	}
	/**
	 * 设置：回执代码
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	/**
	 * 获取：回执代码
	 */
	public String getResultCode() {
		return resultCode;
	}
	/**
	 * 设置：失败原因
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：失败原因
	 */
	public String getRemark() {
		return remark;
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
	 * 设置：操作时间
	 */
	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}
	/**
	 * 获取：操作时间
	 */
	public Date getUpdTime() {
		return updTime;
	}
}
