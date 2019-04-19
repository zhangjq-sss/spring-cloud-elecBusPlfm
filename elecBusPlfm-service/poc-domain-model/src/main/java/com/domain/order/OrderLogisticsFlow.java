package com.domain.order;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 快递跟踪表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 13:36:27
 */
@Table(name = "t_order_logistics_flow")
public class OrderLogisticsFlow implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //
    @Column(name = "order_no")
    private String orderNo;
	
	    //
    @Column(name = "logistics_no")
    private String logisticsNo;
	
	    //
    @Column(name = "mail_no")
    private Integer mailNo;
	
	    //当前地址
    @Column(name = "cur_address")
    private String curAddress;
	
	    //
    @Column(name = "crt_time")
    private Date crtTime;
	
	    //
    @Column(name = "upd_time")
    private Date updTime;
	

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
	 * 设置：
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：
	 */
	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}
	/**
	 * 获取：
	 */
	public String getLogisticsNo() {
		return logisticsNo;
	}
	/**
	 * 设置：
	 */
	public void setMailNo(Integer mailNo) {
		this.mailNo = mailNo;
	}
	/**
	 * 获取：
	 */
	public Integer getMailNo() {
		return mailNo;
	}
	/**
	 * 设置：当前地址
	 */
	public void setCurAddress(String curAddress) {
		this.curAddress = curAddress;
	}
	/**
	 * 获取：当前地址
	 */
	public String getCurAddress() {
		return curAddress;
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
