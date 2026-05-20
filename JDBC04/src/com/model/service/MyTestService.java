package com.model.service;

import java.sql.Connection;

import com.model.dao.MyTestDao;

import static common.JDBCTemplate.*;

public class MyTestService {
	MyTestDao dao = new MyTestDao();
	
	
	public int delete(int n) {
		Connection con = getConnection();
		int res =dao.delete(con,n);
		return 0;
	}
}
