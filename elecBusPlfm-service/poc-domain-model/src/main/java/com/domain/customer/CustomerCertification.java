package com.domain.customer;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 客户认证表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 11:29:51
 */
@Table(name = "t_customer_certification")
public class CustomerCertification implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //真实姓名
    @Column(name = "real_name")
    private String realName;
	
	    //0 男 1女 2不确定
    @Column(name = "sex")
    private Integer sex;
	
	    //
    @Column(name = "nation")
    private String nation;
	
	    //
    @Column(name = "birth_date")
    private Date birthDate;
	
	    //
    @Column(name = "home_address")
    private String homeAddress;
	
	    //身份证
    @Column(name = "id_card")
    private String idCard;
	
	    //身份证签证机关
    @Column(name = "id_card_sign_office")
    private String idCardSignOffice;
	
	    //身份证有效开始时间
    @Column(name = "id_card_valid_time")
    private Date idCardValidTime;
	
	    //身份证有效结束时间
    @Column(name = "id_card_expire_time")
    private Date idCardExpireTime;
	
	    //人脸对比分数
    @Column(name = "face_scope")
    private Integer faceScope;
	
	    //人脸图像
    @Column(name = "face_image_url")
    private String faceImageUrl;
	
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
	 * 设置：真实姓名
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * 获取：真实姓名
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * 设置：0 男 1女 2不确定
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：0 男 1女 2不确定
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}
	/**
	 * 获取：
	 */
	public String getNation() {
		return nation;
	}
	/**
	 * 设置：
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * 获取：
	 */
	public Date getBirthDate() {
		return birthDate;
	}
	/**
	 * 设置：
	 */
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	/**
	 * 获取：
	 */
	public String getHomeAddress() {
		return homeAddress;
	}
	/**
	 * 设置：身份证
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	/**
	 * 获取：身份证
	 */
	public String getIdCard() {
		return idCard;
	}
	/**
	 * 设置：身份证签证机关
	 */
	public void setIdCardSignOffice(String idCardSignOffice) {
		this.idCardSignOffice = idCardSignOffice;
	}
	/**
	 * 获取：身份证签证机关
	 */
	public String getIdCardSignOffice() {
		return idCardSignOffice;
	}
	/**
	 * 设置：身份证有效开始时间
	 */
	public void setIdCardValidTime(Date idCardValidTime) {
		this.idCardValidTime = idCardValidTime;
	}
	/**
	 * 获取：身份证有效开始时间
	 */
	public Date getIdCardValidTime() {
		return idCardValidTime;
	}
	/**
	 * 设置：身份证有效结束时间
	 */
	public void setIdCardExpireTime(Date idCardExpireTime) {
		this.idCardExpireTime = idCardExpireTime;
	}
	/**
	 * 获取：身份证有效结束时间
	 */
	public Date getIdCardExpireTime() {
		return idCardExpireTime;
	}
	/**
	 * 设置：人脸对比分数
	 */
	public void setFaceScope(Integer faceScope) {
		this.faceScope = faceScope;
	}
	/**
	 * 获取：人脸对比分数
	 */
	public Integer getFaceScope() {
		return faceScope;
	}
	/**
	 * 设置：人脸图像
	 */
	public void setFaceImageUrl(String faceImageUrl) {
		this.faceImageUrl = faceImageUrl;
	}
	/**
	 * 获取：人脸图像
	 */
	public String getFaceImageUrl() {
		return faceImageUrl;
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
