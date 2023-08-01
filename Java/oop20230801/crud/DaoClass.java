package oop20230801.crud;

import java.util.*;

public class DaoClass {

	Scanner sc = new Scanner(System.in);
	DtoClass dtoArr[] = new DtoClass[20];      //20면(page) 책
	
	private boolean swit[] = new boolean[20];  //페이지의 유효 확인(boolean 초기값:false)
	private int pageNum;
	private String check;
	
	public DaoClass() {
		
	}
	
	// 1. Insert - 추가
	public void insert(){
		System.out.println();
		for(int i = 0; i < dtoArr.length; i++) {
			if(swit[dtoArr.length-1] == true) {    //항상 부정상황을 먼저 처리한다.
				System.out.println("더 이상 페이지를 추가 할 수 없습니다.");
				return;
			}else if (swit[i] = false) {
				System.out.println((i+1) + "번 페이지에 작성 하실 수 있습니다.");
				break;
			}
		}//for end()
		
		System.out.print("# 나이\n>>>");
		int age = sc.nextInt(); 
		System.out.print("# 이름\n>>>");
		String name = sc.next();
		System.out.print("# 생년월일\n>>>");
		String birth = sc.next();
		System.out.print("# 주소\n>>>");
		String address = sc.next();
		
		for(int i = 0; i < dtoArr.length; i++) {
			if(swit[i] == false) {
				swit[i] = true;
				pageNum = i+1;
				dtoArr[i] = new DtoClass(this.pageNum, age, name, birth, address);
				System.out.println(pageNum + " 번째 페이지가 작성되었습니다.");
				break;
			}
		}//for end
		
	}//insert() end()
	
	// 2. Delete - 추가
	public void delete() {
		System.out.print("\n삭제하고 싶은 책의 쪽수를 입력하시오(1~20)\n>>>");
		pageNum = sc.nextInt();
		
		if(dtoArr[pageNum -1] == null) {
			System.out.println("\n작성된 페이지가 없는 쪽수입니다");
			return;
		}
		System.out.println("\n삭제하고 싶은 " +pageNum+ "페이지의 내용입니다.");
		System.out.println(dtoArr[pageNum - 1].toString());
		System.out.print("페이지를 삭제하고 싶으시면 'Y' 아니면 'N'을 입력하시오\n>>>");
		check = sc.next();
		if(check.equalsIgnoreCase("Y")) {
			swit[pageNum - 1] = false;
			dtoArr[pageNum -1] = null;
			System.out.println("\n페이지가 삭제되었습니다.");
		}else {
			System.out.println("\n삭제를 취소합니다.");
			return;
		}
	
	} //delete end
	
	// 3. Search - 추가
	public void search() {
		System.out.print("검색하고 싶은 책의 페이지수를 입력하시오( 1 ~ 20 )\n>>>");
		pageNum = sc.nextInt();
		
		if(dtoArr[pageNum -1] == null) {
			System.out.println("\n작성된 페이지가 없는 쪽수입니다");
			return;
		}
		System.out.println("\n검색하고 싶은 "  +pageNum+ "페이지의 내용입니다.");
		System.out.println(dtoArr[pageNum - 1].toString());
		
	}//search() end
	
	// 4. Update - 수정, 갱신
	public void update() {
		System.out.print("수정하고 싶은 책의 페이지수를 입력하시오( 1 ~ 20 )\n>>>");
		pageNum = sc.nextInt();
		
		if(dtoArr[pageNum -1] == null) {
			System.out.println("\n작성된 페이지가 없는 쪽수입니다");
			return;
		}
		
		System.out.println("\n수정하고 싶은 "  +pageNum+ "페이지의 내용입니다.");
		System.out.println(dtoArr[pageNum - 1].toString());
		
		
		System.out.print("페이지를 수정하고 싶으시면 'Y' 아니면 'N'을 입력하시오\n>>>");
		check = sc.next();
		
		if(check.equalsIgnoreCase("Y")) {
			//페이지 수정 : 페이지 내의 전체(필드) 정보 수정(대입,덮어쓰기)
			System.out.print("# 나이\n>>>");
			int age = sc.nextInt(); 
			System.out.print("# 이름\n>>>");
			String name = sc.next();
			System.out.print("# 생년월일\n>>>");
			String birth = sc.next();
			System.out.print("# 주소\n>>>");
			String address = sc.next();
			
			dtoArr[pageNum-1] = new DtoClass(pageNum,age,name,birth,address);
			
			System.out.println("페이지가 수정되었습니다.");
		}
	}// update() end 
   
}
