package com.auth.service;

import java.io.UnsupportedEncodingException;

import com.common.msg.RrcResponse;

/**
 * @ClassName: AuthService
 * @Description: 认证服务处理
 * @author
 * @date 2018-05-22 11:33:05
 */

public interface AuthService {
	/**
	 * 校验token
	 * 
	 * @param token
	 * @return
	 */
	RrcResponse checkToken(String token);

	/**
	 * 平台用户登录
	 * 
	 * @param userName
	 *            登录账户/
	 * @param password
	 *            密码
	 * @return
	 */
	RrcResponse login(String userName, String password) throws UnsupportedEncodingException;

	/**
	 * 平台用户退出
	 * 
	 * @param token
	 * @return
	 */
	RrcResponse loginOut(String token);
	
	/**
	 * 发送手机验证码
	 * @param mobile
	 * @return
	 */
	RrcResponse sendMobileCode(String mobile);
	
	RrcResponse varifyMObileCode(String mobile, String code);
}
