package com.easy.service;

import java.util.List;

import com.easy.bean.User;
import com.easy.common.CommonResult;

public interface IUserService {
	int addUser(User user);
	List<User> getUser(User user);
	int editUser(User user);
	int delUser(int id);
	CommonResult doLogin(User user);
	User getLoginer(String token);
	CommonResult confirmUser(User user);
	int changePass(User user);
}
