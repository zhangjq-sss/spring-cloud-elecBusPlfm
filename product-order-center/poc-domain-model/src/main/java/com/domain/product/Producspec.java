package com.domain.product;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 规格表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 11:07:31
 */
@Table(name = "t_product_spec")
public class Producspec implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Long id;
	
	    //规格编号
    @Column(name = "spec_no")
    private String specNo;
	
	    //规格名称
    @Column(name = "spec_name")
    private String specName;
	
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
	 * 设置：规格编号
	 */
	public void setSpecNo(String specNo) {
		this.specNo = specNo;
	}
	/**
	 * 获取：规格编号
	 */
	public String getSpecNo() {
		return specNo;
	}
	/**
	 * 设置：规格名称
	 */
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	/**
	 * 获取：规格名称
	 */
	public String getSpecName() {
		return specName;
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
