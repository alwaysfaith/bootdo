package com.bootdo.common.dao;

import com.bootdo.common.domain.ScoreDataDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-01-04 14:49:08
 */
@Mapper
public interface ScoreDataDao {

	ScoreDataDO get(Long dataId);
	
	List<ScoreDataDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ScoreDataDO scoreData);
	
	int update(ScoreDataDO scoreData);
	
	int remove(Long data_id);
	
	int batchRemove(Long[] dataIds);
}
