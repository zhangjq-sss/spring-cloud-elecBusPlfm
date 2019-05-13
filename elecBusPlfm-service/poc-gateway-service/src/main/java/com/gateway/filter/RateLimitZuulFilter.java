package com.gateway.filter;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.common.msg.CodeMsg;
import com.common.msg.RrcResponse;
import com.common.util.JsonUtil;
import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RateLimitZuulFilter extends ZuulFilter {

	private static final String SERVICE_ID_KEY = "serviceId";
	private static final String REQUESTURI_KEY = "requestURI";
    private RateLimiter rateLimiterAll = RateLimiter.create(1000);//并发数每秒1000
    private RateLimiter rateLimiterAddCart = RateLimiter.create(100);//并发数每秒100

    public String getErrorResponse(int status, String message) {
		return JsonUtil.toJson(new RrcResponse(status, message, null));
	}
    
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        // 这边的order一定要大于org.springframework.cloud.netflix.zuul.filters.pre.PreDecorationFilter的order
        // 也就是要大于5
        // 否则，RequestContext.getCurrentContext()里拿不到serviceId等数据。
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    @Override
    public boolean shouldFilter() {
        // 这里可以考虑弄个限流开启的开关，开启限流返回true，关闭限流返回false，你懂的。
        return true;
    }

    @Override
    public Object run() {
        try {
            RequestContext context = RequestContext.getCurrentContext();
            // 对于service格式的路由，走RibbonRoutingFilter
            String serviceId = (String) context.get(SERVICE_ID_KEY);
            if (serviceId != null) {
            	String addCartUrl = (String) context.get(REQUESTURI_KEY);
            	if (addCartUrl.contains("addShopingCart")) {
            		if (!rateLimiterAddCart.tryAcquire(100, TimeUnit.MILLISECONDS)) {
    					context.setSendZuulResponse(false);
    					context.setResponseStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
    					context.setResponseBody(getErrorResponse(CodeMsg.POC_ERROR_LIMIT.getCode(),CodeMsg.POC_ERROR_LIMIT.getMsg()));
    					context.getResponse().setContentType("text/html;charset=UTF-8");
                    }
				}else {
					if (!rateLimiterAll.tryAcquire(100, TimeUnit.MILLISECONDS)) {
						context.setSendZuulResponse(false);
						context.setResponseStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
						context.setResponseBody(getErrorResponse(CodeMsg.POC_ERROR_LIMIT.getCode(),CodeMsg.POC_ERROR_LIMIT.getMsg()));
						context.getResponse().setContentType("text/html;charset=UTF-8");
					}
				}
            	return null;  
            }
            // 如果压根不走RibbonRoutingFilter，则认为是URL格式的路由
            else {
                // 对于URL格式的路由，走SimpleHostRoutingFilter
                URL routeHost = context.getRouteHost();
                if (routeHost != null) {
//                    String url = routeHost.toString();
                }
            }
        } catch (Exception e) {
            ReflectionUtils.rethrowRuntimeException(e);
        }
        return null;
    }
}
