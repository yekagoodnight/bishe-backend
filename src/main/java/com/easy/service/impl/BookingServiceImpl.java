package com.easy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easy.bean.Booking;
import com.easy.dao.IBookingDao;
import com.easy.dao.ICourseDao;
import com.easy.dao.IMemberDao;
import com.easy.service.IBookingService;
import com.easy.util.Page;

@Service
public class BookingServiceImpl implements IBookingService{

	@Autowired
	IBookingDao bookingDao;
	@Autowired
	IMemberDao memberDao;
	@Autowired
	ICourseDao courseDao;
	
	@Transactional
	public Booking editBooking(Booking booking) {
		//修改之前
		Booking before_booking=new Booking();
		before_booking.setId(booking.getId());
		List<Booking> list=bookingDao.getBooking(before_booking,new Page());
		Booking booking_data=list.get(0);
		//修改之后
		bookingDao.editBooking(booking);
		list=bookingDao.getBooking(booking,new Page());
		booking=list.get(0);
		
		if(booking_data.getCourse_id()!=booking.getCourse_id()) {
			courseDao.reduceNum(booking_data.getCourse_id());
			courseDao.addNum(booking.getCourse_id());
		}

		return booking;
	}
	@Transactional
	public Booking addBooking(Booking booking) {
		bookingDao.addBooking(booking);
		List<Booking> list=bookingDao.getBooking(booking,new Page());
		booking=list.get(0);
		courseDao.addNum(booking.getCourse_id());
		return booking;
	}

	@Transactional
	public List<Map<String, Integer>> getUserOptions() {
		List<Map<String, Integer>> userOptions = bookingDao.getUserOptions();
        return userOptions;
	}
	@Transactional
	public List<Map<String, Integer>> getCourseOptions() {
		List<Map<String, Integer>> courseOptions = bookingDao.getCourseOptions();
        return courseOptions;
	}
	@Transactional
	public int delBooking(int id) {
		Booking booking=new Booking();
		booking.setId(id);
		List<Booking> list=bookingDao.getBooking(booking,new Page());
		booking=list.get(0);
		bookingDao.delBooking(id);
		courseDao.reduceNum(booking.getCourse_id());
		return 0;
	}

}
