package com.domain.product;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 品牌表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 11:07:31
 */
@Table(name = "t_product_brand")
public class Producbrand implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Long id;
	
	    //
    @Column(name = "brand_code")
    private String brandCode;
	
	    //品牌名称
    @Column(name = "brand_name")
    private String brandName;
	
	    //品牌名称-英文
    @Column(name = "brand_name_en")
    private String brandNameEn;
	
	    //品牌描述
    @Column(name = "brand_desc")
    private String brandDesc;
	
	    //
    @Column(name = "crt_time")
    private Date crtTime;
	
	    //
    @Column(name = "upd_time")
    private Date updTime;
	

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	/**
	 * 获取：
	 */
	public String getBrandCode() {
		return brandCode;
	}
	/**
	 * 设置：品牌名称
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	/**
	 * 获取：品牌名称
	 */
	public String getBrandName() {
		return brandName;
	}
	/**
	 * 设置：品牌名称-英文
	 */
	public void setBrandNameEn(String brandNameEn) {
		this.brandNameEn = brandNameEn;
	}
	/**
	 * 获取：品牌名称-英文
	 */
	public String getBrandNameEn() {
		return brandNameEn;
	}
	/**
	 * 设置：品牌描述
	 */
	public void setBrandDesc(String brandDesc) {
		this.brandDesc = brandDesc;
	}
	/**
	 * 获取：品牌描述
	 */
	public String getBrandDesc() {
		return brandDesc;
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
}
