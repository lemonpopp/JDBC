package com.view;

import java.util.List;
import java.util.Scanner;

import com.controller.ProductController;
import com.model.vo.Product;

public class ProductView {
	private ProductController controller = new ProductController();
	private Scanner sc = new Scanner(System.in);
	
	public void menu() {
		int no = 0;
		
		while(no != 6) {
			System.out.println("-----------------");
			System.out.println("1. 전체 출력");
			System.out.println("2. 선택 출력");
			System.out.println("3. 추가");
			System.out.println("4. 수정");
			System.out.println("5. 삭제");
			System.out.println("6. 종료");
			System.out.println("-----------------");
			System.out.print("번호 입력: ");
			no = sc.nextInt();
			
			switch(no) {
			case 1:
				//정체 출력 : db에 저장된 데이터 전체를 조회
				System.out.println("***제품 전체 조회***");

				List<Product> resAll = controller.selectAll();
				
				if(resAll.size() != 0) {
					for(Product p : resAll) {
						System.out.println(p);
					}
				}else {
					System.out.println("등록된 제품이 없습니다.");
				}
				break;
			case 2:
				//선택 출력 : db에 저장된 데이터 중 하나만 선택하여 조회
				System.out.println("***제품 선택 조회***");			
				Product resOne = controller.selectOne(inputId());
				if(resOne != null) {
					System.out.println(resOne);
				}else {
					System.out.println("조회 결과가 없습니다.");
				}
				break;
			case 3:
				//추가 : 데이터를 db에 insert 추가
				System.out.println("***제품 추가***");
				int res = controller.insert(insertProduct());
				if(res > 0) {
					System.out.println("제품이 추가되었습니다.");
				}else {
					System.out.println("제품 추가에 오류가 발생했습니다.");
				}
				break;
			case 4:
				//수정 : db에 저장된 데이터를 수정
				System.out.println("***제품 수정***");
				int resUpdate = controller.update(updateProduct());
				if(resUpdate>0) {
					System.out.println("제품 가격이 수정되었습니다.");
				}else {
					System.out.println("제품 가격 수정에 실패했습니다.");
				}
				break;
			case 5:
				//삭제 : db에 저장된 데이터 삭제
				System.out.println("***제품 삭제***");
				String delId = inputId();
				int resDelete = controller.delete(delId);
				if(resDelete>0) {
					System.out.println("제품이 삭제되었습니다.");
				}else {
					System.out.println("제품 삭제에 실패했습니다.");
				}
				break;
			case 6:
				System.out.println("\n[프로그램 종료]\n");
				break;
			default:
				System.out.println("번호를 다시 입력해주세요!");
			}
		}
	}

	//id 하나를 입력받아 반환하는 메서드
	public String inputId() {
		System.out.print("제품 id 입력:");
		String id = sc.next();
		return id;
	}
	
	//db에 추가할 값을 입력받아 반환하는 메서드
	public Product insertProduct() {
		System.out.print("추가할 제품 ID : ");
		String id = sc.next();
		System.out.print("추가할 제품 이름 : ");
		String name = sc.next();
		System.out.print("추가할 제품 가격 : ");
		int price = sc.nextInt();
		System.out.print("추가할 제품 설명 : ");
		String des = sc.next();
		
		return new Product(id, name, price, des);
	}
	
	//수정할 값을 입력받아 반환하는 메서드
	public Product updateProduct() {
		//수정할 가격, 제품id 입력
		//입력받은 id 제품의 가격을 입력받은 값으로 변경
		System.out.print("제품 id 입력:");
		String id = sc.next();

		System.out.print("수정할 제품 가격 : ");
		int price = sc.nextInt();
		
		Product p = new Product();
		p.setPid(id);
		p.setPrice(price);
		
		return p;
	}
	
	
}
