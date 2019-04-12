package com.domain.constant;

/**
 * @author fazhan.ding
 * @Description
 * @date 2018/6/4 9:38
 */
public class ErrorUtil {


    /**
     * 网络不可用
     */
    public static  final  String  POC_ERROR_NETWORK ="0001";


    /**
     * 参数错误
     */
    public static final String  POC_ERROR_PARAMETER_ERROR="0002";


    /**
     * unkown
     */
    public static final String  POC_ERROR_SYSTEM_ERROR="9999";
    
    /**
     * 修改失败
     */
    public static final String  POC_ERROR_UPDATE_FAILED ="2000";
    /**
     * 删除失败
     */
    public static final String  POC_ERROR_DELETE_FAILED ="2001";
    /**
     * 添加失败
     */
    public static final String  POC_ERROR_SAVE_FAILED ="2002";
    /**
     * 关联其他表，不能删除
     */
    public static final String  POC_ERROR_CONFLICT_FAILED ="2003";
    
    /**
     * 支付错误
     */
    public static final String  PAY_ERROR ="3001";


    /**
     * 商品部分信息已失效,请刷新后重试
     */
    public static final String POC_ERROR_PRODUCT_CHECK_MESSAGE_ERROR="4000";
    /**
     *商品库存不足,无法购买
     */
    public static final String POC_ERROR_PRODUCT_CHECK_INVENTORY_ERROR="4001";

    /**
     * 查询失败，没有找到对应的记录
     */
    public static final String POC_ERROR_SELECT_FAILED="2005";




    /**
     * 6000 帐号或密码错误,
     * 6001 帐号已被锁定,
     * 6002 帐号已失效,
     * 6003 帐号不存在
     * 6005 抱歉,系统用户名已存在
     * 6006 抱歉,角色名称已存在
     *
     *6007  权限不足
     *6008  登录超时失效
     */
    public static final String  POC_ERROR_USER_UNACCOUNT="6000";
    public static final String  POC_ERROR_USER_ACCOUNT_LOCKED="6001";
    public static final String  POC_ERROR_USER_ACCOUNT_STATUS_FALSE="6002";

    public static final String  POC_ERROR_USER_NOACCOUNT="6003";

    public static final String  POC_ERROR_USER_ACCOUNT_UNIQUE="6005";
    public static final String  POC_ERROR_ROLE_ACCOUNT_UNIQUE="6006";
    public static final String  POC_ERROR_PERMISSION="6007";
    public static final String  POC_ERROR_USER_OVERTIME="6008";



    /**
     *请勿重复提交数据
     */
    public static final String POC_SUBMIT_REPETITION="9998";

    /**
     *抱歉订单已经存在未审核的退款申请,无法再次发起申请
     */
    public static final String POC_ORDER_PROCESS_CHECK_INIT="2006";


    /**
     *抱歉订单状态错误，操作失败
     */
    public static final String POC_ORDER_STATUS_ERROR="2007";
}
