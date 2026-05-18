package com.test01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static common.JDBCTemplate.*;


public class JDBCTest04 {

	public static void main(String[] args) {
		/*
		 * Employee 테이블에서
		 * 급여가 350만원 이상, 550만원 이하인 직원의
		 * 사번, 사원명, 부서코드, 직급코드, 급여를 조회
		 * 단, 급여 내림차순으로 조회
		 * 단, JDBCTemplte을 이용하여 구현
		 */
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY FROM EMPLOYEE WHERE SALARY >= 3500000 AND SALARY <= 5500000 ORDER BY SALARY DESC";
		
		con = getConnection();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
		}
		
		
	}

}
