package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//jdbc를 이용하여
		//사번, 사원명, 직급명(job_name), 부서명(dept_title), 급여, 보너스를 조회하여
		//출력문을 이용하여 확인
		
		//1.드라이버 등록
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.db연결
		String url = "jdbc:oracle:thin:@localhost:1521/orcl";
		String id = "MULTI";
		String pw = "MULTI";
		Connection con = DriverManager.getConnection(url,id,pw);
				
		//3.sql 실행 및 결과 처리
		String sql = " SELECT * FROM EMPLOYEE JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID) JOIN JOB USING (JOB_CODE) ";
		Statement stmr = con.createStatement();
		
		ResultSet rs = stmr.executeQuery(sql);
		
		while(rs.next()){
			System.out.println(rs.getInt("EMP_ID")+"\t"+rs.getString("EMP_NAME")+"\t"+rs.getString("job_name")+"\t"+rs.getString("DEPT_TITLE")+"\t"+rs.getInt("SALARY")+"\t"+rs.getDouble("BONUS"));
		};
		
		//4.종료
		rs.close();
		stmr.close();
		con.close();
	}

}
