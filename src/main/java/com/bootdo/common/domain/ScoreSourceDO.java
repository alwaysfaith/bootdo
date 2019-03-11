package com.bootdo.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-11 15:13:03
 */
public class ScoreSourceDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//数据主键
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long ssId;
	//第几期
	private String ssStage;
	//时间
	private String ssTime;
	//数据源
	private String ssTable;
	//是否解析
	private Integer ssStatus;

	/**
	 * 设置：数据主键
	 */
	public void setSsId(Long ssId) {
		this.ssId = ssId;
	}
	/**
	 * 获取：数据主键
	 */
	public Long getSsId() {
		return ssId;
	}
	/**
	 * 设置：第几期
	 */
	public void setSsStage(String ssStage) {
		this.ssStage = ssStage;
	}
	/**
	 * 获取：第几期
	 */
	public String getSsStage() {
		return ssStage;
	}
	/**
	 * 设置：时间
	 */
	public void setSsTime(String ssTime) {
		this.ssTime = ssTime;
	}
	/**
	 * 获取：时间
	 */
	public String getSsTime() {
		return ssTime;
	}
	/**
	 * 设置：数据源
	 */
	public void setSsTable(String ssTable) {
		this.ssTable = ssTable;
	}
	/**
	 * 获取：数据源
	 */
	public String getSsTable() {
		return ssTable;
	}
	/**
	 * 设置：是否解析
	 */
	public void setSsStatus(Integer ssStatus) {
		this.ssStatus = ssStatus;
	}
	/**
	 * 获取：是否解析
	 */
	public Integer getSsStatus() {
		return ssStatus;
	}
}
