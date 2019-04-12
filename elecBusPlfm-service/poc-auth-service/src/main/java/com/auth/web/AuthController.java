package com.auth.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import com.auth.model.AuthResult;
import com.auth.service.AuthService;
import com.auth.service.UserService;
import com.auth.util.JwtHelper;

import java.io.UnsupportedEncodingException;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {


    static  final  int  DEFAULT_LENGTH=3;


	@Autowired
	private DiscoveryClient client;

	@ResponseBody
	@RequestMapping("/info")
	public Object info() {
		return client.getServices();
	}

	
	@Autowired
	AuthService authService;


	@Autowired
    UserService userService;

	@ResponseBody
	@PostMapping("/checkToken")
	public AuthResult  checkToken(String  token){
		log.info("==invoke checkToken: {}, {}", JwtHelper.getUserName(token),  token);
        String message=JwtHelper.getUserName(token);
        if(StringUtils.isNotBlank(message)){
            if(message.length()>DEFAULT_LENGTH){
                return userService.userCheckToken(token);
            }else{
                return authService.checkToken(token);
            }
        }
		return authService.checkToken(token);
	}


    /**
     * 维护平台用户登录
     * @param userName     登录账户/
     * @param password     密码
     * @return
     */
    @PostMapping("/userLogin")
    public AuthResult  userLogin(String userName,  String  password) throws UnsupportedEncodingException {
        return userService.userLogin(userName, password);
    }

    /**
     * 维护平台用户退出
     * @param token  token
     * @return
     */
    @PostMapping("/userOut")
    public AuthResult  userOut(String  token){
        return  userService.userOut(token);
    }

}
