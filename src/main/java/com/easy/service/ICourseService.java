package com.easy.service;

import java.util.List;
import java.util.Map;

import com.easy.bean.Course;
import com.easy.bean.Member;


public interface ICourseService {
	Course editCourse(Course Course) ;
	Course addCourse(Course Course);
	List<Map<String, Integer>> getUserOptions();
	int delCourse(int id);
}
