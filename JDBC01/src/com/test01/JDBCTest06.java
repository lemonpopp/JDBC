package com.test01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static common.JDBCTemplate.*;

public class JDBCTest06 {
	public static void main(String[] args) {
		//[1]
		//Scanner 이용해서 번호,이름,별명을 입력받아
		//MYTEST에 저장
		//insert();
		
		//[2]
		//저장 후 MYTEST 테이블에 저장된 데이터를
		//조회하여 Console에 출력
		//select();
		
		Scanner sc = new Scanner(System.in);
		int no =0;
		do {
			System.out.println("---메뉴---");
			System.out.println("1. 추가");
			System.out.println("2. 조회");
			System.out.println("3. 종료");
			System.out.print("번호 입력: ");
			no = sc.nextInt();
			
			switch(no) {
			case 1:
				insert();
				break;
			case 2:
				select();
				break;
			case 3:
				System.out.println("프로그램 종료");
				return;
			}
			
		}while(true);
		
		
	}
	public static void insert() {
		Scanner sc = new Scanner(System.in);
		System.out.print("번호를 입력하세요 : ");
		int num = sc.nextInt();
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();
		System.out.print("별칭을 입력하세요 : ");
		String nickName = sc.next();
		
		Connection con = null;
		Statement stmt = null;
		
		String sql = " INSERT INTO MYTEST VALUES("+num+", '"+name+"', '"+nickName+"') ";

		//연결
		con = getConnection();
		
		try {
			//쿼리 실행 및 결과 처리
			stmt = con.createStatement();
			int res = stmt.executeUpdate(sql);
			
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
	
	public static void select() {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT * FROM MYTEST ";
		
		con = getConnection();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
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
