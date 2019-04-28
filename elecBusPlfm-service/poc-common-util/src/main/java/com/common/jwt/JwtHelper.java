package com.common.jwt;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

/*
 * 构造及解析jwt的工具类
 */
public class JwtHelper {

	final static String SUBJECT_USERNAME = "USERNAME";
	final static String SUBJECT_REFRESHTIME = "REFRESHTIME";
	
	/**
	 * 生成签名,EXPIRE TIME 后过期 毫秒
	 * 
	 * @param userId
	 *            用户名
	 * @param secret
	 *            用户的密码
	 * @return 加密的token
	 */
	public static String getToken(String username, String secret, long expireTime) {
		try {
			Date date = new Date(System.currentTimeMillis() + expireTime);
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create().withClaim(SUBJECT_USERNAME, username).withExpiresAt(date).withClaim(SUBJECT_REFRESHTIME, new Date()).sign(algorithm);
			return token;
		} catch (UnsupportedEncodingException e) {
			return "";
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 校验token
	 * @param token
	 * @param username
	 * @param secret
	 * @return
	 */
	public static boolean checkToken(String token, String username, String secret) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			JWTVerifier verifier = JWT.require(algorithm).withClaim(SUBJECT_USERNAME, username).build();
			verifier.verify(token);
			return true;
		} catch (TokenExpiredException exception) {
			return false;
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * 获得token中的信息无需secret解密也能获得
	 * 
	 * @return token中包含的用户名
	 */
	public static String getUserName(String token) {
		try {
			DecodedJWT jwt = JWT.decode(token);
			return jwt.getClaim(SUBJECT_USERNAME).asString();
		} catch (Exception e) {
			return "";
		}
	}

	
	/**
	 * 获得token中的信息无需secret解密也能获得
	 * 
	 * @return token中包含的用户名
	 */
	public static Date getExpireDate(String token) {
		try {
			DecodedJWT jwt = JWT.decode(token);
			return jwt.getExpiresAt();
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 获得token中的信息无需secret解密也能获得
	 * 
	 * @return token中包含的用户名
	 */
	public static Date getRefreshTime(String token) {
		try {
			DecodedJWT jwt = JWT.decode(token);
			return jwt.getClaim(SUBJECT_REFRESHTIME).asDate();
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Map<String, Object> getTokenMap(String token) {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("token", token);
		resultMap.put("refresh_time", JwtHelper.getRefreshTime(token));
		resultMap.put("expire_time", JwtHelper.getExpireDate(token));
		return resultMap;
	}
	
	public static void main(String[] args) {
//		String token = getToken("zjq", "MTIzNDU2", 30000);
//		System.out.println(token);
		System.out.println(checkToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJVU0VSTkFNRSI6InpqcSIsIlJFRlJFU0hUSU1FIjoxNTU2NDIwNjM4LCJleHAiOjE1NTY2Nzk4Mzh9.krlxgj0ZmhYnxeuZ1y2JR3_w0VIjw4clHMU-3vsOeEY",
				"zjq", "SECRET_zjq"));
	}
}
