package com.domain.payment;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 应用支付渠道表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 14:12:24
 */
@Table(name = "t_payment_chan_rel")
public class PaymentChanRel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //应用渠道ID
    @Id
    private Integer id;
	
	    //应用ID
    @Column(name = "app_def_id")
    private Integer appDefId;
	
	    //支付渠道 1支付宝app 10微信app 20银联云闪付app
    @Column(name = "pay_channel")
    private Integer payChannel;
	
	    //生效时间
    @Column(name = "valid_time")
    private Date validTime;
	
	    //失效时间
    @Column(name = "expire_time")
    private Date expireTime;
	
	    //版本
    @Column(name = "version")
    private Integer version;
	
	    //状态  0-expire 1- normal
    @Column(name = "status")
    private Integer status;
	
	    //创建时间
    @Column(name = "crt_time")
    private Date crtTime;
	
	    //操作时间
    @Column(name = "upd_time")
    private Date updTime;
	

	/**
	 * 设置：应用渠道ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：应用渠道ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：应用ID
	 */
	public void setAppDefId(Integer appDefId) {
		this.appDefId = appDefId;
	}
	/**
	 * 获取：应用ID
	 */
	public Integer getAppDefId() {
		return appDefId;
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
	 * 设置：生效时间
	 */
	public void setValidTime(Date validTime) {
		this.validTime = validTime;
	}
	/**
	 * 获取：生效时间
	 */
	public Date getValidTime() {
		return validTime;
	}
	/**
	 * 设置：失效时间
	 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	/**
	 * 获取：失效时间
	 */
	public Date getExpireTime() {
		return expireTime;
	}
	/**
	 * 设置：版本
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * 获取：版本
	 */
	public Integer getVersion() {
		return version;
	}
	/**
	 * 设置：状态  0-expire 1- normal
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态  0-expire 1- normal
	 */
	public Integer getStatus() {
		return status;
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
