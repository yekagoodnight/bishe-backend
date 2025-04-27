package com.easy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easy.bean.Course;
import com.easy.bean.Member;
import com.easy.bean.Trainer;
import com.easy.bean.User;
import com.easy.dao.ICourseDao;
import com.easy.dao.IMemberDao;
import com.easy.dao.ITrainerDao;
import com.easy.dao.IUserDao;
import com.easy.service.ICourseService;
import com.easy.util.Page;
@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	ICourseDao courseDao;
	@Autowired
	ITrainerDao trainerDao;
	@Autowired
	IUserDao userDao;
	
	@Transactional
	public Course editCourse(Course course) {
		courseDao.editCourse(course);
		List<Course> list=courseDao.getCourse(course,new Page());
		course=list.get(0);
		return course;

	}
	@Transactional
	public Course addCourse(Course course) {
		courseDao.addCourse(course);
		List<Course> list=courseDao.getCourse(course,new Page());
		course=list.get(0);
		return course;
	}
	@Transactional
	public List<Map<String, Integer>> getUserOptions() {
		List<Map<String, Integer>> userOptions = courseDao.getUserOptions();
        return userOptions;
	}
	@Transactional
	public int delCourse(int id) {
		List list=courseDao.getContain(id);
		if(!list.isEmpty()) {
			return 300;
		}
		courseDao.delCourse(id);
		return 200;
	}
}

