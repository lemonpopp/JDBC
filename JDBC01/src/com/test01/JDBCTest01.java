package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest01 {
	public static void main(String[] 	args) throws ClassNotFoundException, SQLException {
		//1. 드라이버 등록
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//ex) 다른 dbms - com.cj.mysql.jdbc.Driver
		
		//2. dbms 연결
		//	Connection 객체 생성
		//url,id,pw 값 필요
		String url = "jdbc:oracle:thin:@localhost:1521/orcl";
		String id = "MULTI";
		String pw = "MULTI";
		Connection con = DriverManager.getConnection(url,id,pw);
		
		//3. sql 실행 및 결과 처리
		String sql = " SELECT * FROM EMPLOYEE JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID) ";
		Statement stmt = con.createStatement();
		
		//sql 실행
		ResultSet rs = stmt.executeQuery(sql);
		
		//결과 처리
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+'\t'+rs.getInt("SALARY")+'\t'+rs.getString("DEPT_TITLE"));
		}
		//4. 종료
		rs.close();
		stmt.close();
		con.close();
	}

}
