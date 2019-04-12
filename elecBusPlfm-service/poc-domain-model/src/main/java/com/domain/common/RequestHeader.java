package com.domain.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="RequestHeader", description="请求参数报文头封装类")
@Data
public class RequestHeader {
	
	@ApiModelProperty(value="事业部编码", name="org", example="JDS" , required = true)
	private String   org;//事业部编码
	
	@ApiModelProperty(value="应用编码", name="app", example="jds-app",    required = true)
	private String	app;//应用编码:app/pc 
	
	@ApiModelProperty(value="业务编码", name="biz", example="100"  )
	private String	biz; //业务编码
	
	@ApiModelProperty(value="操作员工号/投顾工号", name="empId", example="1680")
	private String   empId;  //操作员工号/投顾工号
	
	@ApiModelProperty(value="事业部客户唯一标识", name="custId", example="13817886622")
	private String   custId;  //事业部客户唯一标识
	
}
