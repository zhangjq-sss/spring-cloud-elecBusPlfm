package com.domain.customer;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 客户地址表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 11:29:51
 */
@Table(name = "t_customer_address")
public class CustomerAddress implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //
    @Column(name = "cust_id")
    private Integer custId;
	
	    //省
    @Column(name = "province")
    private String province;
	
	    //市
    @Column(name = "city")
    private String city;
	
	    //区
    @Column(name = "region")
    private String region;
	
	    //街道
    @Column(name = "street")
    private String street;
	
	    //邮政编码
    @Column(name = "post_code")
    private String postCode;
	
	    //联系人姓名
    @Column(name = "contact_name")
    private String contactName;
	
	    //联系人详细地址
    @Column(name = "detail_address")
    private String detailAddress;
	
	    //联系人电话
    @Column(name = "contact_mobile")
    private String contactMobile;
	
	    //0 不默认 1默认
    @Column(name = "default_ype")
    private Boolean defaultYpe;
	
	    //
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "crt_time")
    private Date crtTime;
	
	    //
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	/**
	 * 获取：
	 */
	public Integer getCustId() {
		return custId;
	}
	/**
	 * 设置：省
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：区
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * 获取：区
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * 设置：街道
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * 获取：街道
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * 设置：邮政编码
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	/**
	 * 获取：邮政编码
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * 设置：联系人姓名
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	/**
	 * 获取：联系人姓名
	 */
	public String getContactName() {
		return contactName;
	}
	/**
	 * 设置：联系人详细地址
	 */
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	/**
	 * 获取：联系人详细地址
	 */
	public String getDetailAddress() {
		return detailAddress;
	}
	/**
	 * 设置：联系人电话
	 */
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	/**
	 * 获取：联系人电话
	 */
	public String getContactMobile() {
		return contactMobile;
	}
	/**
	 * 设置：0 不默认 1默认
	 */
	public void setDefaultYpe(Boolean defaultYpe) {
		this.defaultYpe = defaultYpe;
	}
	/**
	 * 获取：0 不默认 1默认
	 */
	public Boolean getDefaultYpe() {
		return defaultYpe;
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
