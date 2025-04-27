package com.easy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.easy.bean.Member;
import com.easy.util.Page;

@Mapper
public interface IMemberDao {
	int addMember(Member member);
	List<Member> getMember(@Param("member") Member member,@Param("page") Page page);
	int editMember(Member member);
	int delMember(int id);
	Member getMemberByUserId(int user_id);
	List<Map<String, Integer>> getMemberOptions();
	List getContain(int id);

}
