package com.bootdo.common.controller;

import com.bootdo.common.domain.ScoreDO;
import com.bootdo.common.domain.ScoreSourceDO;
import com.bootdo.common.generator.IdWorkerInstance;
import com.bootdo.common.service.ScoreService;
import com.bootdo.common.service.ScoreSourceService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-01-04 14:49:08
 */

@Controller
@RequestMapping("/common/scoreData")
public class ScoreDataController {

    @Autowired
    private ScoreSourceService scoreDataService;

    @Autowired
    ScoreService scoreService;

    @GetMapping()
    @RequiresPermissions("common:scoreData:scoreData")
    public String scoreData() {
        return "common/scoreData/scoreData";
    }

    @PostMapping("/resolve")
    @ResponseBody
    @RequiresPermissions("common:scoreData:scoreData")
    public R resolveScoreData(@RequestParam Map<String, Object> params) {
        ScoreSourceDO scoreDataDO = scoreDataService.list(params).get(0);
        String dataTable = scoreDataDO.getSsTable();
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
                    //比赛赛事样式
                    String style1 = tds.get(2).attr("style");
                    scoreDO.setBetLeagueStyle(style1);

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
                                if (StringUtils.isNotBlank(hostRedCard)) {
                                    scoreDO.setHostRedCard(Integer.valueOf(hostRedCard.trim()));
                                } else {
                                    scoreDO.setHostRedCard(0);
                                }
                            }
                            boolean hasAttr2 = ss.get(1).hasAttr("style");
                            if (hasAttr2) {
                                scoreDO.setHostYellowCard(0);
                            } else {
                                //主队黄牌
                                String hostYellowCard = ss.get(1).text();
                                if (StringUtils.isNotBlank(hostYellowCard)) {
                                    scoreDO.setHostYellowCard(Integer.valueOf(hostYellowCard.trim()));
                                } else {
                                    scoreDO.setHostYellowCard(0);
                                }
                            }
                        }
                        //主队排名
                        String hostRank = spans4.get(1).text();
                        if (StringUtils.isBlank(hostRank)) {
                            scoreDO.setHostRank(0);
                        } else {
                            String replaceAll = hostRank.trim().replace("[", "");
                            String replace = replaceAll.replace("]", "");
                            scoreDO.setHostRank(Integer.valueOf(replace.trim()));
                        }
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
                                if (StringUtils.isNotBlank(guestRedCard)) {
                                    scoreDO.setGuestRedCard(Integer.valueOf(guestRedCard.trim()));
                                } else {
                                    scoreDO.setGuestRedCard(0);
                                }
                            }
                            boolean style2 = select.get(1).hasAttr("style");
                            if (style2) {
                                scoreDO.setGuestYellowCard(0);
                            } else {
                                //客队黄牌
                                String guestYellowCard = select.get(1).text();
                                if (StringUtils.isNotBlank(guestYellowCard)) {
                                    scoreDO.setGuestYellowCard(Integer.valueOf(guestYellowCard.trim()));
                                } else {
                                    scoreDO.setGuestYellowCard(0);
                                }
                            }
                        }
                        //客队排名
                        String guestRank = spans4.get(6).text();
                        if (StringUtils.isBlank(guestRank)) {
                            scoreDO.setGuestRank(0);
                        } else {
                            String replaceAll2 = guestRank.trim().replace("[", "");
                            String replace2 = replaceAll2.replace("]", "");
                            scoreDO.setGuestRank(Integer.valueOf(replace2.trim()));
                        }
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
                        scoreDO.setDrawPoint(Integer.valueOf(drawBall.trim()));
                        //让q
                        String letBall = elements.get(1).text();
                        scoreDO.setLetPoint(Integer.valueOf(letBall.trim()));
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
                            if (is.get(0).hasAttr("style")) {
                                String style = is.get(0).attr("style");
                                setBetSpPoint(scoreDO, style);
                                scoreDO.setDrawActive(String.valueOf(3));

                            } else if (is.get(1).hasAttr("style")) {
                                String style = is.get(1).attr("style");
                                setBetSpPoint(scoreDO, style);

                                scoreDO.setDrawActive(String.valueOf(1));
                            } else if (is.get(2).hasAttr("style")) {
                                String style = is.get(2).attr("style");
                                setBetSpPoint(scoreDO, style);
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
                            if (i2s.get(0).hasAttr("style")) {
                                String style = i2s.get(0).attr("style");
                                setBetSpLetPoint(scoreDO, style);
                                scoreDO.setLetActive(String.valueOf(3));
                            } else if (i2s.get(1).hasAttr("style")) {
                                String style = i2s.get(1).attr("style");
                                setBetSpLetPoint(scoreDO, style);
                                scoreDO.setLetActive(String.valueOf(1));
                            } else if (i2s.get(2).hasAttr("style")) {
                                String style = i2s.get(2).attr("style");
                                setBetSpLetPoint(scoreDO, style);
                                scoreDO.setLetActive(String.valueOf(0));
                            }
                        }
                    }
                }
                scoreDO.setSsId(scoreDataDO.getSsId());
                scoreDO.setSsStage(scoreDataDO.getSsStage());
                scoreDOS.add(scoreDO);
            }
        }
        if (CollectionUtils.isNotEmpty(scoreDOS) && scoreService.batchSave(scoreDOS) > 0) {
            ScoreSourceDO dataDO = new ScoreSourceDO();
            dataDO.setSsId(scoreDataDO.getSsId());
            dataDO.setSsStatus(1);
            scoreDataService.update(dataDO);
            return R.ok();
        }
        return R.error();
    }

    private void setBetSpLetPoint(ScoreDO scoreDO, String style) {
        if ("background-color: rgb(218, 175, 2); color: white;".equalsIgnoreCase(style.trim())) {
            scoreDO.setBetSpLet(1);
            scoreDO.setBetSpLetStyle(style.trim());
        } else if ("background-color: rgb(21, 110, 202); color: white;".equalsIgnoreCase(style.trim())) {
            scoreDO.setBetSpLet(3);
            scoreDO.setBetSpLetStyle(style.trim());
        } else if ("background-color: rgb(255, 69, 0); color: white;".equalsIgnoreCase(style.trim())) {
            scoreDO.setBetSpLet(0);
            scoreDO.setBetSpLetStyle(style.trim());
        }
    }

    private void setBetSpPoint(ScoreDO scoreDO, String style) {
        if ("background-color: rgb(218, 175, 2); color: white;".equalsIgnoreCase(style.trim())) {
            scoreDO.setBetSp(1);
            scoreDO.setBetSpStyle(style.trim());
        } else if ("background-color: rgb(21, 110, 202); color: white;".equalsIgnoreCase(style.trim())) {
            scoreDO.setBetSp(3);
            scoreDO.setBetSpStyle(style.trim());
        } else if ("background-color: rgb(255, 69, 0); color: white;".equalsIgnoreCase(style.trim())) {
            scoreDO.setBetSp(0);
            scoreDO.setBetSpStyle(style.trim());
        }
    }


    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("common:scoreData:scoreData")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        params.put("offset", 0);
        params.put("limit", 100);
        //查询列表数据
        Query query = new Query(params);
        List<ScoreSourceDO> scoreDataList = scoreDataService.list(query);
        int total = scoreDataService.count(query);
        return new PageUtils(scoreDataList, total);
    }

    @GetMapping("/add")
    @RequiresPermissions("common:scoreData:add")
    public String add() {
        return "common/scoreData/add";
    }

    @GetMapping("/edit/{dataId}")
    @RequiresPermissions("common:scoreData:edit")
    public String edit(@PathVariable("dataId") Long dataId, Model model) {
        ScoreSourceDO scoreData = scoreDataService.get(dataId);
        model.addAttribute("scoreData", scoreData);
        return "common/scoreData/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("common:scoreData:add")
    public R save(ScoreSourceDO scoreData) {
        if (StringUtils.isBlank(scoreData.getSsTable())) {
            return R.error("请导入数据！");
        }
        scoreData.setSsId(IdWorkerInstance.getId());
        String dataTable = scoreData.getSsTable();
        Document doc = Jsoup.parse(dataTable);
        Elements thead = doc != null ? doc.select("tbody:eq(1)") : null;
        Elements tr = thead != null ? thead.select("tr:eq(0)") : null;
        Elements td = tr != null ? tr.select("td:eq(0)") : null;
        if (thead == null || tr == null || td == null || td.text() == null) {
            return R.error("导入数据错误！");
        }
        scoreData.setSsTime(td.text());
        scoreData.setSsStatus(0);
        if (scoreDataService.save(scoreData) > 0) {
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
    public R update(ScoreSourceDO scoreData) {
        scoreDataService.update(scoreData);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("common:scoreData:remove")
    public R remove(Long ssId) {
        if (scoreDataService.remove(ssId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("common:scoreData:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] dataIds) {
        scoreDataService.batchRemove(dataIds);
        return R.ok();
    }

}
