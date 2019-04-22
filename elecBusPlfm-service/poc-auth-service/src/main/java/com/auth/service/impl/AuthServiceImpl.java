package com.auth.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auth.feign.CustomerFeignController;
import com.auth.service.AuthService;
import com.auth.service.RedisService;
import com.auth.util.JwtHelper;
import com.common.enums.ConstantsEnum;
import com.common.msg.CodeMsg;
import com.common.msg.RrcResponse;
import com.common.util.RandomCodeUtils;
import com.domain.customer.model.response.RespCustomerModel;

@Service("authService")
@Transactional(rollbackFor = Exception.class)
public class AuthServiceImpl implements AuthService {

	@Value("${mobile.expire-time:120}")
	long mobileExpireTime;
	@Value("${token.expire-time:3600000}")
	long tokenExpireTime;
	@Autowired
	private CustomerFeignController customerFeignController;
	@Autowired
	private RedisService redisService;

	public RrcResponse checkToken(String token) {
		RrcResponse auth = new RrcResponse(CodeMsg.SUCCESS);
		try {
			// 获取用户名
			String userName = JwtHelper.getUserName(token);
			if (StringUtils.isBlank(userName)) {
				auth.setCode(HttpServletResponse.SC_UNAUTHORIZED);
				auth.setMessage("Token error");
				return auth;
			}
			// 查询数据库获取用户
			RespCustomerModel customer =customerFeignController.selectByUsernameAndPassword(userName, null);
			if (customer == null||StringUtils.isBlank(customer.getToken())) {
				return new RrcResponse(CodeMsg.POC_ERROR_USER_NOACCOUNT);
			}
			//校验token
			if (!JwtHelper.checkToken(token, userName, ConstantsEnum.JWT_SECRET.getIndex()+userName)||!token.equals(customer.getToken())) {
				auth.setCode(HttpServletResponse.SC_UNAUTHORIZED );
				auth.setMessage("Token check fail");
				return auth;
			}
			auth.setData(JwtHelper.getTokenMap(token));
			return auth;

		} catch (Exception e) {
			auth.setCode(HttpServletResponse.SC_UNAUTHORIZED);
			auth.setMessage("Invalid token");
			return auth;
		}
	}

