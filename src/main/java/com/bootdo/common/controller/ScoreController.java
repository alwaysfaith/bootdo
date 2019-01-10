package com.bootdo.common.controller;

import com.bootdo.common.domain.ScoreDO;
import com.bootdo.common.service.ScoreService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        String html = "<table class=\"table_stys_01\" id=\"jq_jsbf_body\">\n" +
                "                 <thead>\n" +
                "                  <tr>\n" +
                "                  \t<td width=\"30\">显示</td>\n" +
                "                    <td width=\"50\">场次</td>\n" +
                "                    <td width=\"65\">赛事</td>\n" +
                "                    <td width=\"75\">开赛时间</td>\n" +
                "                    <td>赛事信息</td>\n" +
                "                    <td id=\"expertsTd\" width=\"80\" style=\"display: table-cell;\">专家推荐</td>\n" +
                "                    <td width=\"40\">半场</td>\n" +
                "                    <td width=\"35\">让球</td>\n" +
                "                    <td width=\"135\"><select id=\"jq_select_data\"><option value=\"sp_val\">竞彩sp值</option><option value=\"avg_euro_val\">平均欧指</option></select></td>\n" +
                "                    <td width=\"75\" class=\"rt_no_border\">数据分析</td>\n" +
                "                  </tr>\n" +
                "                 </thead>\n" +
                "            \t \t\n" +
                "\t\n" +
                "\n" +
                "\n" +
                "            \t\t<tbody id=\"jq_match_bodyHead_2019-01-03_tbody\" class=\"jq_match_bodyHead\">\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"10\">2019-01-03 (11:00 -- 次日 11:00)</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "\t<tbody class=\"tbody_body jq_match_2019-01-03_tbody jq_match_bodyHead\">\n" +
                "\t\t\t<tr class=\"otr_bg jq_match_matchId_1576211_tr jq_match_tr jq_match_leagueId_32_tr jq_match_status_-1_tr\" id=\"jq_match_1576211_tr\">\n" +
                "\t\t\t\t<td>\n" +
                "\t\t\t\t\t<input type=\"checkbox\" id=\"jq_1576211\" class=\"jq_selectmatch input\" checked=\"checked\">\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class=\"txtbbb xx_bg_weekIndex\" id=\"jq_matchindex_1576211_td\">周四101</td>\n" +
                "\t\t\t\t<td style=\"color:#fff; background:#008888\" id=\"jq_league_1576211_td\" status=\"0\"><a href=\"http://league.aicai.com/league/32/\" style=\"color:#fff;\" target=\"_blank\">葡超</a></td>\n" +
                "\t\t\t\t<td>\n" +
                "\t\t\t\t<span id=\"jq_league_matchTime_1576211\">01-03 23:59</span>\n" +
                "\t\t\t\t<span id=\"jq_league_starttime_1576211\" style=\"display:none;\">23:59</span>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class=\"duiz_box\">\n" +
                "\t\t\t\t\t<span class=\"left_line\">\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_hostredcard_1576211\" class=\"red_card_num jq_redcard\" title=\"红牌\">0</s>\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_hostyellowcard_1576211\" class=\"yellow_card_num jq_yellowcard\" title=\"黄牌\" style=\"display: none;\">2</s>\n" +
                "\t\t\t\t\t\t<span title=\"球队排名\" class=\"gray_11 jq_rank\" id=\"jq_hostrank_1576211\">\n" +
                "\t\t\t\t\t\t[18]\n" +
                "\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t<span id=\"jq_match_hostteam_1576211_span\"><a href=\"http://league.aicai.com/team/866/\" target=\"_blank\">沙维什</a></span>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t<span class=\"vs\">\n" +
                "\t\t\t\t\t\t\t<a id=\"jq_timelyscore_1576211\" class=\"wcbf_color\">0:0</a>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t<span class=\"right_line\">\n" +
                "\t\t\t\t\t\t<span id=\"jq_match_guestteam_1576211_span\"><a href=\"http://league.aicai.com/team/1343/\" target=\"_blank\">费伦斯</a></span>\n" +
                "\t\t\t\t\t\t<span title=\"球队排名\" class=\"gray_11 jq_rank\" id=\"jq_guestrank_1576211\">\n" +
                "\t\t\t\t\t\t[17]\n" +
                "\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_guestredcard_1576211\" class=\"red_card_num jq_redcard\" title=\"红牌\" style=\"display:none;\">0</s>\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_guestyellowcard_1576211\" class=\"yellow_card_num jq_yellowcard\" title=\"黄牌\" style=\"display: none;\">3</s>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t<span class=\"time_box\">\n" +
                "\t\t\t\t\t<span class=\"time_wc\">\n" +
                "\t\t\t\t\t\t<span id=\"jq_status_1576211\" rel=\"-1\">完场</span>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t</span> \n" +
                "\t\t\t\t<span title=\"查看比赛进程\" class=\"s_h_h jq_matchdetail_control jq_1576211_control\" id=\"jq_1576211_control\"></span>                   \n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class=\"expertsNumTd\">\n" +
                "\t\t\t\t\t\t\t<a target=\"_blank\" href=\"https://yq.aicai.com/matchPlanDetail/1576211-1?agentId=2335103\"><span class=\"red\">184</span>位专家推荐</a>\t\t\t\t\t\t\t\n" +
                "\t\t\t\t</td>                    \n" +
                "\t\t\t\t<td id=\"jq_halfscore_1576211\">\n" +
                "\t\t\t\t<span class=\"red\">0:0</span>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td id=\"jq_rangqiu_1576211\" letpoint=\"-1\"><div class=\"tdDiv\"><p style=\"border-bottom: 1px solid #DDDDDD;\">0</p><p>-1</p></div></td>\n" +
                "\t\t\t\t<td class=\"txtddd\"><div class=\"tdDiv\"><p style=\"border-bottom: 1px solid #DDDDDD;\"><i id=\"jq_winOdds_1576211\">1.83</i>|<i id=\"jq_drowOdds_1576211\" style=\"background-color: rgb(218, 175, 2); color: white;\">2.90</i>|<i id=\"jq_loseOdds_1576211\">4.20</i></p><p><i id=\"jq_winOdds_let_1576211\">3.80</i>|<i id=\"jq_drowOdds_let_1576211\">3.40</i>|<i id=\"jq_loseOdds_let_1576211\" style=\"background-color: rgb(21, 110, 202); color: white;\">1.75</i></p></div></td>\n" +
                "\t\t\t\t<td class=\"rt_no_border\">\n" +
                "\t\t\t\t<a href=\"/zc/xyo_1576211.html\" target=\"_blank\">析</a>&nbsp;\n" +
                "\t\t\t\t<a href=\"/zc/xyo_1576211_yazhi.html\" target=\"_blank\">亚</a>&nbsp;\n" +
                "\t\t\t\t<a href=\"/zc/xyo_1576211_ouzhi.html\" target=\"_blank\">欧</a>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr class=\"jq_match_tr jq_match_matchId_1576215_tr jq_match_leagueId_32_tr jq_match_status_-1_tr\" id=\"jq_match_1576215_tr\">\n" +
                "\t\t\t\t<td>\n" +
                "\t\t\t\t\t<input type=\"checkbox\" id=\"jq_1576215\" class=\"jq_selectmatch input\" checked=\"checked\">\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class=\"txtbbb xx_bg_weekIndex\" id=\"jq_matchindex_1576215_td\">周四102</td>\n" +
                "\t\t\t\t<td style=\"color:#fff; background:#008888\" id=\"jq_league_1576215_td\" status=\"0\"><a href=\"http://league.aicai.com/league/32/\" style=\"color:#fff;\" target=\"_blank\">葡超</a></td>\n" +
                "\t\t\t\t<td>\n" +
                "\t\t\t\t<span id=\"jq_league_matchTime_1576215\">01-04 02:00</span>\n" +
                "\t\t\t\t<span id=\"jq_league_starttime_1576215\" style=\"display:none;\">02:00</span>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class=\"duiz_box\">\n" +
                "\t\t\t\t\t<span class=\"left_line\">\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_hostredcard_1576215\" class=\"red_card_num jq_redcard\" title=\"红牌\" style=\"display:none;\">0</s>\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_hostyellowcard_1576215\" class=\"yellow_card_num jq_yellowcard\" title=\"黄牌\" style=\"display: none;\">3</s>\n" +
                "\t\t\t\t\t\t<span title=\"球队排名\" class=\"gray_11 jq_rank\" id=\"jq_hostrank_1576215\">\n" +
                "\t\t\t\t\t\t[4]\n" +
                "\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t<span id=\"jq_match_hostteam_1576215_span\"><a href=\"http://league.aicai.com/team/461/\" target=\"_blank\">里斯本竞</a></span>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t<span class=\"vs\">\n" +
                "\t\t\t\t\t\t\t<a id=\"jq_timelyscore_1576215\" class=\"wcbf_color\">2:1</a>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t<span class=\"right_line\">\n" +
                "\t\t\t\t\t\t<span id=\"jq_match_guestteam_1576215_span\"><a href=\"http://league.aicai.com/team/840/\" target=\"_blank\">比兰尼塞</a></span>\n" +
                "\t\t\t\t\t\t<span title=\"球队排名\" class=\"gray_11 jq_rank\" id=\"jq_guestrank_1576215\">\n" +
                "\t\t\t\t\t\t[8]\n" +
                "\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_guestredcard_1576215\" class=\"red_card_num jq_redcard\" title=\"红牌\" style=\"display:none;\">0</s>\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_guestyellowcard_1576215\" class=\"yellow_card_num jq_yellowcard\" title=\"黄牌\" style=\"display: none;\">3</s>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t<span class=\"time_box\">\n" +
                "\t\t\t\t\t<span class=\"time_wc\">\n" +
                "\t\t\t\t\t\t<span id=\"jq_status_1576215\" rel=\"-1\">完场</span>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t</span> \n" +
                "\t\t\t\t<span title=\"查看比赛进程\" class=\"s_h_h jq_matchdetail_control jq_1576215_control\" id=\"jq_1576215_control\"></span>                   \n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class=\"expertsNumTd\">\n" +
                "\t\t\t\t\t\t\t<a target=\"_blank\" href=\"https://yq.aicai.com/matchPlanDetail/1576215-1?agentId=2335103\"><span class=\"red\">198</span>位专家推荐</a>\t\t\t\t\t\t\t\n" +
                "\t\t\t\t</td>                    \n" +
                "\t\t\t\t<td id=\"jq_halfscore_1576215\">\n" +
                "\t\t\t\t<span class=\"red\">0:0</span>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td id=\"jq_rangqiu_1576215\" letpoint=\"-1\"><div class=\"tdDiv\"><p style=\"border-bottom: 1px solid #DDDDDD;\">0</p><p>-1</p></div></td>\n" +
                "\t\t\t\t<td class=\"txtddd\"><div class=\"tdDiv\"><p style=\"border-bottom: 1px solid #DDDDDD;\"><i id=\"jq_winOdds_1576215\" style=\"background-color: rgb(21, 110, 202); color: white;\">1.20</i>|<i id=\"jq_drowOdds_1576215\">5.10</i>|<i id=\"jq_loseOdds_1576215\">10.00</i></p><p><i id=\"jq_winOdds_let_1576215\">1.77</i>|<i id=\"jq_drowOdds_let_1576215\" style=\"background-color: rgb(255, 69, 0); color: white;\">3.55</i>|<i id=\"jq_loseOdds_let_1576215\">3.53</i></p></div></td>\n" +
                "\t\t\t\t<td class=\"rt_no_border\">\n" +
                "\t\t\t\t<a href=\"/zc/xyo_1576215.html\" target=\"_blank\">析</a>&nbsp;\n" +
                "\t\t\t\t<a href=\"/zc/xyo_1576215_yazhi.html\" target=\"_blank\">亚</a>&nbsp;\n" +
                "\t\t\t\t<a href=\"/zc/xyo_1576215_ouzhi.html\" target=\"_blank\">欧</a>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr class=\"otr_bg jq_match_matchId_1552349_tr jq_match_tr jq_match_leagueId_43_tr jq_match_status_-1_tr\" id=\"jq_match_1552349_tr\">\n" +
                "\t\t\t\t<td>\n" +
                "\t\t\t\t\t<input type=\"checkbox\" id=\"jq_1552349\" class=\"jq_selectmatch input\" checked=\"checked\">\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class=\"txtbbb xx_bg_weekIndex\" id=\"jq_matchindex_1552349_td\">周四103</td>\n" +
                "\t\t\t\t<td style=\"color:#fff; background:#FF3333\" id=\"jq_league_1552349_td\" status=\"0\"><a href=\"http://league.aicai.com/league/43/\" style=\"color:#fff;\" target=\"_blank\">英超</a></td>\n" +
                "\t\t\t\t<td>\n" +
                "\t\t\t\t<span id=\"jq_league_matchTime_1552349\">01-04 04:00</span>\n" +
                "\t\t\t\t<span id=\"jq_league_starttime_1552349\" style=\"display:none;\">04:00</span>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class=\"duiz_box\">\n" +
                "\t\t\t\t\t<span class=\"left_line\">\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_hostredcard_1552349\" class=\"red_card_num jq_redcard\" title=\"红牌\" style=\"display:none;\">0</s>\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_hostyellowcard_1552349\" class=\"yellow_card_num jq_yellowcard\" title=\"黄牌\" style=\"display: none;\">4</s>\n" +
                "\t\t\t\t\t\t<span title=\"球队排名\" class=\"gray_11 jq_rank\" id=\"jq_hostrank_1552349\">\n" +
                "\t\t\t\t\t\t[3]\n" +
                "\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t<span id=\"jq_match_hostteam_1552349_span\"><a href=\"http://league.aicai.com/team/54/\" target=\"_blank\">曼城</a></span>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t<span class=\"vs\">\n" +
                "\t\t\t\t\t\t\t<a id=\"jq_timelyscore_1552349\" class=\"wcbf_color\">2:1</a>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t<span class=\"right_line\">\n" +
                "\t\t\t\t\t\t<span id=\"jq_match_guestteam_1552349_span\"><a href=\"http://league.aicai.com/team/53/\" target=\"_blank\">利物浦</a></span>\n" +
                "\t\t\t\t\t\t<span title=\"球队排名\" class=\"gray_11 jq_rank\" id=\"jq_guestrank_1552349\">\n" +
                "\t\t\t\t\t\t[1]\n" +
                "\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_guestredcard_1552349\" class=\"red_card_num jq_redcard\" title=\"红牌\" style=\"display:none;\">0</s>\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_guestyellowcard_1552349\" class=\"yellow_card_num jq_yellowcard\" title=\"黄牌\" style=\"display: none;\">2</s>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t<span class=\"time_box\">\n" +
                "\t\t\t\t\t<span class=\"time_wc\">\n" +
                "\t\t\t\t\t\t<span id=\"jq_status_1552349\" rel=\"-1\">完场</span>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t</span> \n" +
                "\t\t\t\t<span title=\"查看比赛进程\" class=\"s_h_h jq_matchdetail_control jq_1552349_control\" id=\"jq_1552349_control\"></span>                   \n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class=\"expertsNumTd\">\n" +
                "\t\t\t\t\t\t\t<a target=\"_blank\" href=\"https://yq.aicai.com/matchPlanDetail/1552349-1?agentId=2335103\"><span class=\"red\">337</span>位专家推荐</a>\t\t\t\t\t\t\t\n" +
                "\t\t\t\t</td>                    \n" +
                "\t\t\t\t<td id=\"jq_halfscore_1552349\">\n" +
                "\t\t\t\t<span class=\"red\">1:0</span>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td id=\"jq_rangqiu_1552349\" letpoint=\"-1\"><div class=\"tdDiv\"><p style=\"border-bottom: 1px solid #DDDDDD;\">0</p><p>-1</p></div></td>\n" +
                "\t\t\t\t<td class=\"txtddd\"><div class=\"tdDiv\"><p style=\"border-bottom: 1px solid #DDDDDD;\"><i id=\"jq_winOdds_1552349\" style=\"background-color: rgb(21, 110, 202); color: white;\">1.90</i>|<i id=\"jq_drowOdds_1552349\">3.70</i>|<i id=\"jq_loseOdds_1552349\">3.00</i></p><p><i id=\"jq_winOdds_let_1552349\">3.75</i>|<i id=\"jq_drowOdds_let_1552349\" style=\"background-color: rgb(255, 69, 0); color: white;\">3.85</i>|<i id=\"jq_loseOdds_let_1552349\">1.66</i></p></div></td>\n" +
                "\t\t\t\t<td class=\"rt_no_border\">\n" +
                "\t\t\t\t<a href=\"/zc/xyo_1552349.html\" target=\"_blank\">析</a>&nbsp;\n" +
                "\t\t\t\t<a href=\"/zc/xyo_1552349_yazhi.html\" target=\"_blank\">亚</a>&nbsp;\n" +
                "\t\t\t\t<a href=\"/zc/xyo_1552349_ouzhi.html\" target=\"_blank\">欧</a>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr class=\"jq_match_tr jq_match_matchId_1576208_tr jq_match_leagueId_32_tr jq_match_status_-1_tr\" id=\"jq_match_1576208_tr\">\n" +
                "\t\t\t\t<td>\n" +
                "\t\t\t\t\t<input type=\"checkbox\" id=\"jq_1576208\" class=\"jq_selectmatch input\" checked=\"checked\">\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class=\"txtbbb xx_bg_weekIndex\" id=\"jq_matchindex_1576208_td\">周四104</td>\n" +
                "\t\t\t\t<td style=\"color:#fff; background:#008888\" id=\"jq_league_1576208_td\" status=\"0\"><a href=\"http://league.aicai.com/league/32/\" style=\"color:#fff;\" target=\"_blank\">葡超</a></td>\n" +
                "\t\t\t\t<td>\n" +
                "\t\t\t\t<span id=\"jq_league_matchTime_1576208\">01-04 04:15</span>\n" +
                "\t\t\t\t<span id=\"jq_league_starttime_1576208\" style=\"display:none;\">05:22</span>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class=\"duiz_box\">\n" +
                "\t\t\t\t\t<span class=\"left_line\">\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_hostredcard_1576208\" class=\"red_card_num jq_redcard\" title=\"红牌\" style=\"display:none;\">0</s>\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_hostyellowcard_1576208\" class=\"yellow_card_num jq_yellowcard\" title=\"黄牌\" style=\"display: none;\">2</s>\n" +
                "\t\t\t\t\t\t<span title=\"球队排名\" class=\"gray_11 jq_rank\" id=\"jq_hostrank_1576208\">\n" +
                "\t\t\t\t\t\t[15]\n" +
                "\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t<span id=\"jq_match_hostteam_1576208_span\"><a href=\"http://league.aicai.com/team/867/\" target=\"_blank\">阿维斯</a></span>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t<span class=\"vs\">\n" +
                "\t\t\t\t\t\t\t<a id=\"jq_timelyscore_1576208\" class=\"wcbf_color\">0:1</a>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t<span class=\"right_line\">\n" +
                "\t\t\t\t\t\t<span id=\"jq_match_guestteam_1576208_span\"><a href=\"http://league.aicai.com/team/463/\" target=\"_blank\">波尔图</a></span>\n" +
                "\t\t\t\t\t\t<span title=\"球队排名\" class=\"gray_11 jq_rank\" id=\"jq_guestrank_1576208\">\n" +
                "\t\t\t\t\t\t[1]\n" +
                "\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_guestredcard_1576208\" class=\"red_card_num jq_redcard\" title=\"红牌\" style=\"display:none;\">0</s>\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_guestyellowcard_1576208\" class=\"yellow_card_num jq_yellowcard\" title=\"黄牌\" style=\"display: none;\">1</s>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t<span class=\"time_box\">\n" +
                "\t\t\t\t\t<span class=\"time_wc\">\n" +
                "\t\t\t\t\t\t<span id=\"jq_status_1576208\" rel=\"-1\">完场</span>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t</span> \n" +
                "\t\t\t\t<span title=\"查看比赛进程\" class=\"s_h_h jq_matchdetail_control jq_1576208_control\" id=\"jq_1576208_control\"></span>                   \n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class=\"expertsNumTd\">\n" +
                "\t\t\t\t\t\t\t<a target=\"_blank\" href=\"https://yq.aicai.com/matchPlanDetail/1576208-1?agentId=2335103\"><span class=\"red\">169</span>位专家推荐</a>\t\t\t\t\t\t\t\n" +
                "\t\t\t\t</td>                    \n" +
                "\t\t\t\t<td id=\"jq_halfscore_1576208\">\n" +
                "\t\t\t\t<span class=\"red\">0:1</span>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td id=\"jq_rangqiu_1576208\" letpoint=\"1\"><div class=\"tdDiv\"><p style=\"border-bottom: 1px solid #DDDDDD;\">0</p><p>1</p></div></td>\n" +
                "\t\t\t\t<td class=\"txtddd\"><div class=\"tdDiv\"><p style=\"border-bottom: 1px solid #DDDDDD;\"><i id=\"jq_winOdds_1576208\">11.50</i>|<i id=\"jq_drowOdds_1576208\">5.35</i>|<i id=\"jq_loseOdds_1576208\" style=\"background-color: rgb(21, 110, 202); color: white;\">1.17</i></p><p><i id=\"jq_winOdds_let_1576208\">3.98</i>|<i id=\"jq_drowOdds_let_1576208\" style=\"background-color: rgb(218, 175, 2); color: white;\">3.45</i>|<i id=\"jq_loseOdds_let_1576208\">1.70</i></p></div></td>\n" +
                "\t\t\t\t<td class=\"rt_no_border\">\n" +
                "\t\t\t\t<a href=\"/zc/xyo_1576208.html\" target=\"_blank\">析</a>&nbsp;\n" +
                "\t\t\t\t<a href=\"/zc/xyo_1576208_yazhi.html\" target=\"_blank\">亚</a>&nbsp;\n" +
                "\t\t\t\t<a href=\"/zc/xyo_1576208_ouzhi.html\" target=\"_blank\">欧</a>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr class=\"otr_bg jq_match_matchId_1583350_tr jq_match_tr jq_match_leagueId_38_tr jq_match_status_-1_tr\" id=\"jq_match_1583350_tr\">\n" +
                "\t\t\t\t<td>\n" +
                "\t\t\t\t\t<input type=\"checkbox\" id=\"jq_1583350\" class=\"jq_selectmatch input\" checked=\"checked\">\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class=\"txtbbb xx_bg_weekIndex\" id=\"jq_matchindex_1583350_td\">周四105</td>\n" +
                "\t\t\t\t<td style=\"color:#fff; background:#006633\" id=\"jq_league_1583350_td\" status=\"0\"><a href=\"http://league.aicai.com/league/38/\" style=\"color:#fff;\" target=\"_blank\">西甲</a></td>\n" +
                "\t\t\t\t<td>\n" +
                "\t\t\t\t<span id=\"jq_league_matchTime_1583350\">01-04 04:30</span>\n" +
                "\t\t\t\t<span id=\"jq_league_starttime_1583350\" style=\"display:none;\">05:31</span>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class=\"duiz_box\">\n" +
                "\t\t\t\t\t<span class=\"left_line\">\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_hostredcard_1583350\" class=\"red_card_num jq_redcard\" title=\"红牌\" style=\"display:none;\">0</s>\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_hostyellowcard_1583350\" class=\"yellow_card_num jq_yellowcard\" title=\"黄牌\" style=\"display: none;\">2</s>\n" +
                "\t\t\t\t\t\t<span title=\"球队排名\" class=\"gray_11 jq_rank\" id=\"jq_hostrank_1583350\">\n" +
                "\t\t\t\t\t\t[18]\n" +
                "\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t<span id=\"jq_match_hostteam_1583350_span\"><a href=\"http://league.aicai.com/team/132/\" target=\"_blank\">比利亚雷</a></span>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t<span class=\"vs\">\n" +
                "\t\t\t\t\t\t\t<a id=\"jq_timelyscore_1583350\" class=\"wcbf_color\">2:2</a>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t<span class=\"right_line\">\n" +
                "\t\t\t\t\t\t<span id=\"jq_match_guestteam_1583350_span\"><a href=\"http://league.aicai.com/team/109/\" target=\"_blank\">皇马</a></span>\n" +
                "\t\t\t\t\t\t<span title=\"球队排名\" class=\"gray_11 jq_rank\" id=\"jq_guestrank_1583350\">\n" +
                "\t\t\t\t\t\t[4]\n" +
                "\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_guestredcard_1583350\" class=\"red_card_num jq_redcard\" title=\"红牌\" style=\"display:none;\">0</s>\n" +
                "\t\t\t\t\t\t\t<s id=\"jq_guestyellowcard_1583350\" class=\"yellow_card_num jq_yellowcard\" title=\"黄牌\" style=\"display: none;\">2</s>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t<span class=\"time_box\">\n" +
                "\t\t\t\t\t<span class=\"time_wc\">\n" +
                "\t\t\t\t\t\t<span id=\"jq_status_1583350\" rel=\"-1\">完场</span>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t</span> \n" +
                "\t\t\t\t<span title=\"查看比赛进程\" class=\"s_h_h jq_matchdetail_control jq_1583350_control\" id=\"jq_1583350_control\"></span>                   \n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class=\"expertsNumTd\">\n" +
                "\t\t\t\t\t\t\t<a target=\"_blank\" href=\"https://yq.aicai.com/matchPlanDetail/1583350-1?agentId=2335103\"><span class=\"red\">255</span>位专家推荐</a>\t\t\t\t\t\t\t\n" +
                "\t\t\t\t</td>                    \n" +
                "\t\t\t\t<td id=\"jq_halfscore_1583350\">\n" +
                "\t\t\t\t<span class=\"red\">1:2</span>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td id=\"jq_rangqiu_1583350\" letpoint=\"1\"><div class=\"tdDiv\"><p style=\"border-bottom: 1px solid #DDDDDD;\">0</p><p>1</p></div></td>\n" +
                "\t\t\t\t<td class=\"txtddd\"><div class=\"tdDiv\"><p style=\"border-bottom: 1px solid #DDDDDD;\"><i id=\"jq_winOdds_1583350\">4.40</i>|<i id=\"jq_drowOdds_1583350\" style=\"background-color: rgb(218, 175, 2); color: white;\">3.85</i>|<i id=\"jq_loseOdds_1583350\">1.56</i></p><p><i id=\"jq_winOdds_let_1583350\" style=\"background-color: rgb(21, 110, 202); color: white;\">2.05</i>|<i id=\"jq_drowOdds_let_1583350\">3.55</i>|<i id=\"jq_loseOdds_let_1583350\">2.78</i></p></div></td>\n" +
                "\t\t\t\t<td class=\"rt_no_border\">\n" +
                "\t\t\t\t<a href=\"/zc/xyo_1583350.html\" target=\"_blank\">析</a>&nbsp;\n" +
                "\t\t\t\t<a href=\"/zc/xyo_1583350_yazhi.html\" target=\"_blank\">亚</a>&nbsp;\n" +
                "\t\t\t\t<a href=\"/zc/xyo_1583350_ouzhi.html\" target=\"_blank\">欧</a>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t</tr>\n" +
                "\t</tbody>\n" +
                "\n" +
                "</table>";

