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

import com.easy.bean.Course;
import com.easy.bean.Course;
import com.easy.common.CommonResult;
import com.easy.dao.ICourseDao;
import com.easy.service.ICourseService;
import com.easy.util.Page;




@RestController
@RequestMapping("course")
public class CourseController {
	
	@Autowired
	private ICourseDao dao;
	@Autowired
	private ICourseService service;
	
	@PostMapping
	public CommonResult addCourse(Course course) {//@RequestBody 
		Object result=service.addCourse(course);
		return CommonResult.success(result);
	}
	
	@DeleteMapping("{id}")
	public CommonResult delCourse(@PathVariable int id) {
		int result=service.delCourse(id);
		if(result==200) {
			return CommonResult.success(result);
		}
		else {
			return CommonResult.fail(300, "该课程还有用户预定记录");
		}
	}
	@PutMapping
	public CommonResult editCourse(Course course) {//@RequestBody 
		Object result=service.editCourse(course);
		return CommonResult.success(result);
	}
	@GetMapping
	public CommonResult getCourse(Course course,Page page) {//@RequestBody  
		Object result=dao.getCourse(course,page);
		return CommonResult.success(result);
	}
	@GetMapping("/useroptions")
	public CommonResult getUserOptions() {
		Object result=service.getUserOptions();
	    return CommonResult.success(result);
	}
}
