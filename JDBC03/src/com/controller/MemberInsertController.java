package com.controller;

import com.model.dto.Member;
import com.model.service.MemberService;
import com.model.service.MemberServiceImpl;

public class MemberInsertController {
	MemberService s = new MemberServiceImpl();
	public int insert(Member m) {
		return s.insert(m);
	}
}