//        Document doc = Jsoup.parse(html);
//        Elements table = doc != null ? doc.select("tbody:eq(2)") : null;
////        Element table = doc.getElementById("jq_jsbf_body");
//        // 使用选择器选择该table内所有的<tr> <tr/>
//        Elements trs = table != null ? table.select("tr") : null;
//        List<ScoreDO> scoreDOS = new ArrayList<>();
//        //遍历该表格内的所有的<tr> <tr/>
//        if (trs != null) {
//            for (Element tr : trs) {
//                ScoreDO scoreDO = new ScoreDO();
//                scoreDO.setBetId(IdWorkerInstance.getId());
//                // 获取一个tr
//                // 获取该行的所有td节点
//                Elements tds = tr.select("td");
//                // 选择某一个td节点
//                for (Element ignore : tds) {
//                    // 获取td节点的所有div
//                    //获取比赛周次
//                    String betWeek = tds.get(1).text();
//                    scoreDO.setBetWeek(betWeek);
//                    //比赛赛事(英超)
//                    String betLeague = tds.get(2).text();
//                    scoreDO.setBetLeague(betLeague);
//                    Elements spans3 = tds.get(3).select("span");
//                    for (Element ignored : spans3) {
//                        String betTime = spans3.get(0).text();
//                        String startTime = spans3.get(1).text();
//                        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
//                        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm");
//                        try {
//                            Date betTimeParse = format.parse(betTime);
//                            //matchTime
//                            Date startTimeParse = format2.parse(startTime);
//                            scoreDO.setBetTime(betTimeParse);
//                            //startTime
//                            scoreDO.setStartTime(startTimeParse);
//                        } catch (ParseException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    //主队信息hostTeam
//                    Elements spans4 = tds.get(4).select("span");
//                    for (Element ignoring : spans4) {
//                        Elements ss = spans4.get(0).select("s");
//                        for (Element ignored : ss) {
//                            //主队红牌
//                            boolean hasAttr = ss.get(0).hasAttr("style");
//                            if (hasAttr) {
//                                scoreDO.setHostRedCard(0);
//                            } else {
//                                String hostRedCard = ss.get(0).text();
//                                scoreDO.setHostRedCard(Integer.valueOf(hostRedCard.trim()));
//                            }
//                            boolean hasAttr2 = ss.get(1).hasAttr("style");
//                            if (hasAttr2) {
//                                scoreDO.setHostYellowCard(0);
//                            } else {
//                                //主队黄牌
//                                String hostYellowCard = ss.get(1).text();
//                                scoreDO.setHostYellowCard(Integer.valueOf(hostYellowCard.trim()));
//                            }
//                        }
//                        //主队排名
//                        String hostRank = spans4.get(1).text();
//                        String replaceAll = hostRank.trim().replace("[", "");
//                        String replace = replaceAll.replace("]", "");
//                        scoreDO.setHostRank(Integer.valueOf(replace.trim()));
//                        //主队名车
//                        String hostTeam = spans4.get(2).text();
//                        scoreDO.setHostTeam(hostTeam);
//                        //完场比分
//                        String betScore = spans4.get(3).text();
//                        scoreDO.setBetScore(betScore);
//                        Elements select = spans4.get(4).select("s");
//                        for (Element ignored : select) {
//                            //客队红牌
//                            boolean style = select.get(0).hasAttr("style");
//                            if (style) {
//                                scoreDO.setGuestRedCard(0);
//                            } else {
//                                String guestRedCard = select.get(0).text();
//                                scoreDO.setGuestRedCard(Integer.valueOf(guestRedCard.trim()));
//                            }
//                            boolean style2 = select.get(1).hasAttr("style");
//                            if (style2) {
//                                scoreDO.setGuestYellowCard(0);
//                            } else {
//                                //客队黄牌
//                                String guestYellowCard = select.get(1).text();
//                                scoreDO.setGuestYellowCard(Integer.valueOf(guestYellowCard.trim()));
//                            }
//                        }
//                        //客队排名
//                        String guestRank = spans4.get(6).text();
//                        String replaceAll2 = guestRank.trim().replace("[", "");
//                        String replace2 = replaceAll2.replace("]", "");
//                        scoreDO.setGuestRank(Integer.valueOf(replace2.trim()));
//                        //客队名车
//                        String guestTeam = spans4.get(5).text();
//                        scoreDO.setGuestTeam(guestTeam);
//                    }
//                    //半场比分
//                    String betHalf = tds.get(6).select("span").get(0).text();
//                    scoreDO.setBetScoreHalf(betHalf);
//                    Elements elements = tds.get(7).select("div").select("p");
//                    for (Element ignored : elements) {
//                        //平手
//                        String drawBall = elements.get(0).text();
//                        scoreDO.setDrawBall(Integer.valueOf(drawBall.trim()));
//                        //让q
//                        String letBall = elements.get(1).text();
//                        scoreDO.setLetBall(Integer.valueOf(letBall.trim()));
//                    }
//                    Elements ps = tds.get(8).select("div").select("p");
//                    for (Element ignored : ps) {
//                        Elements is = ps.get(0).select("i");
//                        for (Element ignor : is) {
//                            //平主队
//                            String drawWinOdds = is.get(0).text();
//                            scoreDO.setDrawWinOdds(drawWinOdds);
//                            //平平
//                            String drawDrowOdds = is.get(1).text();
//                            scoreDO.setDrawDrowOdds(drawDrowOdds);
//                            //平客
//                            String drawLoseOdds = is.get(2).text();
//                            scoreDO.setDrawLoseOdds(drawLoseOdds);
//
//                            //设置打出属性
//                            if(is.get(0).hasAttr("style")){
//                                scoreDO.setDrawActive(String.valueOf(3));
//                            }else if(is.get(1).hasAttr("style")){
//                                scoreDO.setDrawActive(String.valueOf(1));
//                            }else if(is.get(2).hasAttr("style")){
//                                scoreDO.setDrawActive(String.valueOf(0));
//                            }
//                        }
//                        Elements i2s = ps.get(1).select("i");
//                        for (Element ignor : i2s) {
//                            //让主
//                            String letWinOdds = i2s.get(0).text();
//                            scoreDO.setLetWinOdds(letWinOdds);
//                            //让平
//                            String letDrowOdds = i2s.get(1).text();
//                            scoreDO.setLetDrowOdds(letDrowOdds);
//                            //让客
//                            String letLoseOdds = i2s.get(2).text();
//                            scoreDO.setLetLoseOdds(letLoseOdds);
//
//                            //设置打出属性
//                            if(i2s.get(0).hasAttr("style")){
//                                scoreDO.setLetActive(String.valueOf(3));
//                            }else if(i2s.get(1).hasAttr("style")){
//                                scoreDO.setLetActive(String.valueOf(1));
//                            }else if(i2s.get(2).hasAttr("style")){
//                                scoreDO.setLetActive(String.valueOf(0));
//                            }
//                        }
//                    }
//                }
//                scoreDOS.add(scoreDO);
//            }
//            System.out.println(scoreDOS);
//        }
    }


    @GetMapping()
    @RequiresPermissions("common:score:score")
    String Score() {
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
    String add() {
        return "common/score/add";
    }

    @GetMapping("/edit/{eventId}")
    @RequiresPermissions("common:score:edit")
    String edit(@PathVariable("eventId") Long eventId, Model model) {
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
