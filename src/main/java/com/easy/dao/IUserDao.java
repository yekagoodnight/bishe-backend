package com.easy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.easy.bean.User;

@Mapper
public interface IUserDao {
	int addUser(User user);
	List<User> getUser(User user);
	int editUser(User user);
	int delUser(int id);
	User getUserByname(String name);
}
