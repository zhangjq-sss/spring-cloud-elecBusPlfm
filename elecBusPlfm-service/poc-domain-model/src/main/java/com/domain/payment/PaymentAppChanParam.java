package com.domain.payment;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 支付渠道基础数据表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 14:12:24
 */
@Table(name = "t_payment_app_chan_param")
public class PaymentAppChanParam implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //应用渠道ID
    @Id
    private Long id;
	
	    //参数应用ID
    @Column(name = "app_id")
    private String appId;
	
	    //参数商户ID
    @Column(name = "mch_id")
    private String mchId;
	
	    //公钥
    @Column(name = "app_pub_key")
    private String appPubKey;
	
	    //私钥
    @Column(name = "app_pri_key")
    private String appPriKey;
	
	    //证书内容
    @Column(name = "cert_context")
    private String certContext;
	
	    //商品的标题/交易标题/订单标题/订单关键字等。
    @Column(name = "subject")
    private String subject;
	
	    //对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
    @Column(name = "body")
    private String body;
	
	    //应用网址 特殊字段
    @Column(name = "app_url")
    private String appUrl;
	
	    //预留字段1 
    @Column(name = "ext_1")
    private String ext1;
	
	    //预留字段2
    @Column(name = "ext_2")
    private String ext2;
	
	    //
    @Column(name = "ext_3")
    private String ext3;
	
	    //
    @Column(name = "ext_4")
    private String ext4;
	
	    //创建时间
    @Column(name = "crt_time")
    private Date crtTime;
	
	    //
    @Column(name = "upd_time")
    private Date updTime;
	

	/**
	 * 设置：应用渠道ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：应用渠道ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：参数应用ID
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}
	/**
	 * 获取：参数应用ID
	 */
	public String getAppId() {
		return appId;
	}
	/**
	 * 设置：参数商户ID
	 */
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	/**
	 * 获取：参数商户ID
	 */
	public String getMchId() {
		return mchId;
	}
	/**
	 * 设置：公钥
	 */
	public void setAppPubKey(String appPubKey) {
		this.appPubKey = appPubKey;
	}
	/**
	 * 获取：公钥
	 */
	public String getAppPubKey() {
		return appPubKey;
	}
	/**
	 * 设置：私钥
	 */
	public void setAppPriKey(String appPriKey) {
		this.appPriKey = appPriKey;
	}
	/**
	 * 获取：私钥
	 */
	public String getAppPriKey() {
		return appPriKey;
	}
	/**
	 * 设置：证书内容
	 */
	public void setCertContext(String certContext) {
		this.certContext = certContext;
	}
	/**
	 * 获取：证书内容
	 */
	public String getCertContext() {
		return certContext;
	}
	/**
	 * 设置：商品的标题/交易标题/订单标题/订单关键字等。
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * 获取：商品的标题/交易标题/订单标题/订单关键字等。
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * 设置：对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
	 */
	public void setBody(String body) {
		this.body = body;
	}
	/**
	 * 获取：对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
	 */
	public String getBody() {
		return body;
	}
	/**
	 * 设置：应用网址 特殊字段
	 */
	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}
	/**
	 * 获取：应用网址 特殊字段
	 */
	public String getAppUrl() {
		return appUrl;
	}
	/**
	 * 设置：预留字段1 
	 */
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	/**
	 * 获取：预留字段1 
	 */
	public String getExt1() {
		return ext1;
	}
	/**
	 * 设置：预留字段2
	 */
	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	/**
	 * 获取：预留字段2
	 */
	public String getExt2() {
		return ext2;
	}
	/**
	 * 设置：
	 */
	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}
	/**
	 * 获取：
	 */
	public String getExt3() {
		return ext3;
	}
	/**
	 * 设置：
	 */
	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}
	/**
	 * 获取：
	 */
	public String getExt4() {
		return ext4;
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
}
