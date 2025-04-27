package com.easy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easy.bean.Employee;
import com.easy.common.CommonResult;
import com.easy.dao.IEmployeeDao;
import com.easy.service.IEmployeeService;
import com.easy.util.Page;




@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeDao dao;
	@Autowired
	private IEmployeeService service;
	@PostMapping
	public CommonResult addEmployee(Employee employee) {
		Object result=service.addEmployee(employee);
		return CommonResult.success(result);
	}
	@DeleteMapping("{id}")
	public CommonResult delEmployee(@PathVariable int id) {
		int result=service.delEmployee(id);
		if(result==301) {
			return CommonResult.fail(301, "该雇员仍被雇佣为教练");
		}else if(result==302) {
			return CommonResult.fail(302, "该雇员还有设备检查记录");
		}
		return CommonResult.success(result);
	}
	@PutMapping
	public CommonResult editEmployee(Employee employee) {
		Object result=service.editEmployee(employee);
		return CommonResult.success(result);
	}
	@GetMapping
	public CommonResult getEmployee(Employee employee,Page page) {
		//System.out.println(page.toString());
		Object result=dao.getEmployee(employee,page);
		return CommonResult.success(result);
	}
	@GetMapping("/employeeoptions")
	public CommonResult getUserOptions() {
		Object result=dao.getEmployeeOptions();
	    return CommonResult.success(result);
	}
	
}
