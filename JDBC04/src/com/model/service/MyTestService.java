package com.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.model.dao.MyTestDao;
import com.model.dto.MyTest;

public class MyTestService {
	MyTestDao dao = new MyTestDao();
	
	public List<MyTest> selectAll() {
		Connection con = getConnection();
		List<MyTest> res = dao.selectAll(con);
		close(con);
		return res;
	}
	
	public MyTest selectOne(int n) {
		Connection con = getConnection();
		MyTest res = dao.selectOne(con, n);
		close(con);
		return res;
	}
	
	public int insert(MyTest m) {
		Connection con = getConnection();
		int res = dao.insert(con, m);
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return res;
	}
	
	public int update(MyTest m) {
		Connection con = getConnection();
		int res = dao.update(con, m);
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return res;
	}
	
	public int delete(int n) {
		Connection con = getConnection();
		int res =dao.delete(con,n);
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return res;
	}
}
