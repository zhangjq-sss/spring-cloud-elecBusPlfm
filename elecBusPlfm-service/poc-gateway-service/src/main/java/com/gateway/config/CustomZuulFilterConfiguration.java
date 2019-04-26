package com.gateway.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.common.msg.CodeMsg;
import com.common.msg.RrcResponse;
import com.common.util.JsonUtil;
import com.gateway.filter.AccessTokenFilter;
import com.gateway.filter.ErrorFilter;
import com.gateway.filter.ResponseHandler;

@Configuration
public class CustomZuulFilterConfiguration {
	
	@Bean
    public CorsFilter corsFilter() {
    	 final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
         final CorsConfiguration config = new CorsConfiguration();
         config.setAllowCredentials(true); // 允许cookies跨域
         config.addAllowedOrigin("*");// #允许向该服务器提交请求的URI，*表示全部允许，在SpringMVC中，如果设成*，会自动转成当前请求头中的Origin
         config.addAllowedHeader("*");// #允许访问的头信息,*表示全部
         config.setMaxAge(18000L);// 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
         config.addAllowedMethod("*");// 允许提交请求的方法，*表示全部允许
         source.registerCorsConfiguration("/**", config);
         return new CorsFilter(source);
    }
	
	
	@Bean
	public AccessTokenFilter accessTokenFilter(AccessTokenResponseHandler handler) {
		AccessTokenFilter accessTokenFilter = new AccessTokenFilter();
		accessTokenFilter.setResponseHandler(handler);
		return accessTokenFilter;
	}

	@Bean
	public ErrorFilter errorFilter(CustomErrorHandler errorHandler) {
		ErrorFilter errorFilter = new ErrorFilter();
		errorFilter.setErrorHandler(errorHandler);
		return errorFilter;
	}

	@Component
	public class AccessTokenResponseHandler  implements ResponseHandler  {

		@Override
		public int getResponseCode() {
			return HttpServletResponse.SC_OK;
		}

		@Override
		public String getResponseBody(String originMessage, Throwable e) {
			return JsonUtil.toJson(new RrcResponse(CodeMsg.POC_ERROR_TOKEN_EXPIRE));
		}
	}

	/**
	 * zuul 错误处理
	 */
	@Component
	public class CustomErrorHandler implements ResponseHandler {


		@Override
		public int getResponseCode() {
			return HttpServletResponse.SC_OK;
		}

		@Override
		public String getResponseBody(String originMessage, Throwable e) {
			return JsonUtil.toJson(new RrcResponse(CodeMsg.POC_ERROR_REQUEST_OTHER_SERVICE));
		}
	}

}

