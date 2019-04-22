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
import com.auth.util.JwtHelper;
import com.common.enums.ConstantsEnum;
import com.common.msg.CodeMsg;
import com.common.msg.RrcResponse;
import com.domain.customer.model.response.RespCustomerModel;
import com.sun.jersey.spi.inject.Errors.ErrorMessage;

@Service("authService")
@Transactional(rollbackFor = Exception.class)
public class AuthServiceImpl implements AuthService {

	@Value("${token.expire-time:3600000}")
	long expireTime;
	@Autowired
	private CustomerFeignController customerFeignController;

	public RrcResponse checkToken(String token) {
		RrcResponse auth = new RrcResponse(CodeMsg.SUCCESS);
		try {
			// 获取用户名
			String username = JwtHelper.getUserName(token);
			if (StringUtils.isBlank(username)) {
				auth.setCode(HttpServletResponse.SC_UNAUTHORIZED);
				auth.setMessage("Token error");
				return auth;
			}
			// 查询数据库获取用户
			RespCustomerModel customer =customerFeignController.selectByUsernameAndPassword(username, null);
			if (customer == null||StringUtils.isBlank(customer.getToken())) {
				return new RrcResponse(CodeMsg.POC_ERROR_USER_NOACCOUNT);
			}
			//校验token
			if (!JwtHelper.checkToken(token, username, customer.getPassword())||!token.equals(customer.getToken())) {
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
			return new RrcResponse(CodeMsg.POC_ERROR_USER_NOACCOUNT);
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
					String token = JwtHelper.getToken(userName.trim(), base64Password, expireTime);
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
		String username = JwtHelper.getUserName(token);
		if (StringUtils.isBlank(username)) {
			auth.setCode(HttpServletResponse.SC_UNAUTHORIZED);
			auth.setMessage("Invalid Identified");
			return auth;
		}
		// 查询数据库获取用户
		RespCustomerModel customer = customerFeignController.selectByUsernameAndPassword(username, null);
		if (customer == null||StringUtils.isBlank(customer.getToken())) {
			return new RrcResponse(CodeMsg.POC_ERROR_USER_NOACCOUNT);
		}
		//校验token
		if (!JwtHelper.checkToken(token, username, customer.getPassword())||!token.equals(customer.getToken())) {
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
}
