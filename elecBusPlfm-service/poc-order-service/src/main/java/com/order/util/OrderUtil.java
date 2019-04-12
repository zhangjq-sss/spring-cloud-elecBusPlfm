package com.order.util;

/**
 * @author fazhan.ding
 * @Description
 * @date 2018/6/21 20:47
 */
public class OrderUtil {


    /**
     * 商品类型   1：统一商品  2:自建商品
     */

    public static final  int  UNIFY_PRODUCT=1;
    public static final  int ONESELF_PRODUCT=2;




    /**
     * 初始化参数0
     */
    public  static  final  long  INIT_PARAM=0L;

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
    public  static  final   int   ORDER_STATUS_PAY_INIT=0;
    public  static  final   int   ORDER_STATUS_PAY_SUCCESS=1;
    public  static  final   int   ORDER_STATUS_CANCLE=2;
    public  static  final   int   ORDER_STATUS_PAY_FAIL=3;
    public  static  final   int   ORDER_STATUS_TIME_OVER_CANCLE=4;
    public  static  final   int   ORDER_STATUS_SALES_RETURN=5;
    public  static  final   int   ORDER_STATUS_EMP_CANCLE=6;


    /**
     * 默认的到期时间
     */
    public static  final   String   DATE_DEFAULT_TIME="2099-12-31 23:59:59";


    /**
     * 1：接收退款  2：拒绝退款
     */
    public static final   int  ACCEPT_REFUND=1;
    public static final   int  REFUSED_REFUND=2;


    /**
     * 0：待审核   1：接受退款  2：拒绝退款
     */
    public static final  int   CHECK_STATUS_INIT=0;
    public static final  int   CHECK_STATUS_SUCCESS=1;
    public static final  int   CHECK_STATUS_REFUSE=2;

    /**
     * 1:原渠道返回   2：现金返回
     */
    public static final  int REFUND_PAY_TYPE_ORIGINAL=1;
    public static final  int REFUND_PAY_TYPE_CASH=2;


    /**
     * 类型
     *
     * 1:普及版
     * 2：精英版
     * 3：至尊宝
     * 4：体验版
     */
    public static final  int  CATEGORYTYPE_EDITION=1;
    public static final  int  CATEGORYTYPE_ELITE=2;
    public static final  int  CATEGORYTYPE_EXTREME=3;
    public static final  int  CATEGORYTYPE_EXPERIENCE=4;


    public static  final  String[]  ORDERCOLUMN={"order_status","total_price","create_date","valid_date","expire_date"};
    public static  final  String[]  ORDERDESC={"DESC","ASC","desc","asc"};


    public static  boolean   checkParam(String[] orderColumn,String[] orderDesc){
        int orderColumnLength=0;
        int orderColumnOrderDesc=0;
        if(orderColumn!=null&&orderColumn.length>0){
            boolean  check=false;
            for(String  column:orderColumn){
                boolean checkColumn=false;
                for(String mn:ORDERCOLUMN ){
                    if(mn.equals(column)){
                        checkColumn=true;
                        break;
                    }
                }
                if(!checkColumn){
                    check=false;
                    break;
                }else{
                    check=true;
                }
            }
            if(!check){
                return  check;
            }
            orderColumnLength=orderColumn.length;
        }
        if(orderDesc!=null&&orderDesc.length>0){
            boolean  check=false;
            for(String  desc:orderDesc){
                boolean checkColumn=false;
                for(String sc:ORDERDESC ){
                    if(sc.equals(desc)){
                        checkColumn=true;
                        break;
                    }
                }
                if(!checkColumn){
                    check=false;
                    break;
                }else{
                    check=true;
                }
            }
            if(!check){
                return  check;
            }
            orderColumnOrderDesc=orderDesc.length;
        }
        if(orderColumnLength==orderColumnOrderDesc){
            return true;
        }else{
            return false;
        }
    }


    /**
     * 1：唯一
     * 0：不唯一
     */
    public static final  int  WHERHEUNIONZERO=0;
    public static final  int  WHERHEUNIONONE=1;


    /**
     * 拼接order by  字段
     * @param orderColumn
     * @param orderDesc
     * @return
     */
    public   static   String   merge(String[] orderColumn,String[] orderDesc){
        StringBuffer stringBuffer=new StringBuffer();
        if(orderColumn!=null&&orderColumn.length>0&&orderDesc!=null&&orderColumn.length>0){
            for(int i=0;i<orderColumn.length;i++){
                if(i!=orderColumn.length-1){
                    if("valid_date".equals(orderColumn[i].trim())||"expire_date".equals(orderColumn[i].trim())){
                        stringBuffer.append("o."+orderColumn[i]+" "+orderDesc[i]+", ");
                    }else {
                        stringBuffer.append("b."+orderColumn[i]+" "+orderDesc[i]+", ");
                    }
                }else{
                    if("valid_date".equals(orderColumn[i].trim())||"expire_date".equals(orderColumn[i].trim())){
                        stringBuffer.append("o."+orderColumn[i]+" "+orderDesc[i]+" ");
                    }else{
                        stringBuffer.append("b."+orderColumn[i]+" "+orderDesc[i]+" ");
                    }
                }
            }
        }
        return  stringBuffer.toString();
    }
}
