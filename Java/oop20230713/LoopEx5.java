package oop20230713;

import java.util.Scanner; 

public class LoopEx5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = 0;
		
		System.out.print("1 이상의 정수를 입력해주세요: ");
		input = sc.nextInt();
		
		for(int i=1; i<=input; i++) {
			if(input/i!=0 && input%i==0)
			System.out.print(i+" ");
		}
		
		
		sc.close();
		
		
	}//main
}//Class

/*

[출력][예1]

정수 입력 : 12

12의 약수 : 1  2  3  4  6  12

[출력][예2]

정수 입력 : 7

12의 약수 : 1  7

*/