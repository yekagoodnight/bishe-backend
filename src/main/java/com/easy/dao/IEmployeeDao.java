package com.easy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.easy.bean.Employee;
import com.easy.util.Page;

@Mapper
public interface IEmployeeDao {
	int addEmployee(Employee employee);
	List<Employee> getEmployee(@Param("employee") Employee employee,@Param("page") Page page);
	int editEmployee(Employee employee);
	int delEmployee(int id);
	List<Map<String, Integer>> getEmployeeOptions();
	List<Integer> getTrainContain(int id);
	List<Integer> getWeiContain(int id);
}
