package oop20230711;

public class If2 {

	public static void main(String[] args) {
		//단순 if
		int number = 5; 
		
		if(number < 0 ){
			System.out.println("음수입니다.");
		}
		
		if(number > 0){
			System.out.println("양수입니다.");
		}
		
		if(number == 0){
			System.out.println("0입니다.");
		}
	}
	
	//조건식 부분에 ; 을 붙이면 블록에 있는 명령을 실행해버린다.

}
