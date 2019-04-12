package com.domain.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

import com.domain.constant.ErrorMessage;
import com.domain.constant.ErrorUtil;

@ApiModel(value="Result", description="应答结果报文封装类")
@Data
public class Result implements Serializable {

	private static final long serialVersionUID = -8895537618998707011L;
    
	@ApiModelProperty(value="结果编码", name="code", example="0000")
	private String	code;
	
	@ApiModelProperty(value="错误原因描述", name="message",example="网络超时")
	private String   message;
	
	@ApiModelProperty(value="业务对象", name="data",example="")
	private Object  data; //data
	
	public Result() {
		this.code = ErrorUtil.POC_ERROR_SYSTEM_ERROR;
		this.message = ErrorMessage.getMsg(ErrorUtil.POC_ERROR_SYSTEM_ERROR);
		data = null;
	}

	public  void  success(){
		this.code="0000";
		this.message="";
	}

	public  Result(String code,String message,Object object){
	    this.code=code;
	    this.message=message;
        this.data=object;
    }


	public boolean isSuccess() {
		return  "0000".equals( this.code);
	}
	
}
