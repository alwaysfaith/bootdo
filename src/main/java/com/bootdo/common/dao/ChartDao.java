//package com.bootdo.common.dao;
//
//import com.sf.system.domain.UserinfoDO;
//import com.sf.system.vo.ChartSexVO;
//import com.sf.system.vo.SeriesVO;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
///**
// * @author cx
// * @date 2018/7/1714:41
// */
//@Mapper
//@Repository
//public interface ChartDao {
//
//    /**
//     * 获取大区列表
//     *
//     * @return List<UserinfoDO>
//     */
//    List<UserinfoDO> getCountry();
//
//    /**
//     * 获取男女比例
//     *
//     * @param countryGender
//     * @return List
//     */
//    List<ChartSexVO> getGender(@Param("countryGender") String countryGender);
//
//    /**
//     * 查询大区，男女总人数
//     *
//     * @return List<SeriesVO>
//     */
//    List<SeriesVO> getSingle();
//
//    /**
//     * 获取出生年龄比例
//     *
//     * @param countryGender
//     * @return List
//     */
//    List<ChartSexVO> getAge(@Param("countryGender") String countryGender);
//
//}
