package com.gateway.filter;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;
import static org.springframework.util.ReflectionUtils.rethrowRuntimeException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.common.msg.RrcResponse;
import com.common.util.JsonUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;

/**
 * zuul 错误处理，可以通过设置ErrorHandler自定义返回错误信息和错误码
 */

@Slf4j
public class ErrorFilter extends ZuulFilter {

	public static final String KEY_ERROR = "hasError";

	private ResponseHandler errorHandler;

	@Override
	public boolean shouldFilter() {
		return true;
	}

	public  String  getErrorResponse(int status, String message) {
		return JsonUtil.toJson(new RrcResponse(status, message, null));
	}

	@Override
	public Object run() {

		try {
			RequestContext context = getCurrentContext();
			context.getResponse().setCharacterEncoding("UTF-8");

			log.error("invoke  error {}", context.getThrowable());

			if (null != errorHandler) {
				context.setResponseStatusCode(errorHandler.getResponseCode());
				String body = errorHandler.getResponseBody(null, context.getThrowable());
				context.setResponseBody(body);
				context.getResponse().setContentType("text/html;charset=UTF-8");

			} else {
				context.setResponseStatusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				context.setResponseBody(getErrorResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
						context.getThrowable().getMessage()));
				context.getResponse().setContentType("text/html;charset=UTF-8");
			}
			context.remove("throwable");
			context.put(KEY_ERROR, true);
		} catch (Exception e) {
			rethrowRuntimeException(e);
		}
		return null;
	}

	@Override
	public String filterType() {
		return "error";
	}

	@Override
	public int filterOrder() {
		return FilterConstants.SEND_ERROR_FILTER_ORDER - 1;
	}

	public ResponseHandler getErrorHandler() {
		return errorHandler;
	}

	public void setErrorHandler(ResponseHandler errorHandler) {
		this.errorHandler = errorHandler;
	}

}
