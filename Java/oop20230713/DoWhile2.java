package oop20230713;

import java.util.Scanner;

public class DoWhile2 {

	public static void main(String[] args) {
		//계속 키보드(사용자)로부터 입력받은 정수를 출력하여라.
		//단 0이 입력되면 실행 중지
		
		int num;
		Scanner sc = new Scanner(System.in);
		do {
		
			System.out.print("숫자를 입력하시오!(0입력시 종료) : ");
			num= sc.nextInt();
			
			System.out.println("입력하신 숫자는 " +num+ "입니다." );
			
		} while (num != 0);
		
		System.out.println("0을 입력하였으므로 종료되었습니다.");

		sc.close();
		
	}//main() end
}//Class end
