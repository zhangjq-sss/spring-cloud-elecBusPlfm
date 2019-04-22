package com.domain.customer.model.response;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class RespCustomerModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer custId;

	// 登录用户名
	private String username;

	//
	private String password;

	// 昵称
	private String nickname;

	//
	@Column(name = "mobile")
	private String mobile;

	// 图像url
	private String imageUrl;

	//
	private String email;

	// 0 未锁定 1 已锁定
	private Boolean lockedType;

	// 状态
	private Integer status;

	//
	private String shareCode;

	// 第三方微信
	private String thirdWx;

	// 第三方QQ
	private String thirdQq;
	
	// 第三方QQ
	private String token;

	// 注册时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date crtTime;

	//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updTime;
}
