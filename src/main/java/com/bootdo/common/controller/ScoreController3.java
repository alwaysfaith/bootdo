//package com.bootdo.common.controller;
//
//import java.util.List;
//import java.util.Map;
//
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.bootdo.common.domain.ScoreDO;
//import com.bootdo.common.service.ScoreService;
//import com.bootdo.common.utils.PageUtils;
//import com.bootdo.common.utils.Query;
//import com.bootdo.common.utils.R;
//
///**
// *
// *
// * @author chglee
// * @email 1992lcg@163.com
// * @date 2019-01-04 14:49:01
// */
//
//@Controller
//@RequestMapping("/common/score")
//public class ScoreController3 {
//	@Autowired
//	private ScoreService scoreService;
//
//	@GetMapping()
//	@RequiresPermissions("common:score:score")
//	String Score(){
//	    return "common/score/score";
//	}
//
//	@ResponseBody
//	@GetMapping("/list")
//	@RequiresPermissions("common:score:score")
//	public PageUtils list(@RequestParam Map<String, Object> params){
//		//查询列表数据
//        Query query = new Query(params);
//		List<ScoreDO> scoreList = scoreService.list(query);
//		int total = scoreService.count(query);
//		PageUtils pageUtils = new PageUtils(scoreList, total);
//		return pageUtils;
//	}
//
//	@GetMapping("/add")
//	@RequiresPermissions("common:score:add")
//	String add(){
//	    return "common/score/add";
//	}
//
//	@GetMapping("/edit/{betId}")
//	@RequiresPermissions("common:score:edit")
//	String edit(@PathVariable("betId") Long betId,Model model){
//		ScoreDO score = scoreService.get(betId);
//		model.addAttribute("score", score);
//	    return "common/score/edit";
//	}
//
//	/**
//	 * 保存
//	 */
//	@ResponseBody
//	@PostMapping("/save")
//	@RequiresPermissions("common:score:add")
//	public R save( ScoreDO score){
//		if(scoreService.save(score)>0){
//			return R.ok();
//		}
//		return R.error();
//	}
//	/**
//	 * 修改
//	 */
//	@ResponseBody
//	@RequestMapping("/update")
//	@RequiresPermissions("common:score:edit")
//	public R update( ScoreDO score){
//		scoreService.update(score);
//		return R.ok();
//	}
//
//	/**
//	 * 删除
//	 */
//	@PostMapping( "/remove")
//	@ResponseBody
//	@RequiresPermissions("common:score:remove")
//	public R remove( Long betId){
//		if(scoreService.remove(betId)>0){
//		return R.ok();
//		}
//		return R.error();
//	}
//
//	/**
//	 * 删除
//	 */
//	@PostMapping( "/batchRemove")
//	@ResponseBody
//	@RequiresPermissions("common:score:batchRemove")
//	public R remove(@RequestParam("ids[]") Long[] betIds){
//		scoreService.batchRemove(betIds);
//		return R.ok();
//	}
//
//}
