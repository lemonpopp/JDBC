package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	//1.연결
	public static Connection getConnection() {
		//드라이버 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] 드라이버 등록 실패");
			e.printStackTrace();
		}
		
		//연결
		String url = "jdbc:oracle:thin:@localhost:1521/orcl";
		String id = "MULTI";
		String pw = "MULTI";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url,id,pw);
			
			con.setAutoCommit(false);
			//자동커밋X
		} catch (SQLException e) {
			System.out.println("[Error] 오라클 연결 실패");
			e.printStackTrace();
		}
		
		return con;
	}
	
	//2.해제
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("[Error] con close 실패");
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			System.out.println("[Eroor] stmt close 실패");
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			System.out.println("[Error] rs close 실패");
			e.printStackTrace();
		}
	}
	
	
	
	
}
