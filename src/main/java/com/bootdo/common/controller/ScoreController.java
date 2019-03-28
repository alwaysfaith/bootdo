package com.bootdo.common.controller;

import com.bootdo.common.domain.ScoreDO;
import com.bootdo.common.generator.IdWorkerInstance;
import com.bootdo.common.service.ScoreService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Caixin
 * @email 1992lcg@163.com
 * @date 2018-12-29 10:12:07
 */

@Controller
@RequestMapping("/common/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    public static void main(String[] args) {
//        Document doc = null;
//        try {
//            doc = Jsoup.connect("https://live.aicai.com/").get();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // 根据id获取table
//        Date date = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String format = dateFormat.format(date);
//        System.out.println(format);
        String html = "<div class=\"tableDataWrap\">\n" +
                "        <table class=\"tableData\" id=\"jq_jsbf_body\">\n" +
                "            <thead>\n" +
                "            <tr>\n" +
                "                <td width=\"260\">\n" +
                "                    <span style=\"width: 38px;\"></span>\n" +
                "                    <span class=\"changci\">场次</span><span class=\"saishi\">赛事</span>\n" +
                "                    <span class=\"kaisai\">开赛</span><span class=\"zhuangtai\">状态</span>\n" +
                "                </td>\n" +
                "                <td width=\"534\"><span class=\"zhudui\">主队</span><span class=\"vs\">比分</span><span class=\"kedui\">客队</span></td>\n" +
                "                <td width=\"40\" class=\"tac\">半场</td>\n" +
                "                <td width=\"30\" class=\"tac\">让球</td>\n" +
                "                <td width=\"140\" class=\"tac\">\n" +
                "                    <div id=\"oddsCompanyDiv\" class=\"spSelect\">\n" +
                "                        <a href=\"javascript:;\" class=\"spSelectBtn\" onclick=\"showOrHideOddsCompanyList();\">\n" +
                "                            <span id=\"choosedOddsCompanyDesc\">竞彩sp值</span><span id=\"choosedOddsCompanyIndex\" style=\"display:none;\">6</span><em class=\"g-triangle\"></em>\n" +
                "                        </a>\n" +
                "                        <div class=\"slideUl\" style=\"top: 40px;\"><ul id=\"oddsCompanyUl\"><li class=\"active\" onclick=\"chooseOddsCompany($(this));\"><span class=\"oddsCompanyDesc\">竞彩sp值</span><span class=\"oddsCompanyIndex\" style=\"display:none;\">6</span><i class=\"selectIcon sprite\"></i></li><li onclick=\"chooseOddsCompany($(this));\"><span class=\"oddsCompanyDesc\">平均欧指</span><span class=\"oddsCompanyIndex\" style=\"display:none;\">7</span><i class=\"selectIcon sprite\"></i></li><li onclick=\"chooseOddsCompany($(this));\"><span class=\"oddsCompanyDesc\">bet365</span><span class=\"oddsCompanyIndex\" style=\"display:none;\">1</span><i class=\"selectIcon sprite\"></i></li><li onclick=\"chooseOddsCompany($(this));\"><span class=\"oddsCompanyDesc\">澳门</span><span class=\"oddsCompanyIndex\" style=\"display:none;\">2</span><i class=\"selectIcon sprite\"></i></li><li onclick=\"chooseOddsCompany($(this));\"><span class=\"oddsCompanyDesc\">威廉希尔</span><span class=\"oddsCompanyIndex\" style=\"display:none;\">3</span><i class=\"selectIcon sprite\"></i></li><li onclick=\"chooseOddsCompany($(this));\"><span class=\"oddsCompanyDesc\">皇冠</span><span class=\"oddsCompanyIndex\" style=\"display:none;\">0</span><i class=\"selectIcon sprite\"></i></li></ul></div>\n" +
                "                    </div>\n" +
                "                </td>\n" +
                "                <td width=\"190\" class=\"tar\"><span class=\"fenxi\">分析</span><span class=\"pr5\">置顶</span></td>\n" +
                "            </tr>\n" +
                "            </thead>\n" +
                "\n" +
                "            <tbody id=\"jq_match_bodyHead_2019-03-03_tbody\" class=\"jq_match_bodyHead\">\n" +
                "            <tr>\n" +
                "                <td colspan=\"6\" class=\"timeTitle\">2019-03-03 (11:00 -- 次日 11:00)</td>\n" +
                "            </tr>\n" +
                "            </tbody>\n" +
                "\n" +
                "            <tbody id=\"matchListTbody\" class=\"jq_match_bodyHead\">\n" +
                "\n" +
                "            <tr class=\"liveMacthLi\" id=\"jq_match_1583447_tr\" data-matchid=\"2744101\" data-qtmatchid=\"1583447\" data-index=\"26\" data-middle=\"false\" data-leagueid=\"26\" data-matchstatus=\"2\" data-matchstatuscategory=\"2\">\n" +
                "                <td class=\"pr no_border_left\">\n" +
                "                    <input type=\"checkbox\" checked=\"checked\" class=\"input\" onchange=\"showOrHideMatch($(this));\">\n" +
                "                    <span class=\"week\">周日026</span>\n" +
                "                    <span class=\"league\" style=\"background:#006633\">\n" +
                "\t\t\t\t\t\t<a target=\"_blank\" href=\"http://league.aicai.com/league/38/\">西甲</a>\n" +
                "\t\t\t\t</span>\n" +
                "                    <span class=\"time\"><p class=\"c999\">03-03</p><p>23:15</p></span>\n" +
                "                    <span id=\"jq_league_starttime_1583447\" style=\"display:none;\">00:00</span>\n" +
                "\n" +
                "                    <span id=\"jq_status_1583447\" class=\"state red\" data-matchstatus=\"2\">已完场</span>\n" +
                "                </td>\n" +
                "                <td>\n" +
                "                    <div class=\"teamLine left\">\n" +
                "                        <span class=\"card yellow jq_yellowcard\" style=\"display: none;\">2</span>\n" +
                "                        <span class=\"card red jq_redcard\" style=\"display:none\">0</span>\n" +
                "                        <span class=\"cbbb ml5 jq_rank\">[7]</span>\n" +
                "                        <span class=\"name\">\n" +
                "\t\t\t\t\t\t<a target=\"_blank\" href=\"http://league.aicai.com/team/123/\">贝蒂斯</a>\n" +
                "\t\t\t\t\t</span>\n" +
                "                    </div>\n" +
                "                    <div class=\"vs\" onmouseover=\"showAllOdds($(this));\" onmouseout=\"hideAllOdds($(this));\"><a target=\"_blank\" href=\"//yq.aicai.com/matchPlanDetail/1583447-1/room?showHeader=1&amp;tab=1\"><span class=\"red homeScore\">1</span><span class=\"ml5 mr5\">-</span><span class=\"red awayScore\">2</span></a></div>\n" +
                "                    <!--盘口tip-->\n" +
                "                    <div class=\"handicapTip\">\n" +
                "                        <i class=\"triangle01\"></i><i class=\"triangle02\"></i>\n" +
                "                        <table>\n" +
                "                            <thead>\n" +
                "                            <tr><td>贝蒂斯</td><td>赫塔费</td></tr>\n" +
                "                            <tr class=\"tr2\"><td style=\"border-right: 1px solid #eee;\">即时指数</td><td>初盘指数</td></tr>\n" +
                "                            </thead>\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td style=\"border-right: 1px solid #eee;\">\n" +
                "                                    <span class=\"span1\">亚盘</span>\n" +
                "                                    <span class=\"span2 asia_js_win\"></span><span class=\"span3 c999 asia_js_handicap\"></span><span class=\"span4 asia_js_lose\"></span>\n" +
                "                                </td>\n" +
                "                                <td><span class=\"span1 asia_first_win\"></span><span class=\"span3 c999 asia_first_handicap\"></span><span class=\"span4 asia_first_lose\"></span></td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td style=\"border-right: 1px solid #eee;\">\n" +
                "                                    <span class=\"span1\">欧赔</span>\n" +
                "                                    <span class=\"span2 ou_js_win\"></span><span class=\"span3 ou_js_draw\"></span><span class=\"span4 ou_js_lose\"></span>\n" +
                "                                </td>\n" +
                "                                <td><span class=\"span1 ou_first_win\"></span><span class=\"span3 ou_js_draw\"></span><span class=\"span4 ou_js_lose\"></span></td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td style=\"border-right: 1px solid #eee;\">\n" +
                "                                    <span class=\"span1\">大小</span>\n" +
                "                                    <span class=\"span2 bs_js_win\"></span><span class=\"span3 c999 bs_js_handicap\"></span><span class=\"span4 bs_js_lose\"></span>\n" +
                "                                </td>\n" +
                "                                <td><span class=\"span1 bs_first_win\"></span><span class=\"span3 c999  bs_first_handicap\"></span><span class=\"span4 bs_first_lose\"></span></td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </div>\n" +
                "                    <div class=\"teamLine right\">\n" +
                "\t\t\t\t\t<span class=\"name\">\n" +
                "\t\t\t\t\t\t<a target=\"_blank\" href=\"http://league.aicai.com/team/124/\">赫塔费</a>\n" +
                "\t\t\t\t\t</span>\n" +
                "                        <span class=\"cbbb mr5 jq_rank\">[5]</span>\n" +
                "                        <span class=\"card red jq_redcard\" style=\"display:none\">0</span>\n" +
                "                        <span class=\"card yellow jq_yellowcard\" style=\"display: none;\">2</span>\n" +
                "                    </div>\n" +
                "                    <div class=\"videoBxo\">\n" +
                "                        <a class=\"video sprite_live\" target=\"_blank\" href=\"//yq.aicai.com/matchPlanDetail/1583447-1/room?showHeader=1&amp;tab=1\"></a>\n" +
                "                        <a class=\"animate sprite_live\" target=\"_blank\" href=\"//yq.aicai.com/matchPlanDetail/1583447-1/room?showHeader=1&amp;tab=2\"></a>\n" +
                "                    </div>\n" +
                "                    <div class=\"recomExpert\">\n" +
                "                        <p><a target=\"_blank\" href=\"http://yq.aicai.com/matchPlanDetail/1583447-1/matchPlanRecommend?showHeader=1&amp;agentId=2335103\"><em class=\"red\">127</em>位专家推荐</a></p>\n" +
                "                    </div>\n" +
                "                </td>\n" +
                "                <td class=\"halfCourt\">\n" +
                "\t\t\t\t<span class=\"red\">\n" +
                "\t\t\t\t\t 0 :\n" +
                "\t\t\t\t\t 2\n" +
                "\t\t\t\t</span>\n" +
                "                </td>\n" +
                "                <td><div class=\"tdDiv letBallShow\"><p class=\"letBallShow_no\" style=\"border-bottom: 1px solid #eee;\">0</p><p class=\"letBallShow_let\">-1</p></div></td>\n" +
                "                <td class=\"txtddd\"><div class=\"tdDiv ouOddsShow\"><p class=\"ouOddsShow_no\" style=\"border-bottom: 1px solid #eee;\"><em>2.15</em><em>2.53</em><em><b class=\"odBg red\">3.35</b></em></p><p class=\"ouOddsShow_let h30\"><em>4.85</em><em>3.60</em><em><b class=\"odBg blue\">1.48</b></em></p></div></td>\n" +
                "                <td class=\"linkTd\">\n" +
                "                    <a target=\"_blank\" href=\"https://live.aicai.com/zc/xyo_1583447.html\">析</a>\n" +
                "                    <a target=\"_blank\" href=\"https://live.aicai.com/zc/xyo_1583447_yazhi.html\">亚</a>\n" +
                "                    <a target=\"_blank\" href=\"https://live.aicai.com/zc/xyo_1583447_ouzhi.html\">欧</a>\n" +
                "                    <a target=\"_blank\" href=\"https://live.aicai.com/zc/xyo_1583447_dxzhi.html\">大</a>\n" +
                "                    <a target=\"_blank\" href=\"http://yq.aicai.com/matchPlanDetail/1583447-1/matchPlanIntelligence?showHeader=1\" class=\"red\">情报</a>\n" +
                "                    <a href=\"javascript:;\" onclick=\"topOrCancelTop($(this));\" class=\"stick sprite_live\"></a>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr class=\"liveMacthLi otrBg\" id=\"jq_match_1552054_tr\" data-matchid=\"2695763\" data-qtmatchid=\"1552054\" data-index=\"27\" data-middle=\"false\" data-leagueid=\"16\" data-matchstatus=\"2\" data-matchstatuscategory=\"2\">\n" +
                "                <td class=\"pr no_border_left\">\n" +
                "                    <input type=\"checkbox\" checked=\"checked\" class=\"input\" onchange=\"showOrHideMatch($(this));\">\n" +
                "                    <span class=\"week\">周日027</span>\n" +
                "                    <span class=\"league\" style=\"background:#FF6699\">\n" +
                "\t\t\t\t\t\t<a target=\"_blank\" href=\"http://league.aicai.com/league/28/\">荷甲</a>\n" +
                "\t\t\t\t</span>\n" +
                "                    <span class=\"time\"><p class=\"c999\">03-03</p><p>23:45</p></span>\n" +
                "                    <span id=\"jq_league_starttime_1552054\" style=\"display:none;\">00:00</span>\n" +
                "\n" +
                "                    <span id=\"jq_status_1552054\" class=\"state red\" data-matchstatus=\"2\">已完场</span>\n" +
                "                </td>\n" +
                "                <td>\n" +
                "                    <div class=\"teamLine left\">\n" +
                "                        <span class=\"card yellow jq_yellowcard\" style=\"display:none\">0</span>\n" +
                "                        <span class=\"card red jq_redcard\" style=\"display:none\">0</span>\n" +
                "                        <span class=\"cbbb ml5 jq_rank\">[4]</span>\n" +
                "                        <span class=\"name\">\n" +
                "\t\t\t\t\t\t<a target=\"_blank\" href=\"http://league.aicai.com/team/246/\">阿尔克马</a>\n" +
                "\t\t\t\t\t</span>\n" +
                "                    </div>\n" +
                "                    <div class=\"vs\" onmouseover=\"showAllOdds($(this));\" onmouseout=\"hideAllOdds($(this));\"><a target=\"_blank\" href=\"//yq.aicai.com/matchPlanDetail/1552054-1/room?showHeader=1&amp;tab=1\"><span class=\"red homeScore\">4</span><span class=\"ml5 mr5\">-</span><span class=\"red awayScore\">2</span></a></div>\n" +
                "                    <!--盘口tip-->\n" +
                "                    <div class=\"handicapTip\">\n" +
                "                        <i class=\"triangle01\"></i><i class=\"triangle02\"></i>\n" +
                "                        <table>\n" +
                "                            <thead>\n" +
                "                            <tr><td>阿尔克马</td><td>福图纳</td></tr>\n" +
                "                            <tr class=\"tr2\"><td style=\"border-right: 1px solid #eee;\">即时指数</td><td>初盘指数</td></tr>\n" +
                "                            </thead>\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td style=\"border-right: 1px solid #eee;\">\n" +
                "                                    <span class=\"span1\">亚盘</span>\n" +
                "                                    <span class=\"span2 asia_js_win\"></span><span class=\"span3 c999 asia_js_handicap\"></span><span class=\"span4 asia_js_lose\"></span>\n" +
                "                                </td>\n" +
                "                                <td><span class=\"span1 asia_first_win\"></span><span class=\"span3 c999 asia_first_handicap\"></span><span class=\"span4 asia_first_lose\"></span></td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td style=\"border-right: 1px solid #eee;\">\n" +
                "                                    <span class=\"span1\">欧赔</span>\n" +
                "                                    <span class=\"span2 ou_js_win\"></span><span class=\"span3 ou_js_draw\"></span><span class=\"span4 ou_js_lose\"></span>\n" +
                "                                </td>\n" +
                "                                <td><span class=\"span1 ou_first_win\"></span><span class=\"span3 ou_js_draw\"></span><span class=\"span4 ou_js_lose\"></span></td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td style=\"border-right: 1px solid #eee;\">\n" +
                "                                    <span class=\"span1\">大小</span>\n" +
                "                                    <span class=\"span2 bs_js_win\"></span><span class=\"span3 c999 bs_js_handicap\"></span><span class=\"span4 bs_js_lose\"></span>\n" +
                "                                </td>\n" +
                "                                <td><span class=\"span1 bs_first_win\"></span><span class=\"span3 c999  bs_first_handicap\"></span><span class=\"span4 bs_first_lose\"></span></td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </div>\n" +
                "                    <div class=\"teamLine right\">\n" +
                "\t\t\t\t\t<span class=\"name\">\n" +
                "\t\t\t\t\t\t<a target=\"_blank\" href=\"http://league.aicai.com/team/285/\">福图纳</a>\n" +
                "\t\t\t\t\t</span>\n" +
                "                        <span class=\"cbbb mr5 jq_rank\">[13]</span>\n" +
                "                        <span class=\"card red jq_redcard\" style=\"display:none\">0</span>\n" +
                "                        <span class=\"card yellow jq_yellowcard\" style=\"display: none;\">1</span>\n" +
                "                    </div>\n" +
                "                    <div class=\"videoBxo\">\n" +
                "                        <a class=\"video sprite_live\" target=\"_blank\" href=\"//yq.aicai.com/matchPlanDetail/1552054-1/room?showHeader=1&amp;tab=1\"></a>\n" +
                "                        <a class=\"animate sprite_live\" target=\"_blank\" href=\"//yq.aicai.com/matchPlanDetail/1552054-1/room?showHeader=1&amp;tab=2\"></a>\n" +
                "                    </div>\n" +
                "                    <div class=\"recomExpert\">\n" +
                "                        <p><a target=\"_blank\" href=\"http://yq.aicai.com/matchPlanDetail/1552054-1/matchPlanRecommend?showHeader=1&amp;agentId=2335103\"><em class=\"red\">29</em>位专家推荐</a></p>\n" +
                "                    </div>\n" +
                "                </td>\n" +
                "                <td class=\"halfCourt\">\n" +
                "\t\t\t\t<span class=\"red\">\n" +
                "\t\t\t\t\t 1 :\n" +
                "\t\t\t\t\t 2\n" +
                "\t\t\t\t</span>\n" +
                "                </td>\n" +
                "                <td><div class=\"tdDiv letBallShow\"><p class=\"letBallShow_no\" style=\"border-bottom: 1px solid #eee;\">0</p><p class=\"letBallShow_let\">-2</p></div></td>\n" +
                "                <td class=\"txtddd\"><div class=\"tdDiv ouOddsShow\"><p class=\"ouOddsShow_no\" style=\"border-bottom: 1px solid #eee;\"><em><b class=\"odBg blue\">1.07</b></em><em>7.25</em><em>11.50</em></p><p class=\"ouOddsShow_let h30\"><em>1.80</em><em><b class=\"odBg red\">4.20</b></em><em>2.74</em></p></div></td>\n" +
                "                <td class=\"linkTd\">\n" +
                "                    <a target=\"_blank\" href=\"https://live.aicai.com/zc/xyo_1552054.html\">析</a>\n" +
                "                    <a target=\"_blank\" href=\"https://live.aicai.com/zc/xyo_1552054_yazhi.html\">亚</a>\n" +
                "                    <a target=\"_blank\" href=\"https://live.aicai.com/zc/xyo_1552054_ouzhi.html\">欧</a>\n" +
                "                    <a target=\"_blank\" href=\"https://live.aicai.com/zc/xyo_1552054_dxzhi.html\">大</a>\n" +
                "                    <a target=\"_blank\" href=\"http://yq.aicai.com/matchPlanDetail/1552054-1/matchPlanIntelligence?showHeader=1\" class=\"red\">情报</a>\n" +
                "                    <a href=\"javascript:;\" onclick=\"topOrCancelTop($(this));\" class=\"stick sprite_live\"></a>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr class=\"liveMacthLi\" id=\"jq_match_1552062_tr\" data-matchid=\"2695785\" data-qtmatchid=\"1552062\" data-index=\"28\" data-middle=\"false\" data-leagueid=\"16\" data-matchstatus=\"2\" data-matchstatuscategory=\"2\">\n" +
                "                <td class=\"pr no_border_left\">\n" +
                "                    <input type=\"checkbox\" checked=\"checked\" class=\"input\" onchange=\"showOrHideMatch($(this));\">\n" +
                "                    <span class=\"week\">周日028</span>\n" +
                "                    <span class=\"league\" style=\"background:#FF6699\">\n" +
                "\t\t\t\t\t\t<a target=\"_blank\" href=\"http://league.aicai.com/league/28/\">荷甲</a>\n" +
                "\t\t\t\t</span>\n" +
                "                    <span class=\"time\"><p class=\"c999\">03-03</p><p>23:45</p></span>\n" +
                "                    <span id=\"jq_league_starttime_1552062\" style=\"display:none;\">00:00</span>\n" +
                "\n" +
                "                    <span id=\"jq_status_1552062\" class=\"state red\" data-matchstatus=\"2\">已完场</span>\n" +
                "                </td>\n" +
                "                <td>\n" +
                "                    <div class=\"teamLine left\">\n" +
                "                        <span class=\"card yellow jq_yellowcard\" style=\"display:none\">0</span>\n" +
                "                        <span class=\"card red jq_redcard\" style=\"display:none\">0</span>\n" +
                "                        <span class=\"cbbb ml5 jq_rank\">[3]</span>\n" +
                "                        <span class=\"name\">\n" +
                "\t\t\t\t\t\t<a target=\"_blank\" href=\"http://league.aicai.com/team/264/\">费耶诺德</a>\n" +
                "\t\t\t\t\t</span>\n" +
                "                    </div>\n" +
                "                    <div class=\"vs\" onmouseover=\"showAllOdds($(this));\" onmouseout=\"hideAllOdds($(this));\"><a target=\"_blank\" href=\"//yq.aicai.com/matchPlanDetail/1552062-1/room?showHeader=1&amp;tab=1\"><span class=\"red homeScore\">4</span><span class=\"ml5 mr5\">-</span><span class=\"red awayScore\">0</span></a></div>\n" +
                "                    <!--盘口tip-->\n" +
                "                    <div class=\"handicapTip\">\n" +
                "                        <i class=\"triangle01\"></i><i class=\"triangle02\"></i>\n" +
                "                        <table>\n" +
                "                            <thead>\n" +
                "                            <tr><td>费耶诺德</td><td>埃门</td></tr>\n" +
                "                            <tr class=\"tr2\"><td style=\"border-right: 1px solid #eee;\">即时指数</td><td>初盘指数</td></tr>\n" +
                "                            </thead>\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td style=\"border-right: 1px solid #eee;\">\n" +
                "                                    <span class=\"span1\">亚盘</span>\n" +
                "                                    <span class=\"span2 asia_js_win\"></span><span class=\"span3 c999 asia_js_handicap\"></span><span class=\"span4 asia_js_lose\"></span>\n" +
                "                                </td>\n" +
                "                                <td><span class=\"span1 asia_first_win\"></span><span class=\"span3 c999 asia_first_handicap\"></span><span class=\"span4 asia_first_lose\"></span></td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td style=\"border-right: 1px solid #eee;\">\n" +
                "                                    <span class=\"span1\">欧赔</span>\n" +
                "                                    <span class=\"span2 ou_js_win\"></span><span class=\"span3 ou_js_draw\"></span><span class=\"span4 ou_js_lose\"></span>\n" +
                "                                </td>\n" +
                "                                <td><span class=\"span1 ou_first_win\"></span><span class=\"span3 ou_js_draw\"></span><span class=\"span4 ou_js_lose\"></span></td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td style=\"border-right: 1px solid #eee;\">\n" +
                "                                    <span class=\"span1\">大小</span>\n" +
                "                                    <span class=\"span2 bs_js_win\"></span><span class=\"span3 c999 bs_js_handicap\"></span><span class=\"span4 bs_js_lose\"></span>\n" +
                "                                </td>\n" +
                "                                <td><span class=\"span1 bs_first_win\"></span><span class=\"span3 c999  bs_first_handicap\"></span><span class=\"span4 bs_first_lose\"></span></td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </div>\n" +
                "                    <div class=\"teamLine right\">\n" +
                "\t\t\t\t\t<span class=\"name\">\n" +
                "\t\t\t\t\t\t<a target=\"_blank\" href=\"http://league.aicai.com/team/947/\">埃门</a>\n" +
                "\t\t\t\t\t</span>\n" +
                "                        <span class=\"cbbb mr5 jq_rank\">[16]</span>\n" +
                "                        <span class=\"card red jq_redcard\" style=\"display:none\">0</span>\n" +
                "                        <span class=\"card yellow jq_yellowcard\" style=\"display: none;\">1</span>\n" +
                "                    </div>\n" +
                "                    <div class=\"videoBxo\">\n" +
                "                        <a class=\"video sprite_live\" target=\"_blank\" href=\"//yq.aicai.com/matchPlanDetail/1552062-1/room?showHeader=1&amp;tab=1\"></a>\n" +
                "                        <a class=\"animate sprite_live\" target=\"_blank\" href=\"//yq.aicai.com/matchPlanDetail/1552062-1/room?showHeader=1&amp;tab=2\"></a>\n" +
                "                    </div>\n" +
                "                    <div class=\"recomExpert\">\n" +
                "                        <p><a target=\"_blank\" href=\"http://yq.aicai.com/matchPlanDetail/1552062-1/matchPlanRecommend?showHeader=1&amp;agentId=2335103\"><em class=\"red\">58</em>位专家推荐</a></p>\n" +
                "                    </div>\n" +
                "                </td>\n" +
                "                <td class=\"halfCourt\">\n" +
                "\t\t\t\t<span class=\"red\">\n" +
                "\t\t\t\t\t 1 :\n" +
                "\t\t\t\t\t 0\n" +
                "\t\t\t\t</span>\n" +
                "                </td>\n" +
                "                <td><div class=\"tdDiv letBallShow\"><p class=\"letBallShow_no\" style=\"border-bottom: 1px solid #eee;\">0</p><p class=\"letBallShow_let\">-2</p></div></td>\n" +
                "                <td class=\"txtddd\"><div class=\"tdDiv ouOddsShow\"><p class=\"ouOddsShow_no\" style=\"border-bottom: 1px solid #eee;\"><em><b class=\"odBg blue\">1.06</b></em><em>7.75</em><em>11.50</em></p><p class=\"ouOddsShow_let h30\"><em><b class=\"odBg blue\">1.70</b></em><em>4.25</em><em>2.98</em></p></div></td>\n" +
                "                <td class=\"linkTd\">\n" +
                "                    <a target=\"_blank\" href=\"https://live.aicai.com/zc/xyo_1552062.html\">析</a>\n" +
                "                    <a target=\"_blank\" href=\"https://live.aicai.com/zc/xyo_1552062_yazhi.html\">亚</a>\n" +
                "                    <a target=\"_blank\" href=\"https://live.aicai.com/zc/xyo_1552062_ouzhi.html\">欧</a>\n" +
                "                    <a target=\"_blank\" href=\"https://live.aicai.com/zc/xyo_1552062_dxzhi.html\">大</a>\n" +
                "                    <a target=\"_blank\" href=\"http://yq.aicai.com/matchPlanDetail/1552062-1/matchPlanIntelligence?showHeader=1\" class=\"red\">情报</a>\n" +
                "                    <a href=\"javascript:;\" onclick=\"topOrCancelTop($(this));\" class=\"stick sprite_live\"></a>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "\n" +
                "            </tbody></table>\n" +
                "\n" +
                "        <div class=\"spCount\">\n" +
                "            <span id=\"spCountCompany\">竞彩sp值</span>\n" +
                "            <span class=\"peilv blue\">首赔</span><span id=\"firstCount\" class=\"c333\">41</span>\n" +
                "            <span class=\"peilv yellow\">次赔</span><span id=\"secondCount\" class=\"c333\">11</span>\n" +
                "            <span class=\"peilv red\">末赔</span><span id=\"thirdCount\" class=\"c333\">22</span>\n" +
                "            <span id=\"letSpCount\" style=\"display: none;\">\n" +
                "\t\t\t\t\t<span class=\"ml25\">竞彩sp值(让球)</span>\n" +
                "\t\t\t\t\t<span class=\"peilv blue\">首赔</span><span id=\"letFirstCount\" class=\"c333\"></span>\n" +
                "\t\t\t\t\t<span class=\"peilv yellow\">次赔</span><span id=\"letSecondCount\" class=\"c333\"></span>\n" +
                "\t\t\t\t\t<span class=\"peilv red\">末赔</span><span id=\"letThirdCount\" class=\"c333\"></span>\n" +
                "\t\t\t\t</span>\n" +
                "        </div>\n" +
                "    </div>";

        Document doc = Jsoup.parse(html);
        Elements table1 = doc != null ? doc.select("tbody:eq(1)") : null;
        Elements tr1 = table1 != null ? table1.select("tr") : null;
        String thead = tr1 != null ? tr1.get(0).select("td").get(0).text() : null;
        //表头
        System.out.println(thead);

        Elements table = doc != null ? doc.select("tbody:eq(2)") : null;
        // 使用选择器选择该table内所有的<tr> <tr/>
        Elements trs = table != null ? table.select("tr") : null;
        List<ScoreDO> scoreDOS = new ArrayList<>();
        //遍历该表格内的所有的<tr> <tr/>
        if (trs != null) {
            for (Element tr : trs) {
                ScoreDO scoreDO = new ScoreDO();
                // 获取一个tr
                // 获取该行的所有td节点
                Elements tds = tr.select("td");
                // 选择某一个td节点
                for (Element ignore : tds) {
                    // 获取td节点的所有div
                    //获取比赛周次
                    Elements span1 = tds.get(1).select("span");
                    String betWeek = span1.get(1).text();
                    System.out.println(betWeek);
                    scoreDO.setBetWeek(betWeek);

                    //比赛赛事(英超)
                    //赛事取属性值
                    String style1 = span1.get(2).attr("style");
                    System.out.println(style1);
                    String betLeague = span1.get(2).select("a").text();
                    System.out.println(betLeague);
                    scoreDO.setBetLeague(betLeague);

                    Elements p1 = span1.get(3).select("p");

                    String date = p1.get(0).text();
                    String time = p1.get(1).text();
                    scoreDO.setBetTime(date+" "+time);
                    System.out.println(date+" "+time);


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
                scoreDOS.add(scoreDO);
            }
            System.out.println(scoreDOS);
        }
    }


    @GetMapping()
    @RequiresPermissions("common:score:score")
    public String score() {
        return "common/score/score";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("common:score:score")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ScoreDO> scoreList = scoreService.list(query);
        int total = scoreService.count(query);
        return new PageUtils(scoreList, total);
    }

    @GetMapping("/add")
    @RequiresPermissions("common:score:add")
    public String add() {
        return "common/score/add";
    }

    @GetMapping("/edit/{eventId}")
    @RequiresPermissions("common:score:edit")
    public String edit(@PathVariable("eventId") Long eventId, Model model) {
        ScoreDO score = scoreService.get(eventId);
        model.addAttribute("score", score);
        return "common/score/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("common:score:add")
    public R save(ScoreDO score) {
        if (scoreService.save(score) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 批量保存
     */
    @ResponseBody
    @PostMapping("/batchSave")
    public R batchSave(List<ScoreDO> scoreDOS) {
        if (scoreService.batchSave(scoreDOS)>0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("common:score:edit")
    public R update(ScoreDO score) {
        scoreService.update(score);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    public R remove(Long betId) {
        if (scoreService.remove(betId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] betIds) {
        scoreService.batchRemove(betIds);
        return R.ok();
    }

}
