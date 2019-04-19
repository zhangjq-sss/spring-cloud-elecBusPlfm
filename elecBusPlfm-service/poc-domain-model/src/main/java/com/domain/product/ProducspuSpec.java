package com.domain.product;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * spu规格表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 11:07:31
 */
@Table(name = "t_product_spu_spec")
public class ProducspuSpec implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Long id;
	
	    //spu_id
    @Column(name = "spu_id")
    private Long spuId;
	
	    //spec_id
    @Column(name = "spec_id")
    private Long specId;
	
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
	 * 设置：spu_id
	 */
	public void setSpuId(Long spuId) {
		this.spuId = spuId;
	}
	/**
	 * 获取：spu_id
	 */
	public Long getSpuId() {
		return spuId;
	}
	/**
	 * 设置：spec_id
	 */
	public void setSpecId(Long specId) {
		this.specId = specId;
	}
	/**
	 * 获取：spec_id
	 */
	public Long getSpecId() {
		return specId;
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
