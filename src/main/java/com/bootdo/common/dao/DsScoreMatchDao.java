package com.bootdo.common.dao;

import com.bootdo.common.domain.DsScoreMatchDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author Caixin
 * @email 1992lcg@163.com
 * @date 2019-08-08 13:51:06
 */
@Mapper
public interface DsScoreMatchDao {

	DsScoreMatchDO get(Long id);
	
	List<DsScoreMatchDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DsScoreMatchDO dsScoreMatch);
	
	int update(DsScoreMatchDO dsScoreMatch);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
