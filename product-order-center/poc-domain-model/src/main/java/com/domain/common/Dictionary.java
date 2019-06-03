package com.domain.common;

import java.io.Serializable;

/**
 * @ClassName: Dictionary
 * @Description: 字段类型
 *
 */

public class Dictionary implements Serializable {

	/**
	 * @Fields serialVersionUID
	 */

	private static final long serialVersionUID = 5192206733447828194L;

	/** 主键id */
	private Long id;
	/** 类型 */
	private String type;
	/** code编号 */
	private String code;
	/** 名称 */
	private String name;
	/** 排序 */
	private Integer sort;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
