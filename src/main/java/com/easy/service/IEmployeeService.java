package com.easy.service;

import com.easy.bean.Employee;

public interface IEmployeeService {
	Employee editEmployee(Employee Employee) ;
	Employee addEmployee(Employee Employee);
	int delEmployee(int id);
}
