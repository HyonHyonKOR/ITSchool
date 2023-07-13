package oop20230712;

public class While1 {

	public static void main(String[] args) {

		int i;
		
		i = 0; //초기화, 시작값
		while( i < 5 ) { //끝 6회(5+1)
			
			System.out.println((i+1) +"번째 :" + "Hi, Java");
			i++; //i = i + 1: //증감식
		}
		
		System.out.println("최종 i: " + i);
		System.out.println("반복 횟수: " + i);
	}//main() end

}
