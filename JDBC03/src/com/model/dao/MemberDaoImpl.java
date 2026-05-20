package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.dto.Member;

import static common.JDBCTemplate.*;

public class MemberDaoImpl implements MemberDao {

	@Override
	public List<Member> selectAll(Connection con) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Member> res = new ArrayList<>();
		
		try {
			pstm = con.prepareStatement(selectAll);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Member tmp = new Member();
				tmp.setM_no(rs.getInt("M_NO"));
				tmp.setM_name(rs.getString(2));
				tmp.setM_age(rs.getInt(3));
				tmp.setM_gender(rs.getString(4));
				tmp.setM_location(rs.getString(5));
				tmp.setM_job(rs.getString(6));
				tmp.setM_tel(rs.getString(7));
				tmp.setM_email(rs.getString(8));
				res.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
		}
		return res;
	}
	@Override
	public Member selectOne(Connection con, int n) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Member res = null;
		
		try {
			pstm = con.prepareStatement(selectOne);
			pstm.setInt(1, n);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				res = new Member();
				res.setM_no(rs.getInt("M_NO"));
				res.setM_name(rs.getString(2));
				res.setM_age(rs.getInt(3));
				res.setM_gender(rs.getString(4));
				res.setM_location(rs.getString(5));
				res.setM_job(rs.getString(6));
				res.setM_tel(rs.getString(7));
				res.setM_email(rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
		}
		return res;
	}
	@Override
	public int insert(Connection con, Member m) {
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(insert);
			pstm.setString(1, m.getM_name());
			pstm.setInt(2, m.getM_age());
			pstm.setString(3, m.getM_gender());
			pstm.setString(4, m.getM_location());
			pstm.setString(5, m.getM_job());
			pstm.setString(6, m.getM_tel());
			pstm.setString(7, m.getM_email());
			res = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		
		return res;
	}
	@Override
	public int update(Connection con, Member m) {
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(update);
			pstm.setString(1, m.getM_location());
			pstm.setString(2, m.getM_job());
			pstm.setString(3, m.getM_tel());
			pstm.setInt(4, m.getM_no());
			res = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		return res;
	}
	@Override
	public int delete(Connection con, int n) {
		PreparedStatement pstm = null;
		int res = 0;
		try {
			pstm = con.prepareStatement(delete);
			pstm.setInt(1, n);
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		return res;
	}

}
