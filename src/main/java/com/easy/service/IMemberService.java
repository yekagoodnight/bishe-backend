package com.easy.service;

import java.util.List;
import java.util.Map;

import com.easy.bean.Member;

public interface IMemberService {
	Member editMember(Member member) ;
	List<Map<String, Integer>> getMemberOptions();
	int delMember(int id);
}
