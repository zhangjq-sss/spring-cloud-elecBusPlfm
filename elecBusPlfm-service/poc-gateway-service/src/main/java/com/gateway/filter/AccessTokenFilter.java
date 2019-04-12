package com.gateway.filter;

import com.common.util.JsonUtil;
import com.gateway.client.AuthSeviceFeignClient;
import com.gateway.model.AuthResult;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器,未登录的用户直接返回未登录数据。
 */

@Slf4j
@RefreshScope
public class AccessTokenFilter extends ZuulFilter {

//	private static final String PARAM_TOKEN = "token";

	@Value("${filter.ignore-uri:/api/login,/api/logout,/api/static}")
	private String ignoreUri; 
	
	private ResponseHandler responseHandler;
	
	@Autowired
	private  AuthSeviceFeignClient  authSeviceFeignClient;
	
	
	public  String  getErrorResponse(int status, String message) {
        AuthResult authResult=new AuthResult();
        authResult.setCode(String.valueOf(status));
        authResult.setMessage(message);
		return JsonUtil.toJson(authResult);
	}
	
	@Override
    public Object run() {
    	String[] ignoreArray = ignoreUri.split(",");
		log.debug("== ignoreUri{} ",ignoreUri );
    	
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
//        HttpServletResponse response = ctx.getResponse();
        log.debug("=={} request to url {}  rui: {}", request.getMethod(), request.getRequestURL().toString(), request.getRequestURI() );
        
        String token = request.getHeader("token");
        if(token==null || token.equals("null")){
        	token = null;
        }
        
        boolean flag=false;
        for(int i=0;i<ignoreArray.length;i++){
        	if ( StringUtils.isNotBlank( ignoreArray[i]) ) {
        		if(  request.getRequestURI() .startsWith(ignoreArray[i]) ) {
            		flag = true;
                }
        	}
        }
        
        if(!flag&&token == null){	
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(  HttpServletResponse.SC_UNAUTHORIZED );
            ctx.setResponseBody( getErrorResponse( HttpServletResponse.SC_UNAUTHORIZED,  "token is empty" ) );
            return null;
            
        }else if(!flag&&token != null){
        	
			try {
				AuthResult authResult = authSeviceFeignClient.checkToken(token.toString());
				if( ! authResult.isSuccess() ) {
					  log.error("token invalid! {}", authResult.getMessage() );
					  ctx.setSendZuulResponse(false);
			          ctx.setResponseStatusCode(  HttpServletResponse.SC_UNAUTHORIZED );
			          ctx.setResponseBody(  getErrorResponse( HttpServletResponse.SC_UNAUTHORIZED, authResult.getMessage() ) );
			          
				} else {
					 log.debug("access token ok");
					ctx.setSendZuulResponse(true);
					ctx.setResponseStatusCode(  HttpServletResponse.SC_OK );
				}
			} catch (Exception e) {
				log.error(e.getMessage());
			}
        }
        return null;
    }

	@Override
	public boolean shouldFilter() {
//		HttpServletRequest req = RequestContext.getCurrentContext().getRequest();
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	public ResponseHandler getResponseHandler() {
		return responseHandler;
	}

	public void setResponseHandler(ResponseHandler responseHandler) {
		this.responseHandler = responseHandler;
	}

	@Override
	public String filterType() {
		return  FilterConstants.PRE_TYPE;
	}

}
