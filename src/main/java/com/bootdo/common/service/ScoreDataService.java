package com.bootdo.common.service;

import com.bootdo.common.domain.ScoreDataDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-01-04 14:49:08
 */
public interface ScoreDataService {
	
	ScoreDataDO get(Long dataId);
	
	List<ScoreDataDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ScoreDataDO scoreData);
	
	int update(ScoreDataDO scoreData);
	
	int remove(Long dataId);
	
	int batchRemove(Long[] dataIds);
}
