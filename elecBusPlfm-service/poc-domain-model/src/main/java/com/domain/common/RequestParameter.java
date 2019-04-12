package com.domain.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="RequestParameter", description="请求参数报文封装类")
@Data
public class RequestParameter   {
	
	@ApiModelProperty(value="请求报文头", name="header", example="")
	private RequestHeader   header;
	
	@ApiModelProperty(value="具体业务对象", name="body", example="")
	private Object  body; //business request body
}
