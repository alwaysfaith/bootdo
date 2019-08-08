package com.bootdo.common.service;

import com.bootdo.common.domain.DsScoreMatchDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author Caixin
 * @email 1992lcg@163.com
 * @date 2019-08-08 13:51:06
 */
public interface DsScoreMatchService {
	
	DsScoreMatchDO get(Long id);
	
	List<DsScoreMatchDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DsScoreMatchDO dsScoreMatch);
	
	int update(DsScoreMatchDO dsScoreMatch);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
