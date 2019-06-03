package com.domain.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 发票表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 13:36:27
 */
@Table(name = "t_order_invoice")
public class OrderInvoice implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //发票类型
    @Column(name = "invoice_type")
    private Integer invoiceType;
	
	    //发票抬头
    @Column(name = "invoice_rise")
    private String invoiceRise;
	
	    //发票内容
    @Column(name = "invoice_content")
    private String invoiceContent;
	
	    //发票代码
    @Column(name = "invoice_code")
    private String invoiceCode;
	
	    //发票号码
    @Column(name = "invoice_no")
    private String invoiceNo;
	
	    //开票时间
    @Column(name = "invoice_time")
    private Date invoiceTime;
	
	    //校验码
    @Column(name = "check_code")
    private String checkCode;
	
	    //密码区
    @Column(name = "password_area")
    private String passwordArea;
	
	    //服务名称
    @Column(name = "sever_name")
    private String severName;
	
	    //规格型号
    @Column(name = "spec_type")
    private String specType;
	
	    //数量
    @Column(name = "count")
    private Integer count;
	
	    //单价
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
	
	    //金额
    @Column(name = "amount")
    private BigDecimal amount;
	
	    //
    @Column(name = "total_price")
    private BigDecimal totalPrice;
	
	    //税率
    @Column(name = "tax_rate")
    private BigDecimal taxRate;
	
	    //税额
    @Column(name = "rate_amount")
    private BigDecimal rateAmount;
	
	    //销售方名称
    @Column(name = "seller_name")
    private String sellerName;
	
	    //销售方纳税人识别号
    @Column(name = "seller_rate_number")
    private Integer sellerRateNumber;
	
	    //销售方地址
    @Column(name = "seller_address")
    private String sellerAddress;
	
	    //销售方电话
    @Column(name = "seller_phone")
    private String sellerPhone;
	
	    //销售方开户行
    @Column(name = "seller_bank_name")
    private String sellerBankName;
	
	    //销售方账号
    @Column(name = "seller_card_no")
    private String sellerCardNo;
	
	    //备注
    @Column(name = "remark")
    private String remark;
	
	    //收入款人
    @Column(name = "income_name")
    private String incomeName;
	
	    //开票人
    @Column(name = "open_invoice_name")
    private String openInvoiceName;
	
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
	 * 设置：发票类型
	 */
	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}
	/**
	 * 获取：发票类型
	 */
	public Integer getInvoiceType() {
		return invoiceType;
	}
	/**
	 * 设置：发票抬头
	 */
	public void setInvoiceRise(String invoiceRise) {
		this.invoiceRise = invoiceRise;
	}
	/**
	 * 获取：发票抬头
	 */
	public String getInvoiceRise() {
		return invoiceRise;
	}
	/**
	 * 设置：发票内容
	 */
	public void setInvoiceContent(String invoiceContent) {
		this.invoiceContent = invoiceContent;
	}
	/**
	 * 获取：发票内容
	 */
	public String getInvoiceContent() {
		return invoiceContent;
	}
	/**
	 * 设置：发票代码
	 */
	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}
	/**
	 * 获取：发票代码
	 */
	public String getInvoiceCode() {
		return invoiceCode;
	}
	/**
	 * 设置：发票号码
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	/**
	 * 获取：发票号码
	 */
	public String getInvoiceNo() {
		return invoiceNo;
	}
	/**
	 * 设置：开票时间
	 */
	public void setInvoiceTime(Date invoiceTime) {
		this.invoiceTime = invoiceTime;
	}
	/**
	 * 获取：开票时间
	 */
	public Date getInvoiceTime() {
		return invoiceTime;
	}
	/**
	 * 设置：校验码
	 */
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	/**
	 * 获取：校验码
	 */
	public String getCheckCode() {
		return checkCode;
	}
	/**
	 * 设置：密码区
	 */
	public void setPasswordArea(String passwordArea) {
		this.passwordArea = passwordArea;
	}
	/**
	 * 获取：密码区
	 */
	public String getPasswordArea() {
		return passwordArea;
	}
	/**
	 * 设置：服务名称
	 */
	public void setSeverName(String severName) {
		this.severName = severName;
	}
	/**
	 * 获取：服务名称
	 */
	public String getSeverName() {
		return severName;
	}
	/**
	 * 设置：规格型号
	 */
	public void setSpecType(String specType) {
		this.specType = specType;
	}
	/**
	 * 获取：规格型号
	 */
	public String getSpecType() {
		return specType;
	}
	/**
	 * 设置：数量
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * 获取：数量
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * 设置：单价
	 */
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * 获取：单价
	 */
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	/**
	 * 设置：金额
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取：金额
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * 设置：
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	/**
	 * 设置：税率
	 */
	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}
	/**
	 * 获取：税率
	 */
	public BigDecimal getTaxRate() {
		return taxRate;
	}
	/**
	 * 设置：税额
	 */
	public void setRateAmount(BigDecimal rateAmount) {
		this.rateAmount = rateAmount;
	}
	/**
	 * 获取：税额
	 */
	public BigDecimal getRateAmount() {
		return rateAmount;
	}
	/**
	 * 设置：销售方名称
	 */
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	/**
	 * 获取：销售方名称
	 */
	public String getSellerName() {
		return sellerName;
	}
	/**
	 * 设置：销售方纳税人识别号
	 */
	public void setSellerRateNumber(Integer sellerRateNumber) {
		this.sellerRateNumber = sellerRateNumber;
	}
	/**
	 * 获取：销售方纳税人识别号
	 */
	public Integer getSellerRateNumber() {
		return sellerRateNumber;
	}
	/**
	 * 设置：销售方地址
	 */
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}
	/**
	 * 获取：销售方地址
	 */
	public String getSellerAddress() {
		return sellerAddress;
	}
	/**
	 * 设置：销售方电话
	 */
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}
	/**
	 * 获取：销售方电话
	 */
	public String getSellerPhone() {
		return sellerPhone;
	}
	/**
	 * 设置：销售方开户行
	 */
	public void setSellerBankName(String sellerBankName) {
		this.sellerBankName = sellerBankName;
	}
	/**
	 * 获取：销售方开户行
	 */
	public String getSellerBankName() {
		return sellerBankName;
	}
	/**
	 * 设置：销售方账号
	 */
	public void setSellerCardNo(String sellerCardNo) {
		this.sellerCardNo = sellerCardNo;
	}
	/**
	 * 获取：销售方账号
	 */
	public String getSellerCardNo() {
		return sellerCardNo;
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
	/**
	 * 设置：收入款人
	 */
	public void setIncomeName(String incomeName) {
		this.incomeName = incomeName;
	}
	/**
	 * 获取：收入款人
	 */
	public String getIncomeName() {
		return incomeName;
	}
	/**
	 * 设置：开票人
	 */
	public void setOpenInvoiceName(String openInvoiceName) {
		this.openInvoiceName = openInvoiceName;
	}
	/**
	 * 获取：开票人
	 */
	public String getOpenInvoiceName() {
		return openInvoiceName;
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
