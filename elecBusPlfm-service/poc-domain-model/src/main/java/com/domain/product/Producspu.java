package com.domain.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;


/**
 * 商品spu表-大类
 * 
 * @author jq
 * @email 18271632480@163.com
 * @date 2019-04-18 11:07:31
 */
@Table(name = "t_product_spu")
public class Producspu implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Long id;
	
	    //商品编号，唯一
    @Column(name = "spu_no")
    private String spuNo;
	
	    //商品名称
    @Column(name = "goods_name")
    private String goodsName;
	
	    //最低售价
    @Column(name = "low_price")
    private BigDecimal lowPrice;
	
	    //分类id
    @Column(name = "category_id")
    private Long categoryId;
	
	    //品牌id
    @Column(name = "brand_id")
    private Long brandId;
	
	    //商品大类描述
    @Column(name = "spu_desc")
    private String spuDesc;
	
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
	 * 设置：商品编号，唯一
	 */
	public void setSpuNo(String spuNo) {
		this.spuNo = spuNo;
	}
	/**
	 * 获取：商品编号，唯一
	 */
	public String getSpuNo() {
		return spuNo;
	}
	/**
	 * 设置：商品名称
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	/**
	 * 获取：商品名称
	 */
	public String getGoodsName() {
		return goodsName;
	}
	/**
	 * 设置：最低售价
	 */
	public void setLowPrice(BigDecimal lowPrice) {
		this.lowPrice = lowPrice;
	}
	/**
	 * 获取：最低售价
	 */
	public BigDecimal getLowPrice() {
		return lowPrice;
	}
	/**
	 * 设置：分类id
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * 获取：分类id
	 */
	public Long getCategoryId() {
		return categoryId;
	}
	/**
	 * 设置：品牌id
	 */
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	/**
	 * 获取：品牌id
	 */
	public Long getBrandId() {
		return brandId;
	}
	/**
	 * 设置：商品大类描述
	 */
	public void setSpuDesc(String spuDesc) {
		this.spuDesc = spuDesc;
	}
	/**
	 * 获取：商品大类描述
	 */
	public String getSpuDesc() {
		return spuDesc;
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
