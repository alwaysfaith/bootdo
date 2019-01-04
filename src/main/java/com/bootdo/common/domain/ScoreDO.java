package com.bootdo.common.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-01-04 14:59:46
 */
public class ScoreDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//比赛ID
	private Long betId;
	//比赛周次
	private String betWeek;
	//比赛赛事(英超)
	private String betLeague;
	//比赛日期
	private Date betTime;
	//开始时间
	private Date startTime;
	//主队排名
	private Integer hostRank;
	//主队
	private String hostTeam;
	//客队排名
	private Integer guestRank;
	//客队
	private String guestTeam;
	//比分
	private String betScore;
	//主队红牌
	private Integer hostRedCard;
	//客队红牌
	private Integer guestRedCard;
	//主队黄牌
	private Integer hostYellowCard;
	//客队黄牌
	private Integer guestYellowCard;
	//半场比分
	private String betScoreHalf;
	//平手盘
	private Integer drawBall;
	//平手盘主队
	private String drawWinOdds;
	//平手盘平手
	private String drawDrowOdds;
	//平手盘客队
	private String drawLoseOdds;
	//让球盘
	private Integer letBall;
	//让球盘主队
	private String letWinOdds;
	//让球盘平手
	private String letDrowOdds;
	//让球盘客队
	private String letLoseOdds;
	//平手盘打出3主队赢1平手0客队赢
	private String drawActive;
	//让球盘打出3主队赢1平手0客队赢
	private String letActive;
	//数据ID
	private Long dataId;

	/**
	 * 设置：比赛ID
	 */
	public void setBetId(Long betId) {
		this.betId = betId;
	}
	/**
	 * 获取：比赛ID
	 */
	public Long getBetId() {
		return betId;
	}
	/**
	 * 设置：比赛周次
	 */
	public void setBetWeek(String betWeek) {
		this.betWeek = betWeek;
	}
	/**
	 * 获取：比赛周次
	 */
	public String getBetWeek() {
		return betWeek;
	}
	/**
	 * 设置：比赛赛事(英超)
	 */
	public void setBetLeague(String betLeague) {
		this.betLeague = betLeague;
	}
	/**
	 * 获取：比赛赛事(英超)
	 */
	public String getBetLeague() {
		return betLeague;
	}
	/**
	 * 设置：比赛日期
	 */
	public void setBetTime(Date betTime) {
		this.betTime = betTime;
	}
	/**
	 * 获取：比赛日期
	 */
	public Date getBetTime() {
		return betTime;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置：主队排名
	 */
	public void setHostRank(Integer hostRank) {
		this.hostRank = hostRank;
	}
	/**
	 * 获取：主队排名
	 */
	public Integer getHostRank() {
		return hostRank;
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
	 * 设置：客队排名
	 */
	public void setGuestRank(Integer guestRank) {
		this.guestRank = guestRank;
	}
	/**
	 * 获取：客队排名
	 */
	public Integer getGuestRank() {
		return guestRank;
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
	 * 设置：比分
	 */
	public void setBetScore(String betScore) {
		this.betScore = betScore;
	}
	/**
	 * 获取：比分
	 */
	public String getBetScore() {
		return betScore;
	}
	/**
	 * 设置：主队红牌
	 */
	public void setHostRedCard(Integer hostRedCard) {
		this.hostRedCard = hostRedCard;
	}
	/**
	 * 获取：主队红牌
	 */
	public Integer getHostRedCard() {
		return hostRedCard;
	}
	/**
	 * 设置：客队红牌
	 */
	public void setGuestRedCard(Integer guestRedCard) {
		this.guestRedCard = guestRedCard;
	}
	/**
	 * 获取：客队红牌
	 */
	public Integer getGuestRedCard() {
		return guestRedCard;
	}
	/**
	 * 设置：主队黄牌
	 */
	public void setHostYellowCard(Integer hostYellowCard) {
		this.hostYellowCard = hostYellowCard;
	}
	/**
	 * 获取：主队黄牌
	 */
	public Integer getHostYellowCard() {
		return hostYellowCard;
	}
	/**
	 * 设置：客队黄牌
	 */
	public void setGuestYellowCard(Integer guestYellowCard) {
		this.guestYellowCard = guestYellowCard;
	}
	/**
	 * 获取：客队黄牌
	 */
	public Integer getGuestYellowCard() {
		return guestYellowCard;
	}
	/**
	 * 设置：半场比分
	 */
	public void setBetScoreHalf(String betScoreHalf) {
		this.betScoreHalf = betScoreHalf;
	}
	/**
	 * 获取：半场比分
	 */
	public String getBetScoreHalf() {
		return betScoreHalf;
	}
	/**
	 * 设置：平手盘
	 */
	public void setDrawBall(Integer drawBall) {
		this.drawBall = drawBall;
	}
	/**
	 * 获取：平手盘
	 */
	public Integer getDrawBall() {
		return drawBall;
	}
	/**
	 * 设置：平手盘主队
	 */
	public void setDrawWinOdds(String drawWinOdds) {
		this.drawWinOdds = drawWinOdds;
	}
	/**
	 * 获取：平手盘主队
	 */
	public String getDrawWinOdds() {
		return drawWinOdds;
	}
	/**
	 * 设置：平手盘平手
	 */
	public void setDrawDrowOdds(String drawDrowOdds) {
		this.drawDrowOdds = drawDrowOdds;
	}
	/**
	 * 获取：平手盘平手
	 */
	public String getDrawDrowOdds() {
		return drawDrowOdds;
	}
	/**
	 * 设置：平手盘客队
	 */
	public void setDrawLoseOdds(String drawLoseOdds) {
		this.drawLoseOdds = drawLoseOdds;
	}
	/**
	 * 获取：平手盘客队
	 */
	public String getDrawLoseOdds() {
		return drawLoseOdds;
	}
	/**
	 * 设置：让球盘
	 */
	public void setLetBall(Integer letBall) {
		this.letBall = letBall;
	}
	/**
	 * 获取：让球盘
	 */
	public Integer getLetBall() {
		return letBall;
	}
	/**
	 * 设置：让球盘主队
	 */
	public void setLetWinOdds(String letWinOdds) {
		this.letWinOdds = letWinOdds;
	}
	/**
	 * 获取：让球盘主队
	 */
	public String getLetWinOdds() {
		return letWinOdds;
	}
	/**
	 * 设置：让球盘平手
	 */
	public void setLetDrowOdds(String letDrowOdds) {
		this.letDrowOdds = letDrowOdds;
	}
	/**
	 * 获取：让球盘平手
	 */
	public String getLetDrowOdds() {
		return letDrowOdds;
	}
	/**
	 * 设置：让球盘客队
	 */
	public void setLetLoseOdds(String letLoseOdds) {
		this.letLoseOdds = letLoseOdds;
	}
	/**
	 * 获取：让球盘客队
	 */
	public String getLetLoseOdds() {
		return letLoseOdds;
	}
	/**
	 * 设置：平手盘打出3主队赢1平手0客队赢
	 */
	public void setDrawActive(String drawActive) {
		this.drawActive = drawActive;
	}
	/**
	 * 获取：平手盘打出3主队赢1平手0客队赢
	 */
	public String getDrawActive() {
		return drawActive;
	}
	/**
	 * 设置：让球盘打出3主队赢1平手0客队赢
	 */
	public void setLetActive(String letActive) {
		this.letActive = letActive;
	}
	/**
	 * 获取：让球盘打出3主队赢1平手0客队赢
	 */
	public String getLetActive() {
		return letActive;
	}
	/**
	 * 设置：数据ID
	 */
	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}
	/**
	 * 获取：数据ID
	 */
	public Long getDataId() {
		return dataId;
	}
}
