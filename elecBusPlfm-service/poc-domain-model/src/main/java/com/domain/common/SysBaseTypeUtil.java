package com.domain.common;

public class SysBaseTypeUtil {
	// 支付渠道方式
	public static final String ALIPAY = "alipay";// 支付宝app支付
	public static final String WX = "wx";// 微信app支付
	public static final String UPACP = "upacp";// 银联支付

	// 应用类型
	public static final String APP = "app";// APP
	public static final String H5 = "h5";// 手机H5
	public static final String WECHAT_PLATFORM = "wechat_platform";// 微信公众号
	public static final String MINI_PROGRAM = "mini _program";// 小程序

	// 支付状态
	public static final Integer PAY_READY = 0;// 待支付
	public static final Integer PAY_COMPLETED = 1;// 支付完成
	public static final Integer PAY_FAIL = -1;// 支付失败
	public static final Integer PAY_CANCEL = -3;// 支付取消
	public static final Integer PAY_TIME_OUT_CANCEL = -2;// 支付超时取消
	public static final Integer PAY_REFUNDING = 2;// 退款中
	public static final Integer PAY_REFUND_COMPLETED = 3;// 退款完成
	public static final Integer PAY_REFUND_FAIL = 4;// 退款失败

	// 支付请求回调方式
	public static final String SYNCHRONOUS = "synchronous";// 同步
	public static final String ASYNCHRONOUS = "asynchronous";// 异步

	// 操作类型
	public static final String REFUND = "refund";
	public static final String PAY = "pay";
	
	//支付渠道生效状态
	public static final Integer PAY_CHAN_EXPIRE = 0;
	public static final Integer PAY_CHAN_NORMAL = 1;
	
	/**
     * 订单状态
     0:待支付
     1:支付成功
     2:客户取消
     3:支付失败
     4:支付时间到期取消
     5:被退货
     */
	public static final int ORDER_STATUS_PAY_INIT = 0;
	public static final int ORDER_STATUS_PAY_SUCCESS = 1;
	public static final int ORDER_STATUS_CANCLE = 2;
	public static final int ORDER_STATUS_PAY_FAIL = 3;
	public static final int ORDER_STATUS_TIME_OVER_CANCLE = 4;
	public static final int ORDER_STATUS_SALES_RETURN = 5;

    /**
     * 订单超时时间
     */
	public static final  String SYS_PARAMETER_ORDER_TIME_OVER="order_time_over";
	public static final  String SYS_PARAMETER_PAYMENT_TIME_OVER="payment_time_over";


    /**
     * 1:分钟  2:小时  3:天  4:月  5:年              SYS_BASE_TYPE表中3005
     */
	public static  final   int  DATE_TYPE_MINUTE=1;
	public static  final   int  DATE_TYPE_HOUR=2;
	public static  final   int  DATE_TYPE_DAY=3;
	public static  final   int  DATE_TYPE_MONTH=4;
	public static  final   int  DATE_TYPE_YEAR=5;
	
	/**
	 * 应用是否使用我们系统的订单
	 */
	public static final int APP_ORDER_USE = 0;//使用
	public static final int APP_ORDER_NOT_USE = 1;//不使用
	
	/**
	 * 支付结果 退款结果查询
	 */
	public static final String QUERY_TYPE_PAYRECORD="01";//支付接口查询（每笔支付记录）
	public static final String QUERY_TYPE_PAYORDER="02";//支付接口查询（订单号加支付渠道）
    public static final String QUERY_TYPE_REFUND="03";//退款结果查询
    
    /**
	 * 资金流水状态
	 */
	public static final int TRADESTATUS_FAIL=-1;//失败
    public static final int TRADESTATUS_APPLY=0;//申请中
    public static final int TRADESTATUS_SUCCESS=1;//成功
    
    /**
	 * 分账状态
	 */
	public static final int SPLIT_ACCT_STATUS_NO=0;//没有分账
    public static final int SPLIT_ACCT_STATUS_PRODUCT=1;//依据产品分账
    public static final int SPLIT_ACCT_STATUS_CHAN=2;//依据渠道分账
}
