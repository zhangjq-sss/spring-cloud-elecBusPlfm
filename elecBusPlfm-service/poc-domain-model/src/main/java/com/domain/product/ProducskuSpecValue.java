package com.domain.product;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * sku规格值
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 11:07:31
 */
@Table(name = "t_product_sku_spec_value")
public class ProducskuSpecValue implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Long id;
	
	    //sku_id
    @Column(name = "spu_id")
    private Long spuId;
	
	    //规格值id
    @Column(name = "spec_value_id")
    private Long specValueId;
	
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
	 * 设置：sku_id
	 */
	public void setSpuId(Long spuId) {
		this.spuId = spuId;
	}
	/**
	 * 获取：sku_id
	 */
	public Long getSpuId() {
		return spuId;
	}
	/**
	 * 设置：规格值id
	 */
	public void setSpecValueId(Long specValueId) {
		this.specValueId = specValueId;
	}
	/**
	 * 获取：规格值id
	 */
	public Long getSpecValueId() {
		return specValueId;
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
