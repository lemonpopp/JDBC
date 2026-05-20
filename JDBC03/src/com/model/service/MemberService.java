package com.model.service;

import java.util.List;

import com.model.dto.Member;

public interface MemberService {
	
	public List<Member> selectAll();
	public Member selectOne(int n);
	public int insert(Member m);
	public int update(Member m);
	public int delete(int n);
}
