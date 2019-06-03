package com.domain.payment;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 支付渠道公共参数表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 14:12:24
 */
@Table(name = "t_payment_chan_param")
public class PaymentChanParam implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //渠道参数ID
    @Id
    private Long id;
	
	    //支付渠道 1支付宝app 10微信app 20银联云闪付app
    @Column(name = "pay_channel")
    private Integer payChannel;
	
	    //参数名称
    @Column(name = "param_name")
    private String paramName;
	
	    //参数值
    @Column(name = "param_value")
    private String paramValue;
	
	    //参数描述
    @Column(name = "param_desc")
    private String paramDesc;
	
	    //参数类型
    @Column(name = "param_type")
    private String paramType;
	
	    //参数缺省值
    @Column(name = "default_value")
    private String defaultValue;
	
	    //排序字段
    @Column(name = "sort_index")
    private Integer sortIndex;
	

	/**
	 * 设置：渠道参数ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：渠道参数ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：支付渠道 1支付宝app 10微信app 20银联云闪付app
	 */
	public void setPayChannel(Integer payChannel) {
		this.payChannel = payChannel;
	}
	/**
	 * 获取：支付渠道 1支付宝app 10微信app 20银联云闪付app
	 */
	public Integer getPayChannel() {
		return payChannel;
	}
	/**
	 * 设置：参数名称
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	/**
	 * 获取：参数名称
	 */
	public String getParamName() {
		return paramName;
	}
	/**
	 * 设置：参数值
	 */
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	/**
	 * 获取：参数值
	 */
	public String getParamValue() {
		return paramValue;
	}
	/**
	 * 设置：参数描述
	 */
	public void setParamDesc(String paramDesc) {
		this.paramDesc = paramDesc;
	}
	/**
	 * 获取：参数描述
	 */
	public String getParamDesc() {
		return paramDesc;
	}
	/**
	 * 设置：参数类型
	 */
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
	/**
	 * 获取：参数类型
	 */
	public String getParamType() {
		return paramType;
	}
	/**
	 * 设置：参数缺省值
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	/**
	 * 获取：参数缺省值
	 */
	public String getDefaultValue() {
		return defaultValue;
	}
	/**
	 * 设置：排序字段
	 */
	public void setSortIndex(Integer sortIndex) {
		this.sortIndex = sortIndex;
	}
	/**
	 * 获取：排序字段
	 */
	public Integer getSortIndex() {
		return sortIndex;
	}
}
