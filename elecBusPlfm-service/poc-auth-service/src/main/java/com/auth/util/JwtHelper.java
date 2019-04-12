package com.auth.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

/*
 * 构造及解析jwt的工具类
 */
public class JwtHelper {

	final static String SUBJECT_ID = "USERNAME";

	/**
	 * 校验token是否正确
	 * 
	 * @param token
	 * @param secret
	 *            用户的密码
	 * @return 是否正确
	 */
	public static int checkToken(String token, String userId, String secret) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			JWTVerifier verifier = JWT.require(algorithm).withClaim(SUBJECT_ID, userId).build();
			DecodedJWT jwt = verifier.verify(token);
			return 0;
		} catch (TokenExpiredException exception) {
			return -1;
		} catch (Exception exception) {
			return -2;
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
			return jwt.getClaim(SUBJECT_ID).asString();
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 生成签名,EXPIRE TIME 后过期
	 * 
	 * @param userId
	 *            用户名
	 * @param secret
	 *            用户的密码
	 * @return 加密的token
	 */
	public static String genToken(String username, String secret, long expireTime) {
		try {
			Date date = new Date(System.currentTimeMillis() + expireTime);
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create().withClaim(SUBJECT_ID, username).withExpiresAt(date).sign(algorithm);
			return token;
		} catch (UnsupportedEncodingException e) {
			return "";
		} catch (Exception e) {
			return "";
		}
	}

}
