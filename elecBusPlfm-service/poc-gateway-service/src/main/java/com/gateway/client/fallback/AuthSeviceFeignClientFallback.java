package com.gateway.client.fallback;

import org.springframework.stereotype.Component;

import com.common.msg.CodeMsg;
import com.common.msg.RrcResponse;
import com.gateway.client.AuthSeviceFeignClient;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AuthSeviceFeignClientFallback  implements  AuthSeviceFeignClient {

    @Override
	public RrcResponse checkToken(String  token) {
    	log.info("校验token请求出错-auth");
		return new RrcResponse(CodeMsg.FAIL);
	}

    @Override
    public RrcResponse login(String userName, String password) {
    	log.info("登录请求出错-auth");
    	return new RrcResponse(CodeMsg.FAIL);
    }

	@Override
	public RrcResponse loginOut(String token) {
		log.info("用户退出请求出错-auth");
		return new RrcResponse(CodeMsg.FAIL);
	}

}
