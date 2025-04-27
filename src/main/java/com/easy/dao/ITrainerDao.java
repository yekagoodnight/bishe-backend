package com.easy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.easy.bean.Member;
import com.easy.bean.Trainer;
import com.easy.util.Page;

@Mapper
public interface ITrainerDao {

	int addTrainer(Trainer trainer);
	List<Trainer> getTrainer(@Param("trainer") Trainer trainer,@Param("page") Page page);
	int editTrainer(Trainer trainer);
	int delTrainer(int id);
	Trainer getTrainerByUserId(int user_id);
	int getEmployeeId(String name);
	List<Map<String, Integer>> getTrainerOptions();
	List<Integer> getContain(int id);
}
