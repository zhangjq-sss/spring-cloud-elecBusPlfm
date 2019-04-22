package com.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.msg.RrcResponse;
import com.gateway.client.fallback.AuthSeviceFeignClientFallback;

@FeignClient(name = "poc-auth-service", path = "/auth", fallback = AuthSeviceFeignClientFallback.class)
//@FeignClient(name = "poc-auth-service", path = "/auth")
public interface AuthSeviceFeignClient {

	@PostMapping("/checkToken")
	public RrcResponse checkToken(@RequestParam("token") String token);

	/**
	 * 维护平台用户登录
	 * 
	 * @param userName
	 *            登录账户/
	 * @param password
	 *            密码
	 * @return
	 */
	@PostMapping("/login")
	public RrcResponse login(@RequestParam("userName") String userName, @RequestParam("password") String password);

	/**
	 * 维护平台用户退出
	 * 
	 * @param token
	 * @return
	 */
	@PostMapping("/loginOut")
	public RrcResponse loginOut(@RequestParam("token") String token);
	
	@PostMapping("/sendMobileCode")
	public RrcResponse sendMobileCode(@RequestParam("mobile") String mobile);
	
	@PostMapping("/varifyMObileCode")
	public RrcResponse varifyMObileCode(@RequestParam("mobile") String mobile, @RequestParam("code") String code);

}
