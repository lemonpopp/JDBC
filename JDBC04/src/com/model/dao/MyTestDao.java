package com.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.model.dto.MyTest;

import static common.JDBCTemplate.*;

public class MyTestDao {
	Properties prop;
	
	public MyTestDao() {
		prop = new Properties();
		try {
			prop.load(new FileReader("src/common/sql.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String sql = prop.getProperty("selectAll");
	}
	
	public List<MyTest> selectAll(Connection con){
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MyTest> res = new ArrayList<>();
		
		String sql = prop.getProperty("selectAll");
		
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				MyTest tmp = new MyTest();
				tmp.setMno(rs.getInt(1));
				tmp.setMname(rs.getString(2));
				tmp.setNickname(rs.getString(3));
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
	
	public MyTest selectOne(Connection con, int n) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyTest res = null;
		
		String sql = prop.getProperty("selectOne");

		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, n);
			rs = pstm.executeQuery();
			while(rs.next()) {
				res = new MyTest();
				res.setMno(rs.getInt(1));
				res.setMname(rs.getString(2));
				res.setNickname(rs.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
		}
		return res;
	}
	
	public int insert(Connection con, MyTest m) {
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = prop.getProperty("insert");

		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, m.getMname());
			pstm.setString(2, m.getNickname());
			res = pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		return res;
	}
	
	public int update(Connection con, MyTest m) {
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = prop.getProperty("update");
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, m.getMname());
			pstm.setString(2, m.getNickname());
			pstm.setInt(3, m.getMno());
			res = pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		return res;
	}
	
	public int delete(Connection con, int n) {
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = prop.getProperty("delete");

		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, n);
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		
		return res;
	}
	
}
