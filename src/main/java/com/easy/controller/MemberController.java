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

import com.easy.bean.Member;
import com.easy.bean.Member;
import com.easy.common.CommonResult;
import com.easy.dao.IMemberDao;
import com.easy.service.IMemberService;
import com.easy.util.Page;




@RestController
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private IMemberDao dao;
	@Autowired
	private IMemberService service;
	
	@PostMapping
	public CommonResult addMember(Member member) {
		Object result=dao.addMember(member);
		return CommonResult.success(member);
	}
	
	@DeleteMapping("{id}")
	public CommonResult delMember(@PathVariable int id) {
		int result=service.delMember(id);
		if(result==200) {
			return CommonResult.success(result);
		}
		else {
			return CommonResult.fail(300, "该会员还有课程");
		}
	}
	@PutMapping
	public CommonResult editMember(Member member) {
		Object result=service.editMember(member);
		return CommonResult.success(result);
	}
	@GetMapping
	public CommonResult getMember(Member member,Page page) {
		Object result=dao.getMember(member,page);
		return CommonResult.success(result);
	}
	@GetMapping("/memberoptions")
	public CommonResult getUserOptions() {
		Object result=service.getMemberOptions();
	    return CommonResult.success(result);
	}
	
}
