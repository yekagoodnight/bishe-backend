package com.easy.service;

import com.easy.bean.Trainer;

import java.util.List;
import java.util.Map;

import com.easy.bean.Course;
import com.easy.bean.Member;


public interface ITrainerService {
	Trainer editTrainer(Trainer Trainer) ;
	Trainer addTrainer(Trainer Trainer);
	List<Map<String, Integer>> getTrainerOptions();
	int delTrainer(int id);
}
