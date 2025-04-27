package com.easy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IDataDao {

	List<Map<String, Integer>> getUserData();

	List<Map<String, Integer>> getCourseData();
	Map<String, Integer> getIncomeByMon();
	
	Map<String, Integer> getMainByMon();
}
