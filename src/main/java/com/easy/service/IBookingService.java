package com.easy.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.easy.bean.Booking;
import com.easy.bean.Course;
import com.easy.bean.Member;


public interface IBookingService {
	Booking editBooking(Booking Booking) ;
	Booking addBooking(Booking Booking);
	List<Map<String, Integer>> getUserOptions();
	List<Map<String, Integer>> getCourseOptions();
	int delBooking(int id);
}
