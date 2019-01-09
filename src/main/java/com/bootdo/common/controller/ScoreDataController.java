package com.bootdo.common.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.common.generator.IdWorkerInstance;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
	
	@GetMapping()
	@RequiresPermissions("common:scoreData:scoreData")
	String ScoreData(){
	    return "common/scoreData/scoreData";
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
		PageUtils pageUtils = new PageUtils(scoreDataList, total);
		return pageUtils;
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
		scoreData.setDataId(IdWorkerInstance.getId());
		String dataTable = scoreData.getDataTable();
		Document doc = Jsoup.parse(dataTable);
		Elements thead = doc != null ? doc.select("tbody:eq(1)") : null;
		Elements tr = thead != null ? thead.select("tr:eq(0)") : null;
		Elements td = tr != null ? tr.select("td:eq(0)") : null;
		scoreData.setDataTime(td != null ? td.text() : null);
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