	/**
	 * 平台用户登录
	 * 
	 * @param userName
	 *            登录账户/
	 * @param password
	 *            密码
	 * @return
	 */
	@Override
	public RrcResponse login(String userName, String password) throws UnsupportedEncodingException {
		RrcResponse result = new RrcResponse(CodeMsg.SUCCESS);
		if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
			return new RrcResponse(CodeMsg.POC_ERROR_PARAMETER);
		} else {
			// 暂时先使用秘密 Base64
			String base64Password = Base64.getEncoder().encodeToString(password.trim().getBytes("UTF-8"));
			// 查询用户是否存在
			// Customer customer=
			// userReadDao.querySysUserByUserNameAndPassword(userName.trim(),base64Password);
			RespCustomerModel customer = customerFeignController.selectByUsernameAndPassword(userName, base64Password);
			if (customer != null) {
				if (customer.getLockedType()) {
					return new RrcResponse(CodeMsg.POC_ERROR_USER_ACCOUNT_LOCKED);
				} else {
					if (customer.getStatus().equals(ConstantsEnum.CUSTOMER_STATUS_EXPIRE.getIndex())) {
						return new RrcResponse(CodeMsg.POC_ERROR_USER_ACCOUNT_STATUS_FALSE);
					}
					String token = JwtHelper.getToken(userName, ConstantsEnum.JWT_SECRET.getIndex()+userName, tokenExpireTime);
					if (StringUtils.isNotBlank(token)) {
						//存数据库
						if (!customerFeignController.updateCustToken(customer.getCustId(), token)) {
							return new RrcResponse(CodeMsg.FAIL);
						}
						result.setData(JwtHelper.getTokenMap(token));
						return result;
					} else {
						result.setCode(HttpServletResponse.SC_UNAUTHORIZED);
						result.setMessage("create token failed!");
						return result;
					}
				}

			} else {
				return new RrcResponse(CodeMsg.POC_ERROR_USER_UNACCOUNT);
			}
		}
	}

	@Override
	public RrcResponse loginOut(String token) {
		RrcResponse auth = new RrcResponse(CodeMsg.SUCCESS);
		if (StringUtils.isBlank(token)) {
			return new RrcResponse(CodeMsg.POC_ERROR_PARAMETER);
		}
		String userName = JwtHelper.getUserName(token);
		if (StringUtils.isBlank(userName)) {
			auth.setCode(HttpServletResponse.SC_UNAUTHORIZED);
			auth.setMessage("Invalid Identified");
			return auth;
		}
		// 查询数据库获取用户
		RespCustomerModel customer = customerFeignController.selectByUsernameAndPassword(userName, null);
		if (customer == null||StringUtils.isBlank(customer.getToken())) {
			return new RrcResponse(CodeMsg.POC_ERROR_USER_NOACCOUNT);
		}
		//校验token
		if (!JwtHelper.checkToken(token, userName, ConstantsEnum.JWT_SECRET.getIndex()+userName)||!token.equals(customer.getToken())) {
			auth.setCode(HttpServletResponse.SC_UNAUTHORIZED);
			auth.setMessage("Token check fail");
			return auth;
		}
		//剔除缓存token 数据
		//存数据库
		if (!customerFeignController.updateCustToken(customer.getCustId(), "")) {
			return new RrcResponse(CodeMsg.FAIL);
		}
		return auth;
	}

	@Override
	public RrcResponse sendMobileCode(String mobile) {
		RrcResponse auth = new RrcResponse(CodeMsg.SUCCESS);
		// 验证手机号是否存在
		if (StringUtils.isBlank(mobile)) {
			return new RrcResponse(CodeMsg.POC_ERROR_PARAMETER);
		}
		RespCustomerModel customer = customerFeignController.selectByMobile(mobile);
		if (customer==null) {
			return new RrcResponse(CodeMsg.POC_ERROR_USER_NOMOBILE);
		}
		// 生产4位验证码
		String code = RandomCodeUtils.getRandomNumCode(4);
		//发送短信
		
		// 存redis缓存
		redisService.set(ConstantsEnum.REDIS_MOBILE.getIndex() + mobile, code);
		redisService.expire(ConstantsEnum.REDIS_MOBILE.getIndex() + mobile, mobileExpireTime);
		return auth;
	}

	@Override
	public RrcResponse varifyMObileCode(String mobile, String code) {
		RrcResponse result = new RrcResponse(CodeMsg.SUCCESS);
		if (StringUtils.isBlank(mobile)||StringUtils.isBlank(code)) {
			return new RrcResponse(CodeMsg.POC_ERROR_PARAMETER);
		}
		RespCustomerModel customer = customerFeignController.selectByMobile(mobile);
		if (customer==null) {
			return new RrcResponse(CodeMsg.POC_ERROR_USER_NOMOBILE);
		}
		String redisCode = redisService.get(ConstantsEnum.REDIS_MOBILE.getIndex() + mobile);
		if (StringUtils.isBlank(redisCode)||!redisCode.equals(code)){
			return new RrcResponse(CodeMsg.POC_ERROR_MOBILECODE);
		}
		String token = JwtHelper.getToken(customer.getUsername(), ConstantsEnum.JWT_SECRET.getIndex()+customer.getUsername(), tokenExpireTime);
		if (StringUtils.isNotBlank(token)) {
			//存数据库
			if (!customerFeignController.updateCustToken(customer.getCustId(), token)) {
				return new RrcResponse(CodeMsg.FAIL);
			}
			result.setData(JwtHelper.getTokenMap(token));
			return result;
		} else {
			result.setCode(HttpServletResponse.SC_UNAUTHORIZED);
			result.setMessage("create token failed!");
			return result;
		}
	}
}
