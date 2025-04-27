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

import com.easy.bean.Trainer;
import com.easy.common.CommonResult;
import com.easy.dao.ITrainerDao;
import com.easy.service.ITrainerService;
import com.easy.util.Page;




@RestController
@RequestMapping("trainer")
public class TrainerController {
	
	@Autowired
	private ITrainerDao dao;
	@Autowired
	private ITrainerService service;
	
	@PostMapping
	public CommonResult addTrainer(Trainer trainer) {
		Object result=service.addTrainer(trainer);
		return CommonResult.success(result);
	}
	@DeleteMapping("{id}")
	public CommonResult delTrainer(@PathVariable int id) {
		int result=service.delTrainer(id);
		if(result==200) {
			return CommonResult.success(result);
		}
		else {
			return CommonResult.fail(300, "该教练还有关联课程");
		}
	}
	@PutMapping
	public CommonResult editTrainer(Trainer trainer) {
		Object result=service.editTrainer(trainer);
		return CommonResult.success(result);
	}
	@GetMapping
	public CommonResult getTrainer(Trainer trainer,Page page) {
		Object result=dao.getTrainer(trainer,page);
		return CommonResult.success(result);
	}
	@GetMapping("/traineroptions")
	public CommonResult getUserOptions() {
		Object result=service.getTrainerOptions();
	    return CommonResult.success(result);
	}
	
}
