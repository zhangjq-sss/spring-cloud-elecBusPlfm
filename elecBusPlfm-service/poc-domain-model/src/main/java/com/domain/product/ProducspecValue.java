package com.domain.product;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 规格值表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 11:07:31
 */
@Table(name = "t_product_spec_value")
public class ProducspecValue implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Long id;
	
	    //规格id
    @Column(name = "spec_id")
    private Long specId;
	
	    //规格值
    @Column(name = "spec_value")
    private String specValue;
	
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
	 * 设置：规格id
	 */
	public void setSpecId(Long specId) {
		this.specId = specId;
	}
	/**
	 * 获取：规格id
	 */
	public Long getSpecId() {
		return specId;
	}
	/**
	 * 设置：规格值
	 */
	public void setSpecValue(String specValue) {
		this.specValue = specValue;
	}
	/**
	 * 获取：规格值
	 */
	public String getSpecValue() {
		return specValue;
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
