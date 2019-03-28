package com.bootdo.common.dao;

import com.bootdo.common.domain.ScoreSourceDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-11 15:13:03
 */
@Mapper
public interface ScoreSourceDao {

	ScoreSourceDO get(Long ssId);
	
	List<ScoreSourceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ScoreSourceDO scoreSource);
	
	int update(ScoreSourceDO scoreSource);
	
	int remove(Long ssId);
	
	int batchRemove(Long[] ssIds);
}
