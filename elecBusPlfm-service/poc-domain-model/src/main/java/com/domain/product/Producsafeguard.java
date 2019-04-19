package com.domain.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;


/**
 * 增值保障
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 11:07:31
 */
@Table(name = "t_product_safeguard")
public class Producsafeguard implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Long id;
	
	    //保障名称
    @Column(name = "safeguard_name")
    private String safeguardName;
	
	    //保障价格
    @Column(name = "price")
    private BigDecimal price;
	
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
	 * 设置：保障名称
	 */
	public void setSafeguardName(String safeguardName) {
		this.safeguardName = safeguardName;
	}
	/**
	 * 获取：保障名称
	 */
	public String getSafeguardName() {
		return safeguardName;
	}
	/**
	 * 设置：保障价格
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：保障价格
	 */
	public BigDecimal getPrice() {
		return price;
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
