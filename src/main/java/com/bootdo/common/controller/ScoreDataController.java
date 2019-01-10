package com.bootdo.common.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.common.domain.ScoreDO;
import com.bootdo.common.generator.IdWorkerInstance;
import com.bootdo.common.service.ScoreService;
import com.bootdo.common.utils.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.domain.ScoreDataDO;
import com.bootdo.common.service.ScoreDataService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-01-04 14:49:08
 */
 
@Controller
@RequestMapping("/common/scoreData")
public class ScoreDataController {
	@Autowired
	private ScoreDataService scoreDataService;

	@Autowired
	ScoreService scoreService;
	
	@GetMapping()
	@RequiresPermissions("common:scoreData:scoreData")
	String ScoreData(){
	    return "common/scoreData/scoreData";
	}

	@PostMapping("/resolve")
	@ResponseBody
	@RequiresPermissions("common:scoreData:scoreData")
	public R resolveScoreData(@RequestParam Map<String, Object> params){
		ScoreDataDO scoreDataDO = scoreDataService.list(params).get(0);
		String dataTable = scoreDataDO.getDataTable();
		Document doc = Jsoup.parse(dataTable);
		Elements table = doc != null ? doc.select("tbody:eq(2)") : null;
		// 使用选择器选择该table内所有的<tr> <tr/>
		Elements trs = table != null ? table.select("tr") : null;
		List<ScoreDO> scoreDOS = new ArrayList<>();
		//遍历该表格内的所有的<tr> <tr/>
		if (trs != null) {
			for (Element tr : trs) {
				ScoreDO scoreDO = new ScoreDO();
				scoreDO.setBetId(IdWorkerInstance.getId());
				// 获取一个tr
				// 获取该行的所有td节点
				Elements tds = tr.select("td");
				// 选择某一个td节点
				for (Element ignore : tds) {
					// 获取td节点的所有div
					//获取比赛周次
					String betWeek = tds.get(1).text();
					scoreDO.setBetWeek(betWeek);
					//比赛赛事(英超)
					String betLeague = tds.get(2).text();
					scoreDO.setBetLeague(betLeague);
					Elements spans3 = tds.get(3).select("span");
					for (Element ignored : spans3) {
						String betTime = spans3.get(0).text();
						String startTime = spans3.get(1).text();
						//matchTime
						scoreDO.setBetTime(betTime);
						//startTime
						scoreDO.setStartTime(startTime);
					}
					//主队信息hostTeam
					Elements spans4 = tds.get(4).select("span");
					for (Element ignoring : spans4) {
						Elements ss = spans4.get(0).select("s");
						for (Element ignored : ss) {
							//主队红牌
							boolean hasAttr = ss.get(0).hasAttr("style");
							if (hasAttr) {
								scoreDO.setHostRedCard(0);
							} else {
								String hostRedCard = ss.get(0).text();
								scoreDO.setHostRedCard(Integer.valueOf(hostRedCard.trim()));
							}
							boolean hasAttr2 = ss.get(1).hasAttr("style");
							if (hasAttr2) {
								scoreDO.setHostYellowCard(0);
							} else {
								//主队黄牌
								String hostYellowCard = ss.get(1).text();
								scoreDO.setHostYellowCard(Integer.valueOf(hostYellowCard.trim()));
							}
						}
						//主队排名
						String hostRank = spans4.get(1).text();
						String replaceAll = hostRank.trim().replace("[", "");
						String replace = replaceAll.replace("]", "");
						scoreDO.setHostRank(Integer.valueOf(replace.trim()));
						//主队名车
						String hostTeam = spans4.get(2).text();
						scoreDO.setHostTeam(hostTeam);
						//完场比分
						String betScore = spans4.get(3).text();
						scoreDO.setBetScore(betScore);
						Elements select = spans4.get(4).select("s");
						for (Element ignored : select) {
							//客队红牌
							boolean style = select.get(0).hasAttr("style");
							if (style) {
								scoreDO.setGuestRedCard(0);
							} else {
								String guestRedCard = select.get(0).text();
								scoreDO.setGuestRedCard(Integer.valueOf(guestRedCard.trim()));
							}
							boolean style2 = select.get(1).hasAttr("style");
							if (style2) {
								scoreDO.setGuestYellowCard(0);
							} else {
								//客队黄牌
								String guestYellowCard = select.get(1).text();
								scoreDO.setGuestYellowCard(Integer.valueOf(guestYellowCard.trim()));
							}
						}
						//客队排名
						String guestRank = spans4.get(6).text();
						String replaceAll2 = guestRank.trim().replace("[", "");
						String replace2 = replaceAll2.replace("]", "");
						scoreDO.setGuestRank(Integer.valueOf(replace2.trim()));
						//客队名车
						String guestTeam = spans4.get(5).text();
						scoreDO.setGuestTeam(guestTeam);
					}
					//半场比分
					String betHalf = tds.get(6).select("span").get(0).text();
					scoreDO.setBetScoreHalf(betHalf);
					Elements elements = tds.get(7).select("div").select("p");
					for (Element ignored : elements) {
						//平手
						String drawBall = elements.get(0).text();
						scoreDO.setDrawBall(Integer.valueOf(drawBall.trim()));
						//让q
						String letBall = elements.get(1).text();
						scoreDO.setLetBall(Integer.valueOf(letBall.trim()));
					}
					Elements ps = tds.get(8).select("div").select("p");
					for (Element ignored : ps) {
						Elements is = ps.get(0).select("i");
						for (Element ignor : is) {
							//平主队
							String drawWinOdds = is.get(0).text();
							scoreDO.setDrawWinOdds(drawWinOdds);
							//平平
							String drawDrowOdds = is.get(1).text();
							scoreDO.setDrawDrowOdds(drawDrowOdds);
							//平客
							String drawLoseOdds = is.get(2).text();
							scoreDO.setDrawLoseOdds(drawLoseOdds);

							//设置打出属性
							if(is.get(0).hasAttr("style")){
								scoreDO.setDrawActive(String.valueOf(3));
							}else if(is.get(1).hasAttr("style")){
								scoreDO.setDrawActive(String.valueOf(1));
							}else if(is.get(2).hasAttr("style")){
								scoreDO.setDrawActive(String.valueOf(0));
							}
						}
						Elements i2s = ps.get(1).select("i");
						for (Element ignor : i2s) {
							//让主
							String letWinOdds = i2s.get(0).text();
							scoreDO.setLetWinOdds(letWinOdds);
							//让平
							String letDrowOdds = i2s.get(1).text();
							scoreDO.setLetDrowOdds(letDrowOdds);
							//让客
							String letLoseOdds = i2s.get(2).text();
							scoreDO.setLetLoseOdds(letLoseOdds);

							//设置打出属性
							if(i2s.get(0).hasAttr("style")){
								scoreDO.setLetActive(String.valueOf(3));
							}else if(i2s.get(1).hasAttr("style")){
								scoreDO.setLetActive(String.valueOf(1));
							}else if(i2s.get(2).hasAttr("style")){
								scoreDO.setLetActive(String.valueOf(0));
							}
						}
					}
				}
				scoreDO.setDataId(scoreDataDO.getDataId());
				scoreDOS.add(scoreDO);
			}
		}
		if (scoreService.batchSave(scoreDOS) > 0) {
			ScoreDataDO dataDO = new ScoreDataDO();
			dataDO.setDataId(scoreDataDO.getDataId());
			dataDO.setDataStatus(1);
			scoreDataService.update(dataDO);
			return R.ok();
		}
		return R.error();
	}

	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:scoreData:scoreData")
	public PageUtils list(@RequestParam Map<String, Object> params){
		params.put("offset", 0);
		params.put("limit", 100);
		//查询列表数据
        Query query = new Query(params);
		List<ScoreDataDO> scoreDataList = scoreDataService.list(query);
		int total = scoreDataService.count(query);
		return new PageUtils(scoreDataList, total);
	}
	
