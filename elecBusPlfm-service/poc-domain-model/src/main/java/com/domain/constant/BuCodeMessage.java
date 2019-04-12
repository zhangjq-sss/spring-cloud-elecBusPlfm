package com.domain.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * @author fazhan.ding
 * @Description         订单系统用户标识  与crm中用户标识   对应表
 * @date 2018/8/14 17:38
 */
public enum  BuCodeMessage {


    /**
     * JDS:金大师
     * RH：融汇
     * JD:金兜
     * JC:金策
     * TC:技术中心
     * SYS:总部
     * CRM: crm
     * LCS: 融汇理财师
     * CD: 纯达资产
     */
    BU_CODE_RH("RH","RH"),
    BU_CODE_LCS("LCS","RH"),
    BU_CODE_SYS("SYS","SYS"),
    BU_CODE_TC("TC","TC"),
    BU_CODE_JC("JC","JC"),
    BU_CODE_JD("JD","JD"),
    BU_CODE_JDS("JDS","JDS"),
    BU_CODE_CRM("CRM","CRM"),
    BU_CODE_ZG("CD","ZG");


    String child;
    String father;
    private BuCodeMessage(String child, String father){
        this.child=child;
        this.father=father;
    }
    public  static  String getMsg(String code){
        for(BuCodeMessage message:BuCodeMessage.values()){
            if(StringUtils.isNotBlank(code)&&code.equals(message.getChild())){
                return  message.father;
            }
        }
        return  "";
    }


    public String getChild() {
        return child;
    }
    public void setChild(String child) {
        this.child = child;
    }
    public String getFather() {
        return father;
    }
    public void setFather(String father) {
        this.father = father;
    }
}
