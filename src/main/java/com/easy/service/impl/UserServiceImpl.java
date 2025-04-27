package com.easy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easy.bean.User;
import com.easy.common.CommonResult;
import com.easy.dao.IUserDao;
import com.easy.service.IUserService;
import com.easy.util.DigestUtil;
import com.easy.util.JWTUtil;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao dao;
	
	
	@Transactional
	public CommonResult doLogin(User user) {
		List<User> list=dao.getUser(user);
		if(list.isEmpty())return CommonResult.fail(404, "用户不存在");
		
		User user_data=list.get(0);
		String ciphertext=user_data.getPassword();
		String password=user.getPassword();
		if(DigestUtil.equal(password, ciphertext)) {
			Map map=new HashMap<String, Object>();
			map.put("id",user_data.getId());
			map.put("phone",user_data.getPhone());
			map.put("password",user_data.getPassword());
			return CommonResult.success(JWTUtil.createToken(map));
		}else {
			return CommonResult.fail(400, "密码错误");
		}
	}
	@Transactional
	public int addUser(User user) {
		String password=user.getPassword();
		String ciphertext=DigestUtil.randomDigest(password);
		user.setPassword(ciphertext);
		return dao.addUser(user);	
	}
	@Transactional
	public List<User> getUser(User user){
		return dao.getUser(user);
	}
	@Transactional
	public int editUser(User user) {
		String password=user.getPassword();
		String ciphertext=DigestUtil.randomDigest(password);
		user.setPassword(ciphertext);
		return dao.editUser(user);
	}
	@Transactional
	public int delUser(int id) {
		return dao.delUser(id);
	}
	@Transactional
	public User getLoginer(String token) {
		Map<String, Object> map=JWTUtil.decodeJWT(token);
		int id=(Integer) map.get("id");
		User user=new User();
		user.setId(id);
		List<User> list=dao.getUser(user);
		if(!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	@Transactional
	public CommonResult confirmUser(User user) {
		List<User> list=dao.getUser(user);
		if(!list.isEmpty()) {
			User user_data=list.get(0);
			if(DigestUtil.equal(user.getPassword(), user_data.getPassword())) {
				return CommonResult.success(200, "查找成功",user_data);
			}else {
				return CommonResult.fail(400, "密码错误");
			}
		}else return CommonResult.fail(404, "用户不存在");
	}
	@Transactional
	public int changePass(User user) {
		String password=user.getPassword();
		String ciphertext=DigestUtil.randomDigest(password);
		user.setPassword(ciphertext);
		return dao.editUser(user);
		
	}
	
}
