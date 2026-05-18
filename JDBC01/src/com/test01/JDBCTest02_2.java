package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest02_2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//jdbc를 이용하여
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521/orcl";
		String id = "MULTI";
		String pw ="MULTI";
		Connection con = DriverManager.getConnection(url,id,pw);
		
		//[1]
		//department 테이블 전체 조회하여
		//출력문을 이용하여 확인
		/*
		 	SELECT * FROM DEPARTMENT
		 */
//		String sql = "SELECT * FROM DEPARTMENT";
//		
//		Statement stmr = con.createStatement();
//		
//		ResultSet rs = stmr.executeQuery(sql);
//		
//		while(rs.next()){
//			System.out.println(rs.getString(1)+" : " + rs.getString(2)+" : "+rs.getString("LOCATION_ID"));
//		}
		
		//[2]
		
		//EMPLOYEE테이블에서
		//'해외영업1부'에 근무하는 모든 사원의
		//평균급여, 가장높은급여, 가장낮은급여, 급여합 조회
		//출력문을 이용하여 조회
		/*
		 	SELECT AVG(SALARY), MAX(SALARY), MIN(SALARY), SUM(SALARY)
		 	FROM EMPLOYEE
		 	WHERE DEPT_CODE = 'D5'
		 */
		
//		String sql = "SELECT DEPT_TITLE, FLOOR(AVG(SALARY)), MAX(SALARY), MIN(SALARY), SUM(SALARY) FROM EMPLOYEE JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) WHERE DEPT_CODE = 'D5' GROUP BY DEPT_TITLE";
		
		String sql = " SELECT AVG(SALARY), MAX(SALARY), MIN(SALARY), SUM(SALARY) " +
				     " FROM EMPLOYEE " +
				     " WHERE DEPT_CODE = 'D5'";
		
		Statement stmr = con.createStatement();
		
		ResultSet rs = stmr.executeQuery(sql);
		
		while(rs.next()){
			System.out.println(rs.getDouble(1)+"\t"+rs.getInt(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t");
		};
		
		
		//4. db 종료
		rs.close();
		stmr.close();
		con.close();
	}

}
