package com.bootdo.common.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author Caixin
 * @email 1992lcg@163.com
 * @date 2019-08-08 13:51:06
 */
public class DsScoreMatchDO implements Serializable {
	private static final long serialVersionUID = 1L;

	public DsScoreMatchDO(String match, String matchBg, String selection, String startTime, String hostTeam, String hostRank, String hostRed, String hostYellow, String overScore, String guestTeam, String guestRank, String guestRed, String guestYellow, String halfScore, String letBall, String sizeBall, String cornerBall, String halfCorner, String overCorner, Date matchTime) {
		this.match = match;
		this.matchBg = matchBg;
		this.selection = selection;
		this.startTime = startTime;
		this.hostTeam = hostTeam;
		this.hostRank = hostRank;
		this.hostRed = hostRed;
		this.hostYellow = hostYellow;
		this.overScore = overScore;
		this.guestTeam = guestTeam;
		this.guestRank = guestRank;
		this.guestRed = guestRed;
		this.guestYellow = guestYellow;
		this.halfScore = halfScore;
		this.letBall = letBall;
		this.sizeBall = sizeBall;
		this.cornerBall = cornerBall;
		this.halfCorner = halfCorner;
		this.overCorner = overCorner;
		this.matchTime = matchTime;
	}

	//主键
	private Long id;
	//赛事
	private String match;
	//赛事背景
	private String matchBg;
	//精选
	private String selection;
	//开赛时间
	private String startTime;
	//主队
	private String hostTeam;
	//主队排名
	private String hostRank;
	//主队红牌
	private String hostRed;
	//主队黄牌
	private String hostYellow;
	//全场比分
	private String overScore;
	//客队
	private String guestTeam;
	//客队排名
	private String guestRank;
	//客队红牌
	private String guestRed;
	//客队黄牌
	private String guestYellow;
	//半场比分
	private String halfScore;
	//初让球
	private String letBall;
	//初大小球
	private String sizeBall;
	//初角球
	private String cornerBall;
	//半场角球比分
	private String halfCorner;
	//全场角球比分
	private String overCorner;
	//赛事日期时间
	private Date matchTime;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;

	/**
	 * 设置：主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：赛事
	 */
	public void setMatch(String match) {
		this.match = match;
	}
	/**
	 * 获取：赛事
	 */
	public String getMatch() {
		return match;
	}
	/**
	 * 设置：赛事背景
	 */
	public void setMatchBg(String matchBg) {
		this.matchBg = matchBg;
	}
	/**
	 * 获取：赛事背景
	 */
	public String getMatchBg() {
		return matchBg;
	}
	/**
	 * 设置：精选
	 */
	public void setSelection(String selection) {
		this.selection = selection;
	}
	/**
	 * 获取：精选
	 */
	public String getSelection() {
		return selection;
	}
	/**
	 * 设置：开赛时间
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开赛时间
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * 设置：主队
	 */
	public void setHostTeam(String hostTeam) {
		this.hostTeam = hostTeam;
	}
	/**
	 * 获取：主队
	 */
	public String getHostTeam() {
		return hostTeam;
	}
	/**
	 * 设置：主队排名
	 */
	public void setHostRank(String hostRank) {
		this.hostRank = hostRank;
	}
	/**
	 * 获取：主队排名
	 */
	public String getHostRank() {
		return hostRank;
	}
	/**
	 * 设置：主队红牌
	 */
	public void setHostRed(String hostRed) {
		this.hostRed = hostRed;
	}
	/**
	 * 获取：主队红牌
	 */
	public String getHostRed() {
		return hostRed;
	}
	/**
	 * 设置：主队黄牌
	 */
	public void setHostYellow(String hostYellow) {
		this.hostYellow = hostYellow;
	}
	/**
	 * 获取：主队黄牌
	 */
	public String getHostYellow() {
		return hostYellow;
	}
	/**
	 * 设置：全场比分
	 */
	public void setOverScore(String overScore) {
		this.overScore = overScore;
	}
	/**
	 * 获取：全场比分
	 */
	public String getOverScore() {
		return overScore;
	}
	/**
	 * 设置：客队
	 */
	public void setGuestTeam(String guestTeam) {
		this.guestTeam = guestTeam;
	}
	/**
	 * 获取：客队
	 */
	public String getGuestTeam() {
		return guestTeam;
	}
	/**
	 * 设置：客队排名
	 */
	public void setGuestRank(String guestRank) {
		this.guestRank = guestRank;
	}
	/**
	 * 获取：客队排名
	 */
	public String getGuestRank() {
		return guestRank;
	}
	/**
	 * 设置：客队红牌
	 */
	public void setGuestRed(String guestRed) {
		this.guestRed = guestRed;
	}
	/**
	 * 获取：客队红牌
	 */
	public String getGuestRed() {
		return guestRed;
	}
	/**
	 * 设置：客队黄牌
	 */
	public void setGuestYellow(String guestYellow) {
		this.guestYellow = guestYellow;
	}
	/**
	 * 获取：客队黄牌
	 */
	public String getGuestYellow() {
		return guestYellow;
	}
	/**
	 * 设置：半场比分
	 */
	public void setHalfScore(String halfScore) {
		this.halfScore = halfScore;
	}
	/**
	 * 获取：半场比分
	 */
	public String getHalfScore() {
		return halfScore;
	}
	/**
	 * 设置：初让球
	 */
	public void setLetBall(String letBall) {
		this.letBall = letBall;
	}
	/**
	 * 获取：初让球
	 */
	public String getLetBall() {
		return letBall;
	}
	/**
	 * 设置：初大小球
	 */
	public void setSizeBall(String sizeBall) {
		this.sizeBall = sizeBall;
	}
	/**
	 * 获取：初大小球
	 */
	public String getSizeBall() {
		return sizeBall;
	}
	/**
	 * 设置：初角球
	 */
	public void setCornerBall(String cornerBall) {
		this.cornerBall = cornerBall;
	}
	/**
	 * 获取：初角球
	 */
	public String getCornerBall() {
		return cornerBall;
	}
	/**
	 * 设置：半场角球比分
	 */
	public void setHalfCorner(String halfCorner) {
		this.halfCorner = halfCorner;
	}
	/**
	 * 获取：半场角球比分
	 */
	public String getHalfCorner() {
		return halfCorner;
	}
	/**
	 * 设置：全场角球比分
	 */
	public void setOverCorner(String overCorner) {
		this.overCorner = overCorner;
	}
	/**
	 * 获取：全场角球比分
	 */
	public String getOverCorner() {
		return overCorner;
	}
	/**
	 * 设置：赛事日期时间
	 */
	public void setMatchTime(Date matchTime) {
		this.matchTime = matchTime;
	}
	/**
	 * 获取：赛事日期时间
	 */
	public Date getMatchTime() {
		return matchTime;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
