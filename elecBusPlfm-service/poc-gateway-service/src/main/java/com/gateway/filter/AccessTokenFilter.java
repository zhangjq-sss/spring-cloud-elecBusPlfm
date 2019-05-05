package com.gateway.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.common.enums.ConstantsEnum;
import com.common.jwt.JwtHelper;
import com.common.msg.CodeMsg;
import com.common.msg.RrcResponse;
import com.common.util.JsonUtil;
import com.domain.customer.model.response.RespCustomerModel;
import com.gateway.client.CustomerFeignController;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;

/**
 * 登录拦截器,未登录的用户直接返回未登录数据。
 */

@Slf4j
@RefreshScope
public class AccessTokenFilter extends ZuulFilter {

	// private static final String PARAM_TOKEN = "token";

	@Value("${filter.ignore-uri:/api/login,/api/logout,/api/static,/api/sendMobileCode,/api/varifyMObileCode}")
	private String ignoreUri;

	private ResponseHandler responseHandler;
	@Autowired
	private CustomerFeignController customerFeignController;

	public String getErrorResponse(int status, String message) {
		return JsonUtil.toJson(new RrcResponse(status, message, null));
	}

	@Override
	public Object run() {
		String[] ignoreArray = ignoreUri.split(",");
		log.debug("== ignoreUri{} ", ignoreUri);

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		// HttpServletResponse response = ctx.getResponse();
		log.debug("=={} request to url {}  rui: {}", request.getMethod(), request.getRequestURL().toString(),
				request.getRequestURI());

		String token = request.getHeader("token");
		if (token == null || token.equals("null")) {
			token = null;
		}

		boolean flag = false;
		for (int i = 0; i < ignoreArray.length; i++) {
			if (StringUtils.isNotBlank(ignoreArray[i])) {
				if (request.getRequestURI().startsWith(ignoreArray[i])) {
					flag = true;
				}
			}
		}

		if (!flag && token == null) {
			log.warn("token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
			ctx.setResponseBody(getErrorResponse(CodeMsg.POC_ERROR_USER_NOACCOUNT.getCode(),CodeMsg.POC_ERROR_USER_NOACCOUNT.getMsg()));
			ctx.getResponse().setContentType("text/html;charset=UTF-8");
			return null;

		} else if (!flag && token != null) {
			try {
				if (!checkToken(token)) {
					log.error("token invalid! {}", CodeMsg.POC_ERROR_TOKEN_EXPIRE.getMsg());
					ctx.setSendZuulResponse(false);
					ctx.setResponseStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
					ctx.setResponseBody(getErrorResponse(CodeMsg.POC_ERROR_TOKEN_EXPIRE.getCode(),CodeMsg.POC_ERROR_TOKEN_EXPIRE.getMsg()));
					ctx.getResponse().setContentType("text/html;charset=UTF-8");
				} else {
					log.debug("access token ok");
					ctx.setSendZuulResponse(true);
					ctx.setResponseStatusCode(HttpServletResponse.SC_OK);
				}
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// HttpServletRequest req = RequestContext.getCurrentContext().getRequest();
		return true;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.PRE_DECORATION_FILTER_ORDER + 2;
	}

	public ResponseHandler getResponseHandler() {
		return responseHandler;
	}

	public void setResponseHandler(ResponseHandler responseHandler) {
		this.responseHandler = responseHandler;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}
	
	public boolean checkToken(String token) {
		// 获取用户名
		String userName = JwtHelper.getUserName(token);
		if (StringUtils.isBlank(userName)) {
			return false;
		}
		// 查询数据库获取用户
		RespCustomerModel customer = customerFeignController.selectByUsernameAndPassword(userName, null);
		if (customer == null || StringUtils.isBlank(customer.getToken())) {
			return false;
		}
		// 校验token
		if (!JwtHelper.checkToken(token, userName, ConstantsEnum.JWT_SECRET.getIndex() + userName)
				|| !token.equals(customer.getToken())) {
			return false;
		}
		
		return true;
	}

}
