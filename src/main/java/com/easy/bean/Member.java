package com.easy.bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Member {
	private int id;
	private int user_id;
	private String startDate;
	private String endDate;
	private int points;
	private String state;
	private String user_name;
	private String user_phone;
	
	
	

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getEndDate() {
        if(endDate==null||endDate.length()==0) {
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        	LocalDateTime now = LocalDateTime.now();
        	// 计算n天后的时间
        	LocalDateTime afterNDaysFromNow = now.plusDays(points);
            endDate=afterNDaysFromNow.format(formatter);
        }
		return endDate;
	}
	
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
