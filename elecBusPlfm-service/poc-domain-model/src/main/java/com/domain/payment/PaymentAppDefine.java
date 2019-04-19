package com.domain.payment;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 应用产品表-app/pc
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 14:12:24
 */
@Table(name = "t_payment_app_define")
public class PaymentAppDefine implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //应用定义ID
    @Id
    private Integer id;
	
	    //应用code
    @Column(name = "app_code")
    private String appCode;
	
	    //应用名称
    @Column(name = "app_name")
    private String appName;
	
	    //应用描述
    @Column(name = "app_desc")
    private String appDesc;
	
	    //应用类型 1app 2pc 3微信公众号 4微信小程序 
    @Column(name = "app_type")
    private Integer appType;
	
	    //状态 0未生效 1 生效
    @Column(name = "status")
    private Integer status;
	
	    //失效时间
    @Column(name = "expire_time")
    private Date expireTime;
	
	    //生效时间
    @Column(name = "valid_time")
    private Date validTime;
	
	    //创建时间
    @Column(name = "crt_time")
    private Date crtTime;
	
	    //操作时间
    @Column(name = "upd_time")
    private Date updTime;
	

	/**
	 * 设置：应用定义ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：应用定义ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：应用code
	 */
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	/**
	 * 获取：应用code
	 */
	public String getAppCode() {
		return appCode;
	}
	/**
	 * 设置：应用名称
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}
	/**
	 * 获取：应用名称
	 */
	public String getAppName() {
		return appName;
	}
	/**
	 * 设置：应用描述
	 */
	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}
	/**
	 * 获取：应用描述
	 */
	public String getAppDesc() {
		return appDesc;
	}
	/**
	 * 设置：应用类型 1app 2pc 3微信公众号 4微信小程序 
	 */
	public void setAppType(Integer appType) {
		this.appType = appType;
	}
	/**
	 * 获取：应用类型 1app 2pc 3微信公众号 4微信小程序 
	 */
	public Integer getAppType() {
		return appType;
	}
	/**
	 * 设置：状态 0未生效 1 生效
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 0未生效 1 生效
	 */
	public Integer getStatus() {
		return status;
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
