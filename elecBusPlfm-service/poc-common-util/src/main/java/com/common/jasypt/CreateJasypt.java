package com.common.jasypt;

import org.jasypt.util.text.BasicTextEncryptor;

public class CreateJasypt {
	public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)
        textEncryptor.setPassword("2018199836217578019236");
        //要加密的数据（数据库的用户名或密码）
        String username = textEncryptor.encrypt("*******");
        String password = textEncryptor.encrypt("******");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
    }
}
