package com.auth.service;

import java.io.UnsupportedEncodingException;

import com.auth.model.AuthResult;

/**
 * @author fazhan.ding
 * @Description
 * @date 2018/7/13 11:27
 */
public interface UserService{



    /**
     * 维护平台用户登录
     * @param userName     登录账户/
     * @param password     密码
     * @return
     */
    AuthResult userLogin(String userName, String  password) throws UnsupportedEncodingException;

    /**
     * 维护平台用户验证
     * @param token
     * @return
     */
    AuthResult  userCheckToken(String  token);


    /**
     * 维护平台用户退出
     * @param token
     * @return
     */
    AuthResult userOut(String token);

}
