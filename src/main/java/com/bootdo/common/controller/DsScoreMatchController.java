package com.bootdo.common.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.domain.DsScoreMatchDO;
import com.bootdo.common.service.DsScoreMatchService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author Caixin
 * @email 1992lcg@163.com
 * @date 2019-08-08 13:51:06
 */
 
@Controller
@RequestMapping("/common/dsScoreMatch")
public class DsScoreMatchController {
	@Autowired
	private DsScoreMatchService dsScoreMatchService;
	
	@GetMapping()
	@RequiresPermissions("common:dsScoreMatch:dsScoreMatch")
	String DsScoreMatch(){
	    return "common/dsScoreMatch/dsScoreMatch";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:dsScoreMatch:dsScoreMatch")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<DsScoreMatchDO> dsScoreMatchList = dsScoreMatchService.list(query);
		int total = dsScoreMatchService.count(query);
		PageUtils pageUtils = new PageUtils(dsScoreMatchList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("common:dsScoreMatch:add")
	String add(){
	    return "common/dsScoreMatch/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("common:dsScoreMatch:edit")
	String edit(@PathVariable("id") Long id,Model model){
		DsScoreMatchDO dsScoreMatch = dsScoreMatchService.get(id);
		model.addAttribute("dsScoreMatch", dsScoreMatch);
	    return "common/dsScoreMatch/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:dsScoreMatch:add")
	public R save( DsScoreMatchDO dsScoreMatch){
		if(dsScoreMatchService.save(dsScoreMatch)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("common:dsScoreMatch:edit")
	public R update( DsScoreMatchDO dsScoreMatch){
		dsScoreMatchService.update(dsScoreMatch);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("common:dsScoreMatch:remove")
	public R remove( Long id){
		if(dsScoreMatchService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:dsScoreMatch:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		dsScoreMatchService.batchRemove(ids);
		return R.ok();
	}
	
}
