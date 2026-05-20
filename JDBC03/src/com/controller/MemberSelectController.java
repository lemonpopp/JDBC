package com.controller;

import java.util.List;

import com.model.dto.Member;
import com.model.service.MemberService;
import com.model.service.MemberServiceImpl;

public class MemberSelectController {
	MemberService s = new MemberServiceImpl();
	public List<Member> selectAll(){
		return s.selectAll();
	}
}