	@GetMapping("/add")
	@RequiresPermissions("common:scoreData:add")
	String add(){
	    return "common/scoreData/add";
	}

	@GetMapping("/edit/{dataId}")
	@RequiresPermissions("common:scoreData:edit")
	String edit(@PathVariable("dataId") Long dataId,Model model){
		ScoreDataDO scoreData = scoreDataService.get(dataId);
		model.addAttribute("scoreData", scoreData);
	    return "common/scoreData/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:scoreData:add")
	public R save( ScoreDataDO scoreData){
		if(StringUtils.isBlank(scoreData.getDataTable())){
			return R.error("请导入数据！");
		}
		scoreData.setDataId(IdWorkerInstance.getId());
		String dataTable = scoreData.getDataTable();
		Document doc = Jsoup.parse(dataTable);
		Elements thead = doc != null ? doc.select("tbody:eq(1)") : null;
		Elements tr = thead != null ? thead.select("tr:eq(0)") : null;
		Elements td = tr != null ? tr.select("td:eq(0)") : null;
		if(thead==null || tr==null || td==null || td.text()==null){
			return R.error("导入数据错误！");
		}
		scoreData.setDataTime(td.text());
		scoreData.setDataStatus(0);
		if(scoreDataService.save(scoreData)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("common:scoreData:edit")
	public R update( ScoreDataDO scoreData){
		scoreDataService.update(scoreData);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("common:scoreData:remove")
	public R remove( Long dataId){
		if(scoreDataService.remove(dataId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:scoreData:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] dataIds){
		scoreDataService.batchRemove(dataIds);
		return R.ok();
	}
	
}
