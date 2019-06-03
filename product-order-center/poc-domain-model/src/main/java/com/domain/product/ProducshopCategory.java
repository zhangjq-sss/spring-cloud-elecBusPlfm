package com.domain.product;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 店铺种类表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 11:07:31
 */
@Table(name = "t_product_shop_category")
public class ProducshopCategory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Long id;
	
	    //店铺种类名称
    @Column(name = "category_name")
    private String categoryName;
	
	    //店铺种类编码
    @Column(name = "catefory_code")
    private String cateforyCode;
	
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
	 * 设置：店铺种类名称
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * 获取：店铺种类名称
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * 设置：店铺种类编码
	 */
	public void setCateforyCode(String cateforyCode) {
		this.cateforyCode = cateforyCode;
	}
	/**
	 * 获取：店铺种类编码
	 */
	public String getCateforyCode() {
		return cateforyCode;
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
