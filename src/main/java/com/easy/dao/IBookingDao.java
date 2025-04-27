package com.easy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import com.easy.bean.Booking;
import com.easy.util.Page;

@Mapper
public interface IBookingDao {
	int addBooking(Booking Booking);
	List<Booking> getBooking(@Param("booking") Booking Booking,@Param("page") Page page);
	int editBooking(Booking Booking);
	int delBooking(int id);
	int getMemberId(String name);
	int getCourseId(String name);
	List<Map<String, Integer>> getUserOptions();
	List<Map<String, Integer>> getCourseOptions();
}
