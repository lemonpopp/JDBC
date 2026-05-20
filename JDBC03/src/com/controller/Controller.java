package com.controller;

import java.util.List;

import com.model.dto.Member;
import com.model.service.MemberService;
import com.model.service.MemberServiceImpl;

public class Controller {
	MemberService s = new MemberServiceImpl();
	
	public Object doMethod(Object ... obj) {
		                    //가변인자: 메서드가 호풀될때 전달되는 인자값의 갯수를 동적으로 받는게 가능
		
		String req = (String) obj[0];
		if(req.equals("selectAll")) {
			//전체 출력
			List<Member> res = s.selectAll();
			return res;
		}else if(req.equals("selectOne")) {
			//선택 출력
			int no = (int)obj[1];
			Member res = s.selectOne(no);
			return res;
		}else if(req.equals("insert")) {
			Member m = (Member) obj[1];
			int res = s.insert(m);
			return res;
		}else if(req.equals("update")) {
			Member m = (Member)obj[1];
			int res = s.update(m);
			return res;
		}else if(req.equals("delete")) {
			int no = (int)obj[1];
			int res = s.delete(no);
			return res;
		}
		
		return null;
	}
}
