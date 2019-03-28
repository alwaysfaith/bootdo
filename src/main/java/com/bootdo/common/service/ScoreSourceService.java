package com.bootdo.common.service;

import com.bootdo.common.domain.ScoreSourceDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-11 15:13:03
 */
public interface ScoreSourceService {
	
	ScoreSourceDO get(Long ssId);
	
	List<ScoreSourceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ScoreSourceDO scoreSource);
	
	int update(ScoreSourceDO scoreSource);
	
	int remove(Long ssId);
	
	int batchRemove(Long[] ssIds);
}
