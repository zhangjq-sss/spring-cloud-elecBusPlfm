package com.domain.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * @author fazhan.ding
 * @Description
 * @date 2018/6/4 9:08
 *
 * 错误信息封装
 *
 */

public enum ErrorMessage {

    POC_SUCCESS("0000",""),
    POC_ERROR_NETWORK("0001","网络不可用"),
    POC_ERROR_PARAMETER_ERROR("0002","参数错误"),
    POC_ERROR_SYSTEM_ERROR("9999","unkown"),
    POC_ERROR_CONFLIT_FAILED("2003","此数据已被使用,无法删除"),
	POC_ERROR_UPDATE_FAILED("2000","修改失败，没有找到对应的记录"),
    POC_ERROR_DELETE_FAILED("2001","删除失败，没有找到对应的记录"),
    POC_ERROR_SAVE_FAILED("2002","添加失败，没有找到对应的记录"),
    POC_ERROR_SELECT_FAILED("2005","查询失败，没有找到对应的记录"),
    
	PAY_ERROR("3001","支付有误"),

    POC_ERROR_PRODUCT_CHECK_MESSAGE_ERROR("4000","抱歉,部分商品信息已失效,请刷新后重试"),
    POC_ERROR_PRODUCT_CHECK_INVENTORY_ERROR("4001","商品[%s] 库存不足,购买失败"),






    POC_ERROR_USER_UNACCOUNT("6000","帐号或密码错误"),
    POC_ERROR_USER_ACCOUNT_LOCKED("6001","帐号已被锁定"),
    POC_ERROR_USER_ACCOUNT_STATUS_FALSE("6002","帐号已失效"),
    POC_ERROR_USER_NOACCOUNT("6003","帐号不存在"),


    POC_ERROR_USER_ACCOUNT_UNIQUE("6005","抱歉,系统用户名已存在"),
	POC_ERROR_ROLE_ACCOUNT_UNIQUE("6006","抱歉,角色名称已存在"),
    POC_ERROR_PERMISSION("6007","权限不足"),
    POC_ERROR_USER_OVERTIME("6008","超时"),
    POC_SUBMIT_REPETITION("9998","请勿重复提交数据"),
    POC_ORDER_PROCESS_CHECK_INIT("2006","抱歉订单已经存在未审核的退款申请,无法再次发起申请"),
    POC_ORDER_STATUS_ERROR("2007","抱歉订单状态错误，操作失败");



    String code;
    String msg;
    private ErrorMessage(String code, String msg){
        this.msg=msg;
        this.code=code;
    }
    public  static  String getMsg(String code){
        for(ErrorMessage errorMessage:ErrorMessage.values()){
            if(StringUtils.isNotBlank(code)&&code.equals(errorMessage.getCode())){
                return  errorMessage.msg;
            }
        }
        return  "";
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}