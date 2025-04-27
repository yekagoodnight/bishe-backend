package com.easy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easy.bean.Trainer;
import com.easy.dao.ITrainerDao;
import com.easy.dao.ICourseDao;
import com.easy.dao.IMemberDao;
import com.easy.service.ITrainerService;
import com.easy.util.Page;

@Service
public class TrainerServiceImpl implements ITrainerService{

	@Autowired
	ITrainerDao trainerDao;
	@Autowired
	IMemberDao memberDao;
	@Autowired
	ICourseDao courseDao;
	@Transactional
	public Trainer editTrainer(Trainer trainer) {
		trainerDao.editTrainer(trainer);
		List<Trainer> list= trainerDao.getTrainer(trainer,new Page());
		trainer=list.get(0);
		return trainer;
	}

	@Transactional
	public Trainer addTrainer(Trainer trainer) {
		trainerDao.addTrainer(trainer);
		List<Trainer> list= trainerDao.getTrainer(trainer,new Page());
		trainer=list.get(0);
		return trainer;
	}
	@Transactional
	public List<Map<String, Integer>> getTrainerOptions() {
		List<Map<String, Integer>> trainerOptions = trainerDao.getTrainerOptions();
        return trainerOptions;
	}

	@Transactional
	@Override
	public int delTrainer(int id) {
		List list=trainerDao.getContain(id);
		if(!list.isEmpty()) {
			return 300;
		}
		trainerDao.delTrainer(id);
		return 200;
	}
}
