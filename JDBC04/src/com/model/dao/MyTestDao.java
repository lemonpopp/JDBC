package com.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		System.out.println(sql);
	}
	
	public List<MyTest> selectAll(Connection con){
		
		return null;
	}
	
	
	
	public int delete(Connection con, int n) {
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement("Safd");
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
