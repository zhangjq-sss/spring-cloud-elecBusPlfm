package com.domain.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * @author fazhan.ding
 * @Description
 * @date 2018/9/12 16:02
 */
public enum OrderTypeMessage {


//    订单类型：
//    purchase   : 申购 （产品设计申购认购归为一类）
//    addition   ：追加
//    redemption : 赎回
    CD_purchase("CD","purchase",1),
    CD_addition("CD","addition",2),
    CD_redemption("CD","redemption",3);


    /**
     * bu订单类型
     */
    String   buOrderType;
    /**
     * poc订单类型
     */
    Integer    pocOrderType;

    /**
     * 事业部编号
     */
    String org;



    OrderTypeMessage(String  org,String buOrderType,Integer pocOrderType){
        this.org=org;
        this.buOrderType=buOrderType;
        this.pocOrderType=pocOrderType;
    }

    public  static  Integer getMsg(String org,String code){
        for(OrderTypeMessage message:OrderTypeMessage.values()){
            boolean  check= StringUtils.isNotBlank(String.valueOf(code))&&code.equals(message.getBuOrderType())&&StringUtils.isNotBlank(org)&&org.equals(message.getOrg());
            if(check){
                return  message.getPocOrderType();
            }
        }
        return Integer.parseInt(code);
    }



    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getBuOrderType() {
        return buOrderType;
    }

    public void setBuOrderType(String buOrderType) {
        this.buOrderType = buOrderType;
    }

    public Integer getPocOrderType() {
        return pocOrderType;
    }

    public void setPocOrderType(Integer pocOrderType) {
        this.pocOrderType = pocOrderType;
    }
}
