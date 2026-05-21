package com.controller;

import java.util.List;

import com.model.dto.MyTest;
import com.model.service.MyTestService;

public class MyTestController {
	MyTestService ser = new MyTestService();
	
	public Object doMethod(Object ... obj) {
		String req = (String)obj[0];
		if(req.equals("selectAll")) {
			List<MyTest> res = ser.selectAll();
			return res;
		}else if(req.equals("selectOne")) {
			int n = (int)obj[1];
			return ser.selectOne(n);
		}else if(req.equals("insert")) {
			MyTest m = (MyTest)obj[1];
			return ser.insert(m);
		}else if(req.equals("update")) {
			MyTest m = (MyTest)obj[1];
			return ser.update(m);
		}else if(req.equals("delete")) {
			int no = (int)obj[1];
			return ser.delete(no);
		}
		
		return null;
	}
	
	
	
}
