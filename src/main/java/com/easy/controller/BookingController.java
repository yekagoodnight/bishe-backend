package com.easy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.easy.bean.Booking;
import com.easy.bean.Booking;
import com.easy.common.CommonResult;
import com.easy.dao.IBookingDao;
import com.easy.service.IBookingService;
import com.easy.util.Page;




@RestController
@RequestMapping("booking")
public class BookingController {
	
	@Autowired
	private IBookingDao dao;
	@Autowired
	private IBookingService service;
	
	@PostMapping
	public CommonResult addMemberCourseBooking(Booking memberCourseBooking) {
		Object result=service.addBooking(memberCourseBooking);
		return CommonResult.success(result);
	}
	
	@DeleteMapping("{id}")
	public CommonResult delMemberCourseBooking(@PathVariable int id) {
		Object result=dao.delBooking(id);
		return CommonResult.success(result);
	}
	@PutMapping
	public CommonResult editMemberCourseBooking(Booking memberCourseBooking) {
		Object result=service.editBooking(memberCourseBooking);
		return CommonResult.success(result);
	}
	@GetMapping
	public CommonResult getMemberCourseBooking(Booking memberCourseBooking,Page page) {
		Object result=dao.getBooking(memberCourseBooking,page);
		return CommonResult.success(result);
	}
	@GetMapping("/useroptions")
	public CommonResult getUserOptions() {
		Object result=service.getUserOptions();
	    return CommonResult.success(result);
	}
	@GetMapping("/courseoptions")
	public CommonResult getCourseOptions() {
		Object result=service.getCourseOptions();
	    return CommonResult.success(result);
	}
}
