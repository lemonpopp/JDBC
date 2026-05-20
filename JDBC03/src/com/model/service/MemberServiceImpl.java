package com.model.service;

import java.sql.Connection;
import java.util.List;

import com.model.dao.MemberDao;
import com.model.dao.MemberDaoImpl;
import com.model.dto.Member;

import static common.JDBCTemplate.*;

public class MemberServiceImpl implements MemberService {
	private MemberDao dao = new MemberDaoImpl();
	
	@Override
	public List<Member> selectAll() {
		Connection con = getConnection();
		List<Member> res = dao.selectAll(con);
		close(con);
		return res;
	}
	@Override
	public Member selectOne(int n) {
		Connection con = getConnection();
		Member res = dao.selectOne(con, n);
		close(con);
		return res;
	}
	@Override
	public int insert(Member m) {
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
	@Override
	public int update(Member m) {
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
	@Override
	public int delete(int n) {
		Connection con = getConnection();
		int res = dao.delete(con, n);
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return res;
	}

}
