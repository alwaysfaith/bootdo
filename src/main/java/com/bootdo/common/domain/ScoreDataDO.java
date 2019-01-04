package com.bootdo.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-01-04 14:49:08
 */
public class ScoreDataDO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//数据主键
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long dataId;
	//数据时间
	private String dataTime;
	//数据html
	private String dataTable;

	/**
	 * 设置：数据主键
	 */
	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}
	/**
	 * 获取：数据主键
	 */
	public Long getDataId() {
		return dataId;
	}
	/**
	 * 设置：数据时间
	 */
	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}
	/**
	 * 获取：数据时间
	 */
	public String getDataTime() {
		return dataTime;
	}
	/**
	 * 设置：数据html
	 */
	public void setDataTable(String dataTable) {
		this.dataTable = dataTable;
	}
	/**
	 * 获取：数据html
	 */
	public String getDataTable() {
		return dataTable;
	}
}
