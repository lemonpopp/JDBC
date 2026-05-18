package com.test01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static common.JDBCTemplate.*;
//[INSERT]
public class JDBCTest05 {
	public static void main(String[] args) {
		//준비
		Connection con = null;
		Statement stmt = null;
		//insert 시에는 ResultSet이 필요없다
		
		
		int no = 2;
		String name = "LEE";
		String nickName = "LKO";
		// INSERT INTO MYTEST VALUES(1, 'LEMON', 'LPG');
		String sql = " INSERT INTO MYTEST VALUES("+no+", '"+name+"', '"+nickName+"') " ;
		System.out.println(sql);
		
		
		//연결
		con = getConnection();
		
		//쿼리 실행 및 결과 처리
		try {
			stmt = con.createStatement();
			
			int res = stmt.executeUpdate(sql);
				//적용된 로우의 수를 int값으로 반환
			if(res>0) {
				System.out.println("insert 성공");
			}else {
				System.out.println("insert 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(con);
		}
		
		
	}

}
