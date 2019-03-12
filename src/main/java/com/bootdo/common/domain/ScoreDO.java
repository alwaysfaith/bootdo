package com.bootdo.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author Caixin
 * @email 1992lcg@163.com
 * @date 2019-03-12 16:37:10
 */
public class ScoreDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//比赛ID
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long betId;
	//比赛周次
	private String betWeek;
	//比赛赛事
	private String betLeague;
	//比赛赛事样式
	private String betLeagueStyle;
	//比赛日期
	private String betTime;
	//开始时间
	private String startTime;
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
	private Integer drawPoint;
	//平手盘主队
	private String drawWinOdds;
	//平手盘平手
	private String drawDrowOdds;
	//平手盘客队
	private String drawLoseOdds;
	//让球盘
	private Integer letPoint;
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
	//竞彩sp：1：首赔2：次赔3：末赔
	private Integer betSp;
	//竞彩sp（让球）：1：首赔2：次赔3：末赔
	private Integer betSpLet;
	//竞彩sp（让球）样式
	private String betSpLetStyle;
	//竞彩sp样式
	private String betSpStyle;
	//数据源
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long ssId;
	//第几期
	private String ssStage;

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
	 * 设置：比赛赛事
	 */
	public void setBetLeague(String betLeague) {
		this.betLeague = betLeague;
	}
	/**
	 * 获取：比赛赛事
	 */
	public String getBetLeague() {
		return betLeague;
	}
	/**
	 * 设置：比赛赛事样式
	 */
	public void setBetLeagueStyle(String betLeagueStyle) {
		this.betLeagueStyle = betLeagueStyle;
	}
	/**
	 * 获取：比赛赛事样式
	 */
	public String getBetLeagueStyle() {
		return betLeagueStyle;
	}
	/**
	 * 设置：比赛日期
	 */
	public void setBetTime(String betTime) {
		this.betTime = betTime;
	}
	/**
	 * 获取：比赛日期
	 */
	public String getBetTime() {
		return betTime;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开始时间
	 */
	public String getStartTime() {
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
	public void setDrawPoint(Integer drawPoint) {
		this.drawPoint = drawPoint;
	}
	/**
	 * 获取：平手盘
	 */
	public Integer getDrawPoint() {
		return drawPoint;
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
	public void setLetPoint(Integer letPoint) {
		this.letPoint = letPoint;
	}
	/**
	 * 获取：让球盘
	 */
	public Integer getLetPoint() {
		return letPoint;
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
	 * 设置：竞彩sp：1：首赔2：次赔3：末赔
	 */
	public void setBetSp(Integer betSp) {
		this.betSp = betSp;
	}
	/**
	 * 获取：竞彩sp：1：首赔2：次赔3：末赔
	 */
	public Integer getBetSp() {
		return betSp;
	}
	/**
	 * 设置：竞彩sp（让球）：1：首赔2：次赔3：末赔
	 */
	public void setBetSpLet(Integer betSpLet) {
		this.betSpLet = betSpLet;
	}
	/**
	 * 获取：竞彩sp（让球）：1：首赔2：次赔3：末赔
	 */
	public Integer getBetSpLet() {
		return betSpLet;
	}
	/**
	 * 设置：竞彩sp（让球）样式
	 */
	public void setBetSpLetStyle(String betSpLetStyle) {
		this.betSpLetStyle = betSpLetStyle;
	}
	/**
	 * 获取：竞彩sp（让球）样式
	 */
	public String getBetSpLetStyle() {
		return betSpLetStyle;
	}
	/**
	 * 设置：竞彩sp样式
	 */
	public void setBetSpStyle(String betSpStyle) {
		this.betSpStyle = betSpStyle;
	}
	/**
	 * 获取：竞彩sp样式
	 */
	public String getBetSpStyle() {
		return betSpStyle;
	}
	/**
	 * 设置：数据源
	 */
	public void setSsId(Long ssId) {
		this.ssId = ssId;
	}
	/**
	 * 获取：数据源
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
}
