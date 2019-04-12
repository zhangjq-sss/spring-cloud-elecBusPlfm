package com.domain.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * @author fazhan.ding
 * @Description
 * @date 2018/8/21 17:34
 */

public enum  OrderCodeMessage {
    /**
     * 订单状态
     0:待支付
     1:支付成功
     2:客户取消
     3:支付失败
     4:支付时间到期取消
     5:退款退货
     6:管理员手动取消
     */


    /**
     * LCS事业部中状态转换
     * 1--》0    未支付
     * 2--》1    支付成功
     * 3--》5    退款
     */
    LCS_WAIT("LCS","1",0),
    LCS_SUCCESS("LCS","2",1),
    LCS_SALES_RETURN("LCS","3",5),


//    资管事业部订单状态转换================
//    created       订单创建状态，后台的逻辑状态，此状态不应当被用户感知
//    applying       订单申请状态，订单被完成和撤销前都保持此状态
//    applied       订单已经完成
//    canceled      用户撤销订单
//    calmnToCancel 用户冷静期确认撤销订单
//    adminCancel   后台运营管理人员撤销订单
    CD_CREATED("CD","created",11),
    CD_APPLYING("CD","applying",12),
    CD_APPLIED("CD","applied",13),
    CD_CANCELED("CD","canceled",2),
    CD_CALMN_TO_CANCEL("CD","calmnToCancel",14),
    CD_ADMIN_CANCEL("CD","adminCancel",6);







    /**
     * 事业部订单状态
     */
    String buOrderStatus;
    /**
     * 订单系统订单状态
     */
    Integer pocOrderStatus;
    /**
     * 事业部编号
     */
    String org;
     OrderCodeMessage(String  org,String buOrderStatus, Integer pocOrderStatus){
        this.buOrderStatus=buOrderStatus;
        this.pocOrderStatus=pocOrderStatus;
        this.org=org;
    }

    /**
     * 根据事业部编号，及事业部订单状态   返回订单系统的订单状态
     * @param org
     * @param code
     * @return
     */
    public  static  Integer getMsg(String org,String code){
        for(OrderCodeMessage message:OrderCodeMessage.values()){
            boolean  check=StringUtils.isNotBlank(String.valueOf(code))&&code.equals(message.getBuOrderStatus())&&StringUtils.isNotBlank(org)&&org.equals(message.getOrg());
            if(check){
                return  message.getPocOrderStatus();
            }
        }
        return Integer.parseInt(code);
    }

    public String getBuOrderStatus() {
        return buOrderStatus;
    }

    public void setBuOrderStatus(String buOrderStatus) {
        this.buOrderStatus = buOrderStatus;
    }

    public Integer getPocOrderStatus() {
        return pocOrderStatus;
    }

    public void setPocOrderStatus(Integer pocOrderStatus) {
        this.pocOrderStatus = pocOrderStatus;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }
}
