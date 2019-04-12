package com.common.msg;

import lombok.Data;

@Data
public class BaseResponse {
    private int code = 200;
    private String message;

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(CodeMsg codeMsg){
        this.code = codeMsg.getCode();
        this.message = codeMsg.getMsg();
    }

    public BaseResponse(){
    }
}
