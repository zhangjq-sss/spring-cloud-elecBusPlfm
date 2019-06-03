package com.domain.product;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 分类表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 11:07:31
 */
@Table(name = "t_product_category")
public class Produccategory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Long id;
	
	    //
    @Column(name = "category_code")
    private String categoryCode;
	
	    //分类名称
    @Column(name = "category_name")
    private String categoryName;
	
	    //分类名称-英文
    @Column(name = "category_name_en")
    private String categoryNameEn;
	
	    //种类描述
    @Column(name = "category_desc")
    private String categoryDesc;
	
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
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	/**
	 * 获取：
	 */
	public String getCategoryCode() {
		return categoryCode;
	}
	/**
	 * 设置：分类名称
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * 获取：分类名称
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * 设置：分类名称-英文
	 */
	public void setCategoryNameEn(String categoryNameEn) {
		this.categoryNameEn = categoryNameEn;
	}
	/**
	 * 获取：分类名称-英文
	 */
	public String getCategoryNameEn() {
		return categoryNameEn;
	}
	/**
	 * 设置：种类描述
	 */
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	/**
	 * 获取：种类描述
	 */
	public String getCategoryDesc() {
		return categoryDesc;
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
