package com.auth.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auth.feign.CustomerFeignController;
import com.auth.model.AuthResult;
import com.auth.service.AuthService;
import com.auth.util.JwtHelper;
import com.common.enums.ConstantsEnum;
import com.domain.constant.ErrorMessage;
import com.domain.constant.ErrorUtil;
import com.domain.customer.model.response.RespCustomerModel;

@Service("authService")
@Transactional(rollbackFor = Exception.class)
public class AuthServiceImpl implements AuthService {

	@Value("${token.expire-time:3600000}")
	long expireTime;
	@Autowired
	private CustomerFeignController customerFeignController;

	public AuthResult checkToken(String token) {
		AuthResult auth = new AuthResult();
		try {
			// 获取用户名
			String username = JwtHelper.getUserName(token);
			if (StringUtils.isBlank(username)) {
				auth.setCode(HttpServletResponse.SC_UNAUTHORIZED + "");
				auth.setMessage("Invalid Identified");
				return auth;
			}
			// 查询数据库获取用户
			RespCustomerModel customer =customerFeignController.selectByUsernameAndPassword(username, null);
			if (customer == null) {
				auth.setCode(ErrorUtil.POC_ERROR_USER_NOACCOUNT);
				auth.setMessage(ErrorMessage.getMsg(ErrorUtil.POC_ERROR_USER_NOACCOUNT));
				return auth;
			}
			// 测试默认通过
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
	public AuthResult login(String userName, String password) throws UnsupportedEncodingException {
		AuthResult result = new AuthResult();
		if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
			result.setCode(ErrorUtil.POC_ERROR_PARAMETER_ERROR);
			result.setMessage(ErrorMessage.getMsg(ErrorUtil.POC_ERROR_PARAMETER_ERROR));
			return result;
		} else {
			// 暂时先使用秘密 Base64
			String base64Password = Base64.getEncoder().encodeToString(password.trim().getBytes("UTF-8"));
			// 查询用户是否存在
			// Customer customer=
			// userReadDao.querySysUserByUserNameAndPassword(userName.trim(),base64Password);
			RespCustomerModel customer = customerFeignController.selectByUsernameAndPassword(userName, base64Password);
			if (customer != null) {
				if (customer.getLockedType()) {
					result.setCode(ErrorUtil.POC_ERROR_USER_ACCOUNT_LOCKED);
					result.setMessage(ErrorMessage.getMsg(ErrorUtil.POC_ERROR_USER_ACCOUNT_LOCKED));
					return result;
				} else {
					if (customer.getStatus().equals(ConstantsEnum.CUSTOMER_STATUS_EXPIRE.getIndex())) {
						result.setCode(ErrorUtil.POC_ERROR_USER_ACCOUNT_STATUS_FALSE);
						result.setMessage(ErrorMessage.getMsg(ErrorUtil.POC_ERROR_USER_ACCOUNT_STATUS_FALSE));
						return result;
					}
					String token = JwtHelper.genToken(userName.trim(), base64Password, expireTime);
					if (StringUtils.isNotBlank(token)) {
						result.setCode("0000");
						Map<String, Object> resultMap = new HashMap<>();
						resultMap.put("token", token);
						result.setData(resultMap);
						return result;
					} else {
						result.setCode(HttpServletResponse.SC_UNAUTHORIZED + "");
						result.setMessage("create token failed!");
						return result;
					}
				}

			} else {
				result.setCode(ErrorUtil.POC_ERROR_USER_UNACCOUNT);
				result.setMessage(ErrorMessage.getMsg(ErrorUtil.POC_ERROR_USER_UNACCOUNT));
				return result;
			}
		}
	}

	@Override
	public AuthResult loginOut(String token) {
		AuthResult auth = new AuthResult();
		if (StringUtils.isBlank(token)) {
			auth.setCode(ErrorUtil.POC_ERROR_PARAMETER_ERROR);
			auth.setMessage(ErrorMessage.getMsg(ErrorUtil.POC_ERROR_PARAMETER_ERROR));
			return auth;
		}
		String username = JwtHelper.getUserName(token);
		if (StringUtils.isBlank(username)) {
			auth.setCode(HttpServletResponse.SC_UNAUTHORIZED + "");
			auth.setMessage("Invalid Identified");
			return auth;
		}
		// 查询数据库获取用户
		RespCustomerModel customer = customerFeignController.selectByUsernameAndPassword(username, null);
		if (customer == null) {
			auth.setCode(ErrorUtil.POC_ERROR_USER_NOACCOUNT);
			auth.setMessage(ErrorMessage.getMsg(ErrorUtil.POC_ERROR_USER_NOACCOUNT));
			return auth;
		}
		//剔除缓存token
		// 测试默认通过
		auth.setCode("0000");
		auth.setMessage("");
		return auth;
	}
}
