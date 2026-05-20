package com.view;

import java.util.List;
import java.util.Scanner;

import com.controller.Controller;
import com.model.dto.Member;

public class MemberView {
	private Scanner sc = new Scanner(System.in);
	//[1]
	//private MemberController con = new MemberController();
	//[2]
	//private MemberSekectController con = new MemberSelectController();
	//[3]
	private Controller con = new Controller();
	
	public void menu() {
		int no = 0;
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
				//전체 출력
				System.out.println("**전체 출력**");	
				
				//[1]
				//List<Member> resAll = con.selectAll();
				//[2]
				//List<Member> resAll = con.selectAll();
				//[3]
				req = "selectAll";
				List<Member> resAll = (List<Member>) con.doMethod(req);
				
				for(Member m : resAll) {
					System.out.println(m);
				}
				break;
			case 2:
				//선택 출력
				System.out.println("**선택 출력**");
				//[1]
				//Member resOne = con.selectOne(inputNo());
				//[3]
				req = "selectOne";
				Member resOne = (Member) con.doMethod(req, inputNo());
				if(resOne != null) {
					System.out.println(resOne);					
				}else {
					System.out.println("[검색 결과가 없습니다.]");
				}
				break;
			case 3:
				//추가
				System.out.println("**추가**");
				//[1]
				//int resInsert = con.insert(inputMember());
				//[3]
				req = "insert";
				int resInsert = (int)con.doMethod(req, inputMember());
				if(resInsert>0) {
					System.out.println("[추가 성공]");
				}else {
					System.out.println("[추가 실패]");
				}
				break;
			case 4:
				//수정
				System.out.println("**수정**");
				//입력받은 no 멤버의 location, job, tel 컬럼 값 update 하고
				//화면에 "[수정 성공] or [수정 실패]" 출력
				//[1]
				//int resUpdate = con.update(inputUpdate());
				//[3]
				req = "update";
				int resUpdate = (int)con.doMethod(req, inputUpdate());
				if(resUpdate>0) {
					System.out.println("[수정 성공]");
				}else {
					System.out.println("[수정 실패]");
				}
				break;
			case 5:
				//삭제
				System.out.println("**삭제**");
				//[1]
				//int resDelete = con.delete(inputNo());
				//[3]
				req = "delete";
				int resDelete = (int)con.doMethod(req, inputNo());
				if(resDelete > 0) {
					System.out.println("[삭제 성공]");
				}else {
					System.out.println("[삭제 실패]");
				}
				break;
			case 6:
				//종료
				System.out.println("\n[프로그램 종료]\n");
				return;
			default:
				System.out.println("\n[메뉴를 다시 입력해주세요]\n");
			}
		}
	}
	
	public Member inputMember() {
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("나이: ");
		int age = sc.nextInt();
		System.out.print("성별(M/F): ");
		String gender = sc.next();
		System.out.print("지역: ");
		String location = sc.next();
		System.out.print("직업: ");
		String job = sc.next();
		System.out.print("전화번호: ");
		String tel = sc.next();
		System.out.print("이메일: ");
		String email = sc.next();
		
		Member m = new Member(0,name,age,gender,location,job,tel,email);
		return m;
	}
	
	public int inputNo() {
		System.out.print("번호: ");
		int no = sc.nextInt();
		return no;
	}
	
	public Member inputUpdate() {
		System.out.print("수정할 번호: ");
		int no = sc.nextInt();
		System.out.print("수정할 지역: ");
		String location = sc.next();
		System.out.print("수정할 직업: ");
		String job = sc.next();
		System.out.print("수정할 전화번호: ");
		String tel = sc.next();
		
		Member m = new Member();
		m.setM_no(no);
		m.setM_location(location);
		m.setM_job(job);
		m.setM_tel(tel);
		
		return m;
	}

}
