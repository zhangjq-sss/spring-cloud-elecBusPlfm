package com.domain.common;

/**
 * 业务字典工具类
 */
public class BusinessDictionaryUtil {


    /**
     * 商品列表1001
     * 商品详情1002
     * 产商品关注/取消接口1003
     * 判断用户是否关注产商品接口1004
     * 下单成功，产商品扣库存1005
     * 根据传入的数据，计算总的折扣价格，总的活动价格,总的原始价格,是否凑单1006
     * 根据产商品id，数量  计算每个商品的策划后的价格1007
     * 订单取消 产商品增库存1008
     * 获取产品列表中有效的商品  1009
     *
     * 商品权益 1010
     * 根据产品id及产品数量 封装产品列表属性 1011
     * 根据产商品id,数量判断库存1012
     */
    public   static final   int PRODUCT_LIST=1001;
    public  static final   int  PRODUCT_DETAIL=1002;
    public  static final   int  PRODUCT_ATTENTION=1003;
    public  static final   int  PRODUCT_CHECK_ATTENTION=1004;
    public  static final   int  PRODUCT_INVENTORY_REDUCTION=1005;
    public  static final   int  PRODUCT_CALCULATE_PRICE=1006;
    public  static final   int  PRODUCT_CALCULATE_EACH_PRICE_AFTER_PLAN=1007;
    public  static final   int  PRODUCT_INVENTORY_RESTORE=1008;
    public  static final   int  PRODUCT_VALID=1009;
    public  static final   int  PRODUCT_POWER=1010;
    public  static final   int  PRODUCT_INVENTORY=1011;
    public  static final   int  PRODUCT_PACKAGING=1012;
    /**
     * 策划列表2001
     * 根据策划id,查询出对应的商品列表2002
     */
    public static final int PLAN_LIST=2001;
    public static final int PLAN_PRODUCT_LIST=2002;
    /**
     * 折扣列表3001
     * 根据折扣id,查询出对应的商品列表3002
     */
    public static final  int DISCOUNT_LIST=3001;
    public static final  int DISCOUNT_PRODUCT_LIST=3002;
    /**
     * 查询优惠券列表4001
     * 领取优惠券4002
     * 查询我的优惠券4003
     * 查询满足当前条件的有效的优惠券列表4004
     * 根据商品列表，优惠券列表，计算最终金额4005
     * 下单成功锁定优惠券4006
     * 支付成功核销优惠券4007
     * 支付取消还原相关优惠券4008
     */
    public static final  int PROMOTION_LIST=4001;
    public static final  int PROMOTION_GET=4002;
    public static final  int PROMOTION_FIND_MYSELF=4003;
    public static final  int PROMOTION_CURRENT_CONDITIONS_LIST=4004;
    public static final  int PROMOTION_CALCULATE_PRICE=4005;
    public static final  int PROMOTION_ORDER_SUBMIT_LOCK=4006;
    public static final  int PROMOTION_PAY_SUCCESS_CANCEL_AFTER_VERIFICATION=4007;
    public static final  int PROMOTION_PAY_CANCLE_RESTORE=4008;
    /**
     * 基础类型表5001
     * 定时任务参数设置列表5002
     */
    public static final int  BASE_TYPE=5001;
    public static final int  BASE_SYS_PARAMETER=5002;
    /**
     * 新增购物车信息6001
     * 删除购物车信息6002
     * 修改购物车信息6003
     * 查询购物车信息6004
     */
    public static final int  SHOPPING_CART_ADD =6001;
    public static final int  SHOPPING_CART_DELETE=6002;
    public static final int  SHOPPING_CART_UPDATE=6003;
    public static final int  SHOPPING_CART_FIND=6004;

    /**
     * 新增订单7001
     * 取消订单7002
     * 修改订单7003
     * 分页查询购我的订单7004
     * 我的产品7005
     * 订单详情7006
     *
     * 触发定时任务   订单超时-自动取消7007
     */
    public static final int  ORDER_ADD=7001;
    public static final int  ORDER_CANCALE=7002;
    public static final int  ORDER_UPDATE=7003;
    public static final int  ORDER_LIST_BY_PAGE=7004;
    public static final int  ORDER_MY_PRODUCT=7005;
    public static final int  ORDER_DETAIL=7006;
    public static final int  ORDER_TIME_OVER_EXECUTE=7007;
    /**
     * 同步客户信息-获取订单系统客户ID  8001
     */
    public static final int  SYNCHRONIZATION_CUST=8001;
    
    /**
     * 开启支付9001
     * 同步日志9002
     * 支付退款9003
     * 支付查询9004
     * 异步回调-支付宝9005
     * 异步回调-微信9006
     * 异步回调-银联9007
     * 异步回调-银联商务全名付9008
     * 
     * 添加应用9010
     * 更新应用9011
     * 应用详情9012
     * 应用列表9013
     * 删除应用9014
     * 添加应用支付渠道及参数9015
     * 修改应用支付渠道及参数9016
     * 删除应用支付渠道及参数9017
     * 添加全局支付渠道自己的参数9018
     * 修改全局支付渠道自己的参数9019
     * 删除全局支付渠道自己的参数9020
     * 全局支付渠道自己的参数列表9021
     * 验证当前应用的支付渠道是否重复9022
     * 支付渠道编辑/详情9023
     * 通过应用id查询当前应用支持的支付渠道9024
     * 通过应用code查询当前应用支持的支付渠道9025
     * 
     * 支付记录列表9030
     * 支付记录详情9031
     * 记录详情时间维度 日 周 月 季度9032
     * 
     * 添加渠道或产品分账户9040
     * 删除渠道或产品分账户9041
     * 更新渠道或产品分账户9042
     * 查询渠道或产品分账户9043
     */
    public static final int  PAY_OPENPAY=9001;
    public static final int  PAY_SYNCHPAYLOG=9002;
    public static final int  PAY_REFUND=9003;
    public static final int  PAY_QUERY=9004;
    public static final int  PAY_ASYNCHRONOUS_ALIPAY=9005;
    public static final int  PAY_ASYNCHRONOUS_WXPAY=9006;
    public static final int  PAY_ASYNCHRONOUS_UNIONPAY=9007;
    
    public static final int  PAY_ADDAPP=9010;
    public static final int  PAY_UPDATEAPP=9011;
    public static final int  PAY_DETAILAPP=9012;
    public static final int  PAY_LISTAPP=9013;
    public static final int  PAY_DELETEAPP=9014;
    public static final int  PAY_ADDAPPCHAN_PARAM=9015;
    public static final int  PAY_UPDATEAPPCHAN_PARAM=9016;
    public static final int  PAY_DELETEAPPCHAN_PARAM=9017;
    public static final int  PAY_ADDCHAN_PARAM=9018;
    public static final int  PAY_UPDATECHAN_PARAM=9019;
    public static final int  PAY_DELETECHAN_PARAM=9020;
    public static final int  PAY_QUERYCHAN_PARAM=9021;
    public static final int  PAY_VERIFYCHANREL=9022;
    public static final int  PAY_EDITAPPCHAN_PARAM=9023;
    public static final int  PAY_QUERYAPPCHANNEL_ID=9024;
    public static final int  PAY_QUERYAPPCHANNEL_CODE=9025;
    
    public static final int  PAY_QUERYPAYRECORD=9030;
    public static final int  PAY_DETAILPAYRECORD=9031;
    public static final int  PAY_DETAILPAYRECORD_TIME=9032;


    /**
     * 定时任务
     */
    public static final int  JDS_PAY_TIME_OVER_TASK=10001;
}
