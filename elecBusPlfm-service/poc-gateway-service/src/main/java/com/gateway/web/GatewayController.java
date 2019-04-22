package com.gateway.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.common.msg.RrcResponse;
import com.gateway.client.AuthSeviceFeignClient;

@RestController
@RequestMapping("/api")
public class GatewayController {
	
	@Autowired
	private DiscoveryClient client;
	
	@Value("${filter.ignore-uri}")
	private String ignoreUri; 
	
	@Autowired
	private  AuthSeviceFeignClient  authSeviceFeignClient;
	
	@ResponseBody
	@RequestMapping("/info")
	public Object info() {
		System.out.println("--------------"+ignoreUri);
		return client.getServices();
	}
	
	@RequestMapping(value = "/checkToken", method = RequestMethod.POST)
	public RrcResponse checkToken(@RequestParam("token") String  token) {
		return authSeviceFeignClient.checkToken(token);
	}

    /**
     * 维护平台用户登录
     * @param userName     登录账户/
     * @param password     密码
     * @return
     */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public RrcResponse userLogin(@RequestParam("userName") String userName, @RequestParam("password") String  password) {
        return authSeviceFeignClient.login(userName, password);
    }

    /**
     * 维护平台退出
     * @param token   token
     * @return
     */
    @RequestMapping(value = "/loginOut", method = RequestMethod.POST)
    public RrcResponse  userOut(@RequestParam("token") String token){
        return authSeviceFeignClient.loginOut(token);
    }
}
