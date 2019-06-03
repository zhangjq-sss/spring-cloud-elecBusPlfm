package com.auth.web;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.service.AuthService;
import com.common.jwt.JwtHelper;
import com.common.msg.RrcResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

	static final int DEFAULT_LENGTH = 3;

	@Autowired
	private DiscoveryClient client;

	@ResponseBody
	@RequestMapping("/info")
	public Object info() {
		return client.getServices();
	}

	@Autowired
	AuthService authService;

	@ResponseBody
	@PostMapping("/checkToken")
	public RrcResponse checkToken(String token) {
		log.info("==invoke checkToken: {}, {}", JwtHelper.getUserName(token), token);
		String message = JwtHelper.getUserName(token);
		if (StringUtils.isNotBlank(message)) {
			return authService.checkToken(token);
		}
		return authService.checkToken(token);
	}

	/**
	 * 维护平台用户登录
	 * 
	 * @param userName
	 *            登录账户/
	 * @param password
	 *            密码
	 * @return
	 */
	@PostMapping("/login")
	public RrcResponse login(String userName, String password) throws UnsupportedEncodingException {
		return authService.login(userName, password);
	}

	/**
	 * 维护平台用户退出
	 * 
	 * @param token
	 *            token
	 * @return
	 */
	@PostMapping("/loginOut")
	public RrcResponse loginOut(String token) {
		return authService.loginOut(token);
	}
	
	@PostMapping("/sendMobileCode")
	public RrcResponse sendMobileCode(String mobile) {
		return authService.sendMobileCode(mobile);
	}
	
	@PostMapping("/varifyMObileCode")
	public RrcResponse varifyMObileCode(String mobile, String code) {
		return authService.varifyMObileCode(mobile, code);
	}

}
