package com.controller;

import java.util.List;

import com.model.dto.Member;
import com.model.service.MemberService;
import com.model.service.MemberServiceImpl;

public class MemberController {
	private MemberService service = new MemberServiceImpl();
	
	public List<Member> selectAll(){
		return service.selectAll();
	}
	
	public Member selectOne(int no) {
		return service.selectOne(no);
	}
	
	public int insert(Member m) {
		return service.insert(m);
	}
	
	public int update(Member m) {
		return service.update(m);
	}
	
	public int delete(int no) {
		return service.delete(no);
	}
	
}
