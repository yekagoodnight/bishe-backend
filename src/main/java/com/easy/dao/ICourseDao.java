package com.easy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.easy.bean.Course;
import com.easy.util.Page;

@Mapper
public interface ICourseDao {
	int addCourse(Course Course);
	List<Course> getCourse(@Param("course") Course Course,@Param("page") Page page);
	int editCourse(Course Course);
	int delCourse(int id);
	int getTrainerId(String name);
	List<Map<String, Integer>> getUserOptions();
	int reduceNum(int id);
	int addNum(int id);
	List<Integer> getContain(int id);
}
