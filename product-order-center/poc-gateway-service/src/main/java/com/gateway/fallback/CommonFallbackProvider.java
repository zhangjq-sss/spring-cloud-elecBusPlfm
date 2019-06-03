package com.gateway.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.common.msg.CodeMsg;
import com.common.msg.RrcResponse;
import com.common.util.JsonUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CommonFallbackProvider implements FallbackProvider{

	@Override
	public String getRoute() {
		return "*";
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
            	//增加zuul找不到服务异常返回信息
            	log.info("---zuul找不到服务器----");
                return new ByteArrayInputStream(JsonUtil.toJson(new RrcResponse(CodeMsg.POC_ERROR_ZUUL.getCode(), CodeMsg.POC_ERROR_ZUUL.getMsg(), null)).getBytes("UTF-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
	}
}
