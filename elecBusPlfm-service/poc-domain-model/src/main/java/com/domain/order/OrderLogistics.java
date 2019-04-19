package com.domain.order;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 快递表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 13:36:27
 */
@Table(name = "t_order_logistics")
public class OrderLogistics implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //
    @Column(name = "order_no")
    private Integer orderNo;
	
	    //
    @Column(name = "logistics_id")
    private Integer logisticsId;
	
	    //
    @Column(name = "logistics_no")
    private Integer logisticsNo;
	
	    //快递单号
    @Column(name = "mail_no")
    private String mailNo;
	
	    //
    @Column(name = "send_time")
    private Date sendTime;
	
	    //
    @Column(name = "receive_time")
    private Date receiveTime;
	
	    //
    @Column(name = "ctr_time")
    private Date ctrTime;
	
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
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：
	 */
	public Integer getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：
	 */
	public void setLogisticsId(Integer logisticsId) {
		this.logisticsId = logisticsId;
	}
	/**
	 * 获取：
	 */
	public Integer getLogisticsId() {
		return logisticsId;
	}
	/**
	 * 设置：
	 */
	public void setLogisticsNo(Integer logisticsNo) {
		this.logisticsNo = logisticsNo;
	}
	/**
	 * 获取：
	 */
	public Integer getLogisticsNo() {
		return logisticsNo;
	}
	/**
	 * 设置：快递单号
	 */
	public void setMailNo(String mailNo) {
		this.mailNo = mailNo;
	}
	/**
	 * 获取：快递单号
	 */
	public String getMailNo() {
		return mailNo;
	}
	/**
	 * 设置：
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	/**
	 * 获取：
	 */
	public Date getSendTime() {
		return sendTime;
	}
	/**
	 * 设置：
	 */
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	/**
	 * 获取：
	 */
	public Date getReceiveTime() {
		return receiveTime;
	}
	/**
	 * 设置：
	 */
	public void setCtrTime(Date ctrTime) {
		this.ctrTime = ctrTime;
	}
	/**
	 * 获取：
	 */
	public Date getCtrTime() {
		return ctrTime;
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
