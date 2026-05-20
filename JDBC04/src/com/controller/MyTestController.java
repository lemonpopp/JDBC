package com.controller;

import com.model.service.MyTestService;

public class MyTestController {
	MyTestService ser = new MyTestService();
	
	public Object doMethod(Object ... obj) {
		String req = (String)obj[0];
		if(req.equals("selectAll")) {
			
		}else if(req.equals("selectOne")) {
			
		}else if(req.equals("selectOne")) {
			
		}else if(req.equals("insert")) {
			
		}else if(req.equals("delete")) {
			int no = (int)obj[1];
			return ser.delete(no);
		}
		
		return null;
	}
	
	
	
}
