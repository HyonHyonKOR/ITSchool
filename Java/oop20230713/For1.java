package oop20230713;

public class For1 {

	public static void main(String[] args) {
		//7단 구구단 출력하기(곱셈 수식 9회 출력)
		int i;
		int val = 7;
		
		for(i=1; i<=9 ; i++) {
			System.out.printf("%d x %d = %d\n" , val, i, val*i); //반복대상
		}
		
	}//main() end
}//class end
