package com.domain.order;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 订单评论表
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 13:36:27
 */
@Table(name = "t_order_product_comment")
public class OrderProductComment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //
    @Column(name = "spu_id")
    private Integer spuId;
	
	    //
    @Column(name = "sku_id")
    private Integer skuId;
	
	    //
    @Column(name = "cust_id")
    private Integer custId;
	
	    //昵称
    @Column(name = "cust_nickname")
    private String custNickname;
	
	    //评论内容
    @Column(name = "comment_content")
    private String commentContent;
	
	    //0-5 评论分数
    @Column(name = "comment_score")
    private Integer commentScore;
	
	    //评论的商品信息，如规格型号之类的
    @Column(name = "product_info_json")
    private String productInfoJson;
	
	    //图片地址
    @Column(name = "image_json")
    private String imageJson;
	
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
	public void setSpuId(Integer spuId) {
		this.spuId = spuId;
	}
	/**
	 * 获取：
	 */
	public Integer getSpuId() {
		return spuId;
	}
	/**
	 * 设置：
	 */
	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}
	/**
	 * 获取：
	 */
	public Integer getSkuId() {
		return skuId;
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
	 * 设置：昵称
	 */
	public void setCustNickname(String custNickname) {
		this.custNickname = custNickname;
	}
	/**
	 * 获取：昵称
	 */
	public String getCustNickname() {
		return custNickname;
	}
	/**
	 * 设置：评论内容
	 */
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	/**
	 * 获取：评论内容
	 */
	public String getCommentContent() {
		return commentContent;
	}
	/**
	 * 设置：0-5 评论分数
	 */
	public void setCommentScore(Integer commentScore) {
		this.commentScore = commentScore;
	}
	/**
	 * 获取：0-5 评论分数
	 */
	public Integer getCommentScore() {
		return commentScore;
	}
	/**
	 * 设置：评论的商品信息，如规格型号之类的
	 */
	public void setProductInfoJson(String productInfoJson) {
		this.productInfoJson = productInfoJson;
	}
	/**
	 * 获取：评论的商品信息，如规格型号之类的
	 */
	public String getProductInfoJson() {
		return productInfoJson;
	}
	/**
	 * 设置：图片地址
	 */
	public void setImageJson(String imageJson) {
		this.imageJson = imageJson;
	}
	/**
	 * 获取：图片地址
	 */
	public String getImageJson() {
		return imageJson;
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
