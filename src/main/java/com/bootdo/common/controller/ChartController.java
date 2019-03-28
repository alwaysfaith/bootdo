package com.bootdo.common.controller;

import com.sf.system.domain.UserinfoDO;
import com.sf.system.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author cx
 * @date 2018/7/1711:18
 */
@Controller
@RequestMapping("/sys/chart")
public class ChartController {


    @Autowired
    private ChartService chartService;

    @GetMapping()
    public String getCountry(Model model) {
        List<UserinfoDO> country = chartService.getCountry();
        model.addAttribute("chartCountry", country);
        return "system/chart/echart";
    }

    @PostMapping("/gender")
    @ResponseBody
    public List getGender(String countryGender) {
        return chartService.getGender(countryGender);
    }


    @PostMapping("/single")
    @ResponseBody
    public String getSingle() {
        return chartService.getSingle();
    }

    @PostMapping("/age")
    @ResponseBody
    public List getAge(String countryGender) {
        return chartService.getAge(countryGender);
    }
}
