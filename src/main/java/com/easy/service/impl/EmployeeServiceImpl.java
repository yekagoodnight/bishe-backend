package com.easy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easy.bean.Employee;
import com.easy.bean.Member;
import com.easy.bean.Trainer;
import com.easy.bean.User;
import com.easy.dao.ITrainerDao;
import com.easy.dao.IUserDao;
import com.easy.dao.ICourseDao;
import com.easy.dao.IEmployeeDao;
import com.easy.dao.IMemberDao;
import com.easy.service.IEmployeeService;
import com.easy.service.ITrainerService;
import com.easy.util.Page;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	IEmployeeDao dao;
	@Autowired
	IUserDao userDao;
	@Transactional
	public Employee editEmployee(Employee employee) {
		dao.editEmployee(employee);
		List<Employee> list= dao.getEmployee(employee, new Page());
		employee=list.get(0);
		return employee;
		
	}
	@Transactional
	public Employee addEmployee(Employee employee) {
		dao.addEmployee(employee);
		List<Employee> list=dao.getEmployee(employee,new Page());
		employee=list.get(0);
		return employee;
	}

	@Transactional
	@Override
	public int delEmployee(int id) {
		List list=dao.getTrainContain(id);
		if(!list.isEmpty()) {
			return 301;
		}
		list=dao.getWeiContain(id);
		if(!list.isEmpty()) {
			return 302;
		}
		dao.delEmployee(id);
		return 200;
	}
	
}
