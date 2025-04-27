package com.easy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easy.bean.Member;
import com.easy.bean.Trainer;
import com.easy.bean.User;
import com.easy.dao.IMemberDao;
import com.easy.dao.IUserDao;
import com.easy.service.IMemberService;
import com.easy.util.Page;
@Service
public class MemberServiceImpl implements IMemberService{

	@Autowired
	IMemberDao memberDao;
	@Autowired
	IUserDao userDao;
	@Transactional
	public Member editMember(Member member) {
		
		memberDao.editMember(member);
		List<Member> list= memberDao.getMember(member,new Page());
		member=list.get(0);
		return member;
		
	}
	@Transactional
	public List<Map<String, Integer>> getMemberOptions() {
		List<Map<String, Integer>> memberOptions = memberDao.getMemberOptions();
        return memberOptions;
	}
	@Transactional
	@Override
	public int delMember(int id) {
		List list=memberDao.getContain(id);
		if(!list.isEmpty()) {
			return 300;
		}
		memberDao.delMember(id);
		return 200;
	}
}
