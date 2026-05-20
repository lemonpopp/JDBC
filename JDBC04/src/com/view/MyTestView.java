package com.view;

import java.util.List;
import java.util.Scanner;

import com.controller.MyTestController;
import com.model.dto.MyTest;

public class MyTestView {
	MyTestController con = new MyTestController();
	Scanner sc = new Scanner(System.in);
	
	public void menu() {
		int no =0;
		while(no != 6) {
			System.out.println("------------");
			System.out.println("1. 전체 출력");
			System.out.println("2. 선택 출력");
			System.out.println("3. 추가");
			System.out.println("4. 수정");
			System.out.println("5. 삭제");
			System.out.println("6. 종료");
			System.out.println("------------");
			System.out.print("번호 입력 : ");
			no = sc.nextInt();
			
			String req = null;
			switch(no) {
			case 1:
				System.out.println("**전체 출력**");
				req = "selectAll";
				List<MyTest> resAll = (List<MyTest>) con.doMethod(req);
				
				for(MyTest m : resAll) {
					System.out.println(m);
				}
				break;
			case 2:
				System.out.println("**선택 출력**");
				req = "selectOne";
				MyTest resOne = (MyTest) con.doMethod(req, inputNo());
				if(resOne != null) {
					System.out.println(resOne);					
				}else {
					System.out.println("[검색 결과가 없습니다.]");
				}
				break;
			case 3:
				System.out.println("**추가**");
				req = "insert";
				int resInsert = (int)con.doMethod(req, inputMember());
				if(resInsert>0) {
					System.out.println("[추가 성공]");
				}else {
					System.out.println("[추가 실패]");
				}
				break;
			case 4:
				System.out.println("**수정**");
				req = "update";
				int resUpdate = (int)con.doMethod(req, inputUpdate());
				if(resUpdate>0) {
					System.out.println("[수정 성공]");
				}else {
					System.out.println("[수정 실패]");
				}
				break;
			case 5:
				System.out.println("**삭제**");
				req = "delete";
				int resDelete = (int)con.doMethod(req, inputNo());
				if(resDelete>0) {
					System.out.println("[삭제 성공]");
				}else {
					System.out.println("[삭제 실패]");
				}
				break;
			case 6:
				System.out.println("\n[프로그램 종료]\n");
				return;
			default:
				System.out.println("[올바른 번호를 다시 입력해주세요]");
			}
		}
	}
	
	public int inputNo() {
		System.out.print("번호 입력: ");
		int n = sc.nextInt();
		return n;
	}
	
	public MyTest inputMember() {
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("별칭: ");
		String nickName = sc.next();
		MyTest m = new MyTest(0,name,nickName);
		return m;
	}
	
	public MyTest inputUpdate() {
		System.out.print("수정할 번호: ");
		int no = sc.nextInt();
		System.out.println("수정할 이름: ");
		String name = sc.next();
		System.out.println("수정할 별칭: ");
		String nickName = sc.next();
		
		MyTest m = new MyTest();
		m.setMno(no);
		m.setMname(name);
		m.setNickname(nickName);
		
		return m;
	}
}
