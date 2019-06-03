package com.admin.constants;

/**
 * 用户相关常量
 */
public interface UserConstants {

	/** 加密次数 */
	int HASH_ITERATIONS = 3;

	String LOGIN_USER = "login_user";

	String USER_PERMISSIONS = "user_permissions";

	/** 登陆token(nginx中默认header无视下划线) */
	String LOGIN_TOKEN = "login-token";
}
