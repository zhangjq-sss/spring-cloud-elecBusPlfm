package com.domain.customer;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 客户表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 11:29:51
 */
@Table(name = "t_customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //登录用户名
    @Column(name = "username")
    private String username;
	
	    //
    @Column(name = "password")
    private String password;
	
	    //昵称
    @Column(name = "nickname")
    private String nickname;
	
	    //
    @Column(name = "mobile")
    private String mobile;
	
	    //图像url
    @Column(name = "image_url")
    private String imageUrl;
	
	    //
    @Column(name = "email")
    private String email;
	
	    //0 未锁定 1 已锁定
    @Column(name = "locked_type")
    private Boolean lockedType;
	
	    //状态
    @Column(name = "status")
    private Integer status;
	
	    //
    @Column(name = "share_code")
    private String shareCode;
	
	    //第三方微信
    @Column(name = "third_wx")
    private String thirdWx;
	
	    //第三方QQ
    @Column(name = "third_qq")
    private String thirdQq;
    
    //token
    @Column(name = "token")
    private String token;
	
	    //注册时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "crt_time")
    private Date crtTime;
	
	    //
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
	 * 设置：登录用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：登录用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：昵称
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：图像url
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * 获取：图像url
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * 设置：
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：0 未锁定 1 已锁定
	 */
	public void setLockedType(Boolean lockedType) {
		this.lockedType = lockedType;
	}
	/**
	 * 获取：0 未锁定 1 已锁定
	 */
	public Boolean getLockedType() {
		return lockedType;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setShareCode(String shareCode) {
		this.shareCode = shareCode;
	}
	/**
	 * 获取：
	 */
	public String getShareCode() {
		return shareCode;
	}
	/**
	 * 设置：第三方微信
	 */
	public void setThirdWx(String thirdWx) {
		this.thirdWx = thirdWx;
	}
	/**
	 * 获取：第三方微信
	 */
	public String getThirdWx() {
		return thirdWx;
	}
	/**
	 * 设置：第三方QQ
	 */
	public void setThirdQq(String thirdQq) {
		this.thirdQq = thirdQq;
	}
	/**
	 * 获取：第三方QQ
	 */
	public String getThirdQq() {
		return thirdQq;
	}
	/**
	 * 设置：注册时间
	 */
	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}
	/**
	 * 获取：注册时间
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
