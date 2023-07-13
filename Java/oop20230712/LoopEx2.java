package oop20230712;

public class LoopEx2 {

	public static void main(String[] args) {
		//선언
		int i;
		int result1 = 0;
		int result2 = 0;
		
		//처리
		i=1;
		while(i<=10) {
			
			if(i%2==1) {
				result1 += i;
			}
			else {
		        result2 += i;		
			}
			i++;
		}
		
		System.out.println("홀수의 합 : " + result1 );
		System.out.println("짝수의 합 : " + result2 );
   }
}

