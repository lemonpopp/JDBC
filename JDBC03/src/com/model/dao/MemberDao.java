package com.model.dao;

import java.sql.Connection;
import java.util.List;

import com.model.dto.Member;

public interface MemberDao {
	
	String selectAll = " SELECT * FROM MEMBER ";
	String selectOne = " SELECT * FROM MEMBER WHERE M_NO = ? ";
	String insert = " INSERT INTO MEMBER VALUES(SEQ_MEMBER.NEXTVAL, ?,?,?,?,?,?,?) ";
	String update = " UPDATE MEMBER SET M_LOCATION = ?, M_JOB = ?, M_TEL = ? WHERE M_NO = ? ";
	String delete = " DELETE MEMBER WHERE M_NO = ? ";
	
	public List<Member> selectAll(Connection con);
	public Member selectOne(Connection con, int n);
	public int insert(Connection con, Member m);
	public int update(Connection con, Member m);
	public int delete(Connection con, int n);
}
