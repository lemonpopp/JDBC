package com.test01;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//insert, preparedStatement 활용
public class JDBCTest07 {
	public static void main(String[] args) {
		//준비
		Connection con = null;
		PreparedStatement pstm = null;
		
		int no = 10;
		String name = "seo";
		String nickName = "scj";
		
		//" INSERT INTO MYTEST VALUES("+num+", '"+name+"', '"+nickName+"') ";
		String sql = " INSERT INTO MYTEST VALUES(?,?,?) ";
		
		//연결
		con = getConnection();
		
		//쿼리 실행 및 결과 처리
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, no);
			pstm.setString(2, name);
			pstm.setString(3, nickName);
			//" INSERT INTO MYTEST VALUES(10,'seo','scj') "
			
			int res = pstm.executeUpdate();
			
			if(res>0) {
				System.out.println("insert 성공");
			}else {
				System.out.println("insert 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
	}

}
