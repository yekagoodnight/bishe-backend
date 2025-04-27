package com.easy.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.easy.bean.User;
import com.easy.common.CommonResult;
import com.easy.config.EasyWebConfig;
import com.easy.service.IUserService;
import com.easy.util.EasyObjExcelListener;
import com.easy.util.JWTUtil;
import com.easy.util.UploadFileUtil;



@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private IUserService service;
	
	@GetMapping("confirm")
	public CommonResult confirmUser(User user) {
		CommonResult result=service.confirmUser(user);
		return result;
	}
	
	@PutMapping("change")
	public CommonResult changePass(User user) {
		int result=service.changePass(user);
		
		if(result>0) {
			return CommonResult.success();
		}
		return CommonResult.fail();
	}
	
	@PostMapping("useimg")
	public CommonResult UseImg(@RequestParam("file")MultipartFile file) {
		//存储文件
		System.out.println(file);
		String newName=UploadFileUtil.uploadfile(file);
		System.out.println(newName);
		//将文件地址存入数据库
		//返回上传文件地址or返回上传头像用户
		return CommonResult.success(EasyWebConfig.STATIC_PATH+newName);
	}
	
	@PostMapping("/login")
	public CommonResult doLogin(User user) {
		CommonResult result=service.doLogin(user);
		return result;
		
	}
	@GetMapping("getlogin")
	public CommonResult getLoginer(@RequestParam String token) {
		User user=service.getLoginer(token);
		return CommonResult.success(user);
	}
	
	@GetMapping("islogin")
	public CommonResult isLogin(HttpServletRequest request) {
		String token=request.getHeader("Authorization");
		if(token!=null&&JWTUtil.verifyToken(token)) {
			return CommonResult.success(200,"验证成功");
		}
		return CommonResult.fail();
	}
	@PutMapping("upimg")
	public CommonResult UpUserImg(User user) {
		Object result=service.editUser(user);
		return CommonResult.success(result);
	}
	@PostMapping
	public CommonResult addUser(User user) {
		Object result=service.addUser(user);
		return CommonResult.success(result);
	}
	@DeleteMapping("{id}")
	public CommonResult delUser(@PathVariable int id) {
		Object result=service.delUser(id);
		return CommonResult.success(result);
	}
	@PutMapping
	public CommonResult editUser(User user) {
		Object result=service.editUser(user);
		return CommonResult.success(result);
	}
	@GetMapping
	public CommonResult getUser(User user) {
		Object result=service.getUser(user);
		return CommonResult.success(result);
	}
	
	
}
