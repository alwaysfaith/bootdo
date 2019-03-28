package com.bootdo.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.common.dao.ScoreSourceDao;
import com.bootdo.common.domain.ScoreSourceDO;
import com.bootdo.common.service.ScoreSourceService;



@Service
public class ScoreSourceServiceImpl implements ScoreSourceService {
	@Autowired
	private ScoreSourceDao scoreSourceDao;
	
	@Override
	public ScoreSourceDO get(Long ssId){
		return scoreSourceDao.get(ssId);
	}
	
	@Override
	public List<ScoreSourceDO> list(Map<String, Object> map){
		return scoreSourceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return scoreSourceDao.count(map);
	}
	
	@Override
	public int save(ScoreSourceDO scoreSource){
		return scoreSourceDao.save(scoreSource);
	}
	
	@Override
	public int update(ScoreSourceDO scoreSource){
		return scoreSourceDao.update(scoreSource);
	}
	
	@Override
	public int remove(Long ssId){
		return scoreSourceDao.remove(ssId);
	}
	
	@Override
	public int batchRemove(Long[] ssIds){
		return scoreSourceDao.batchRemove(ssIds);
	}
	
}
