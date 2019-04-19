package com.domain.promotion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;


/**
 * 优惠券表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 14:31:09
 */
@Table(name = "t_promotion_coupon")
public class PromotionCoupon implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //优惠券名称
    @Column(name = "coupon_name")
    private String couponName;
	
	    //优惠券类型和使用范围对应 1商品券 2平台券    
    @Column(name = "coupon_type")
    private Integer couponType;
	
	    //优惠券数量
    @Column(name = "coupon_count")
    private Integer couponCount;
	
	    //优惠方式-1满减 2折扣
    @Column(name = "discount_method")
    private Integer discountMethod;
	
	    //优惠券金额
    @Column(name = "coupon_amount")
    private BigDecimal couponAmount;
	
	    //发放形式：1用户手动领取 2系统固定发放（会员） 3优惠码领取（根据数量和生效状态先生成优惠码）4活动券（类似分享完成任务）
    @Column(name = "send_method")
    private Integer sendMethod;
	
	    //满减折扣开始需要金额
    @Column(name = "discount_begin_amount")
    private BigDecimal discountBeginAmount;
	
	    //满减折扣结束需要金额
    @Column(name = "discount_end_amount")
    private BigDecimal discountEndAmount;
	
	    //适用范围  0适合全品类 1店铺 2产品sku 3产品spu 4店铺类别 5产品类别 6产品品牌
    @Column(name = "apply_scope_type")
    private Integer applyScopeType;
	
	    //使用失效时间
    @Column(name = "apply_expire_time")
    private Date applyExpireTime;
	
	    //使用生效时间
    @Column(name = "apply_valid_time")
    private Date applyValidTime;
	
	    //发放失效时间
    @Column(name = "send_expire_time")
    private Date sendExpireTime;
	
	    //发放生效时间
    @Column(name = "send_valid_time")
    private Date sendValidTime;
	
	    //单个用户领取次数限制
    @Column(name = "single_cust_count")
    private Integer singleCustCount;
	
	    //时效类型 1时间段 2n天内有效
    @Column(name = "apply_time_type")
    private Integer applyTimeType;
	
	    //领取多少天内有效
    @Column(name = "apply_days")
    private Integer applyDays;
	
	    //叠加类型 0不可叠加 1可叠加
    @Column(name = "add_tyoe")
    private Boolean addTyoe;
	
	    //对于新老用户 0都可以领 1新用户（未购买任何产品）2老用户
    @Column(name = "for_old_new")
    private Integer forOldNew;
	
	    //状态 1可用(生效之后不可更改) 2不可用
    @Column(name = "status")
    private Integer status;
	
	    //备注描述
    @Column(name = "remark")
    private String remark;
	
	    //
    @Column(name = "crt_time")
    private Date crtTime;
	
	    //
    @Column(name = "upd_time")
    private Date updTime;
	
	    //版本号
    @Column(name = "version")
    private Integer version;
	

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：优惠券名称
	 */
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	/**
	 * 获取：优惠券名称
	 */
	public String getCouponName() {
		return couponName;
	}
	/**
	 * 设置：优惠券类型和使用范围对应 1商品券 2平台券    
	 */
	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}
	/**
	 * 获取：优惠券类型和使用范围对应 1商品券 2平台券    
	 */
	public Integer getCouponType() {
		return couponType;
	}
	/**
	 * 设置：优惠券数量
	 */
	public void setCouponCount(Integer couponCount) {
		this.couponCount = couponCount;
	}
	/**
	 * 获取：优惠券数量
	 */
	public Integer getCouponCount() {
		return couponCount;
	}
	/**
	 * 设置：优惠方式-1满减 2折扣
	 */
	public void setDiscountMethod(Integer discountMethod) {
		this.discountMethod = discountMethod;
	}
	/**
	 * 获取：优惠方式-1满减 2折扣
	 */
	public Integer getDiscountMethod() {
		return discountMethod;
	}
	/**
	 * 设置：优惠券金额
	 */
	public void setCouponAmount(BigDecimal couponAmount) {
		this.couponAmount = couponAmount;
	}
	/**
	 * 获取：优惠券金额
	 */
	public BigDecimal getCouponAmount() {
		return couponAmount;
	}
	/**
	 * 设置：发放形式：1用户手动领取 2系统固定发放（会员） 3优惠码领取（根据数量和生效状态先生成优惠码）4活动券（类似分享完成任务）
	 */
	public void setSendMethod(Integer sendMethod) {
		this.sendMethod = sendMethod;
	}
	/**
	 * 获取：发放形式：1用户手动领取 2系统固定发放（会员） 3优惠码领取（根据数量和生效状态先生成优惠码）4活动券（类似分享完成任务）
	 */
	public Integer getSendMethod() {
		return sendMethod;
	}
	/**
	 * 设置：满减折扣开始需要金额
	 */
	public void setDiscountBeginAmount(BigDecimal discountBeginAmount) {
		this.discountBeginAmount = discountBeginAmount;
	}
	/**
	 * 获取：满减折扣开始需要金额
	 */
	public BigDecimal getDiscountBeginAmount() {
		return discountBeginAmount;
	}
	/**
	 * 设置：满减折扣结束需要金额
	 */
	public void setDiscountEndAmount(BigDecimal discountEndAmount) {
		this.discountEndAmount = discountEndAmount;
	}
	/**
	 * 获取：满减折扣结束需要金额
	 */
	public BigDecimal getDiscountEndAmount() {
		return discountEndAmount;
	}
	/**
	 * 设置：适用范围  0适合全品类 1店铺 2产品sku 3产品spu 4店铺类别 5产品类别 6产品品牌
	 */
	public void setApplyScopeType(Integer applyScopeType) {
		this.applyScopeType = applyScopeType;
	}
	/**
	 * 获取：适用范围  0适合全品类 1店铺 2产品sku 3产品spu 4店铺类别 5产品类别 6产品品牌
	 */
	public Integer getApplyScopeType() {
		return applyScopeType;
	}
	/**
	 * 设置：使用失效时间
	 */
	public void setApplyExpireTime(Date applyExpireTime) {
		this.applyExpireTime = applyExpireTime;
	}
	/**
	 * 获取：使用失效时间
	 */
	public Date getApplyExpireTime() {
		return applyExpireTime;
	}
	/**
	 * 设置：使用生效时间
	 */
	public void setApplyValidTime(Date applyValidTime) {
		this.applyValidTime = applyValidTime;
	}
	/**
	 * 获取：使用生效时间
	 */
	public Date getApplyValidTime() {
		return applyValidTime;
	}
	/**
	 * 设置：发放失效时间
	 */
	public void setSendExpireTime(Date sendExpireTime) {
		this.sendExpireTime = sendExpireTime;
	}
	/**
	 * 获取：发放失效时间
	 */
	public Date getSendExpireTime() {
		return sendExpireTime;
	}
	/**
	 * 设置：发放生效时间
	 */
	public void setSendValidTime(Date sendValidTime) {
		this.sendValidTime = sendValidTime;
	}
	/**
	 * 获取：发放生效时间
	 */
	public Date getSendValidTime() {
		return sendValidTime;
	}
	/**
	 * 设置：单个用户领取次数限制
	 */
	public void setSingleCustCount(Integer singleCustCount) {
		this.singleCustCount = singleCustCount;
	}
	/**
	 * 获取：单个用户领取次数限制
	 */
	public Integer getSingleCustCount() {
		return singleCustCount;
	}
	/**
	 * 设置：时效类型 1时间段 2n天内有效
	 */
	public void setApplyTimeType(Integer applyTimeType) {
		this.applyTimeType = applyTimeType;
	}
	/**
	 * 获取：时效类型 1时间段 2n天内有效
	 */
	public Integer getApplyTimeType() {
		return applyTimeType;
	}
	/**
	 * 设置：领取多少天内有效
	 */
	public void setApplyDays(Integer applyDays) {
		this.applyDays = applyDays;
	}
	/**
	 * 获取：领取多少天内有效
	 */
	public Integer getApplyDays() {
		return applyDays;
	}
	/**
	 * 设置：叠加类型 0不可叠加 1可叠加
	 */
	public void setAddTyoe(Boolean addTyoe) {
		this.addTyoe = addTyoe;
	}
	/**
	 * 获取：叠加类型 0不可叠加 1可叠加
	 */
	public Boolean getAddTyoe() {
		return addTyoe;
	}
	/**
	 * 设置：对于新老用户 0都可以领 1新用户（未购买任何产品）2老用户
	 */
	public void setForOldNew(Integer forOldNew) {
		this.forOldNew = forOldNew;
	}
	/**
	 * 获取：对于新老用户 0都可以领 1新用户（未购买任何产品）2老用户
	 */
	public Integer getForOldNew() {
		return forOldNew;
	}
	/**
	 * 设置：状态 1可用(生效之后不可更改) 2不可用
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 1可用(生效之后不可更改) 2不可用
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：备注描述
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注描述
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：
	 */
	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}
	/**
	 * 获取：
	 */
	public Date getCrtTime() {
		return crtTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdTime() {
		return updTime;
	}
	/**
	 * 设置：版本号
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * 获取：版本号
	 */
	public Integer getVersion() {
		return version;
	}
}
