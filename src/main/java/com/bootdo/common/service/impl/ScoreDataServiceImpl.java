package com.bootdo.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.common.dao.ScoreDataDao;
import com.bootdo.common.domain.ScoreDataDO;
import com.bootdo.common.service.ScoreDataService;



@Service
public class ScoreDataServiceImpl implements ScoreDataService {
	@Autowired
	private ScoreDataDao scoreDataDao;
	
	@Override
	public ScoreDataDO get(Long dataId){
		return scoreDataDao.get(dataId);
	}
	
	@Override
	public List<ScoreDataDO> list(Map<String, Object> map){
		return scoreDataDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return scoreDataDao.count(map);
	}
	
	@Override
	public int save(ScoreDataDO scoreData){
		return scoreDataDao.save(scoreData);
	}
	
	@Override
	public int update(ScoreDataDO scoreData){
		return scoreDataDao.update(scoreData);
	}
	
	@Override
	public int remove(Long dataId){
		return scoreDataDao.remove(dataId);
	}
	
	@Override
	public int batchRemove(Long[] dataIds){
		return scoreDataDao.batchRemove(dataIds);
	}
	
}
