package com.bootdo.common.service;

import com.bootdo.common.domain.ScoreDO;

import java.util.List;
import java.util.Map;

/**
 *
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-01-04 14:59:46
 */
public interface ScoreService {
	
	ScoreDO get(Long betId);
	
	List<ScoreDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ScoreDO score);
	
	int update(ScoreDO score);
	
	int remove(Long betId);
	
	int batchRemove(Long[] betIds);

	int batchSave(List<ScoreDO> scoreDOS);
}
