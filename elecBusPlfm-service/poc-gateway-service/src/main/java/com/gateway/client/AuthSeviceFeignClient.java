package com.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gateway.client.fallback.AuthSeviceFeignClientFallback;
import com.gateway.model.AuthResult;

@FeignClient(name = "poc-auth-service" , path = "/auth", fallback = AuthSeviceFeignClientFallback.class)
public interface  AuthSeviceFeignClient {
	
	
	@PostMapping("/checkToken")
	public AuthResult  checkToken(@RequestParam("token")  String  token);

    /**
     * 维护平台用户登录
     * @param userName     登录账户/
     * @param password     密码
     * @return
     */
    @PostMapping("/userLogin")
    public AuthResult  userLogin(@RequestParam("userName") String userName,  @RequestParam("password") String  password);

    /**
     * 维护平台用户退出
     * @param token
     * @return
     */
    @PostMapping("/userOut")
    public AuthResult  userOut(@RequestParam("token")  String  token);
	
}
