package com.bootdo.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.common.dao.ScoreDao;
import com.bootdo.common.domain.ScoreDO;
import com.bootdo.common.service.ScoreService;

/**
 * @author Administrator
 */
@Service
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	private ScoreDao scoreDao;
	
	@Override
	public ScoreDO get(Long betId){
		return scoreDao.get(betId);
	}
	
	@Override
	public List<ScoreDO> list(Map<String, Object> map){
		return scoreDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return scoreDao.count(map);
	}
	
	@Override
	public int save(ScoreDO score){
		return scoreDao.save(score);
	}
	
	@Override
	public int update(ScoreDO score){
		return scoreDao.update(score);
	}
	
	@Override
	public int remove(Long betId){
		return scoreDao.remove(betId);
	}
	
	@Override
	public int batchRemove(Long[] betIds){
		return scoreDao.batchRemove(betIds);
	}

	@Override
	public int batchSave(List<ScoreDO> scoreDOS) {
		return scoreDao.batchSave(scoreDOS);
	}
}
