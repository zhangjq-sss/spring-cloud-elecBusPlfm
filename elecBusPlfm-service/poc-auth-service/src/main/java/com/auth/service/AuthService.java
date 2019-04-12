package com.auth.service;

import com.auth.model.AuthResult;

/**
* @ClassName: AuthService
* @Description: 认证服务处理
* @author 
* @date 2018-05-22 11:33:05
*/

public interface AuthService {
	AuthResult  checkToken(String token);
}
