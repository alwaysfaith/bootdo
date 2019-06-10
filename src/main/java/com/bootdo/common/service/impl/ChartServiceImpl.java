//package com.bootdo.common.service.impl;
//
//import com.alibaba.fastjson.JSONObject;
//import com.sf.system.dao.ChartDao;
//import com.sf.system.domain.UserinfoDO;
//import com.sf.system.service.ChartService;
//import com.sf.system.vo.ChartSexVO;
//import com.sf.system.vo.SeriesVO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author cx
// * @date 2018/7/1714:46
// */
//@Service
//public class ChartServiceImpl implements ChartService {
//
//    @Autowired
//    private ChartDao chartDao;
//
//    @Override
//    public List<UserinfoDO> getCountry() {
//        return chartDao.getCountry();
//    }
//
//    @Override
//    public List<ChartSexVO> getGender(String countryGender) {
//        return chartDao.getGender(countryGender);
//    }
//
//    @Override
//    public String getSingle() {
//        List<SeriesVO> seriesVOS = chartDao.getSingle();
//        List<Integer> total = new ArrayList<>();
//        List<Integer> male = new ArrayList<>();
//        List<Integer> female = new ArrayList<>();
//        List<String> xAxisData = new ArrayList<>();
//        for (SeriesVO seriesVO : seriesVOS) {
//            total.add(seriesVO.getTotal());
//            male.add(seriesVO.getMaNum());
//            female.add(seriesVO.getWoNum());
//            xAxisData.add(seriesVO.getName());
//        }
//        List<SeriesVO> singleVo = new ArrayList<>();
//
//        SeriesVO seriesVO1 = new SeriesVO();
//        seriesVO1.setData(total);
//        seriesVO1.setName("总人数");
//        seriesVO1.setType("bar");
//        SeriesVO seriesVO2 = new SeriesVO();
//        seriesVO2.setData(male);
//        seriesVO2.setName("男生");
//        seriesVO2.setType("bar");
//        SeriesVO seriesVO3 = new SeriesVO();
//        seriesVO3.setData(female);
//        seriesVO3.setName("女生");
//        seriesVO3.setType("bar");
//
//        singleVo.add(seriesVO1);
//        singleVo.add(seriesVO2);
//        singleVo.add(seriesVO3);
//
//        JSONObject jsob = new JSONObject();
//        jsob.put("xAxisData", xAxisData);
//        jsob.put("seriesList", singleVo);
//        return jsob.toString();
//    }
//
//    @Override
//    public List<ChartSexVO> getAge(String countryGender) {
//        return chartDao.getAge(countryGender);
//    }
//}
