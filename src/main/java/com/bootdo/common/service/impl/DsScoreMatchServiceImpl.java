package com.bootdo.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.common.dao.DsScoreMatchDao;
import com.bootdo.common.domain.DsScoreMatchDO;
import com.bootdo.common.service.DsScoreMatchService;



@Service
public class DsScoreMatchServiceImpl implements DsScoreMatchService {
	@Autowired
	private DsScoreMatchDao dsScoreMatchDao;
	
	@Override
	public DsScoreMatchDO get(Long id){
		return dsScoreMatchDao.get(id);
	}
	
	@Override
	public List<DsScoreMatchDO> list(Map<String, Object> map){
		return dsScoreMatchDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return dsScoreMatchDao.count(map);
	}
	
	@Override
	public int save(DsScoreMatchDO dsScoreMatch){
		return dsScoreMatchDao.save(dsScoreMatch);
	}
	
	@Override
	public int update(DsScoreMatchDO dsScoreMatch){
		return dsScoreMatchDao.update(dsScoreMatch);
	}
	
	@Override
	public int remove(Long id){
		return dsScoreMatchDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return dsScoreMatchDao.batchRemove(ids);
	}
	
}
