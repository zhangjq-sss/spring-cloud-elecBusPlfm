package com.auth.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth.model.AuthResult;
import com.auth.service.AuthService;
import com.auth.util.JwtHelper;

@Service("authService")
public class AuthServiceImpl implements AuthService {

	@Value("${token.expire-time:3600000}")
	long expireTime;

	public AuthResult checkToken(String token) {
		AuthResult auth = new AuthResult();
		try {
			String username = JwtHelper.getUserName(token);
			if (StringUtils.isBlank(username)) {
				auth.setCode(HttpServletResponse.SC_UNAUTHORIZED + "");
				auth.setMessage("Invalid Identified");
				return auth;
			}
			auth.setCode("0000");
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("token", token);
			auth.setData(resultMap);
			return auth;
			
		} catch (Exception e) {
			auth.setCode(HttpServletResponse.SC_UNAUTHORIZED + "");
			auth.setMessage("Invalid token");
			return auth;
		}
	}
}
