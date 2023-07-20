package oop20230720;

public class MethodEx3 {

	public static void main(String[] args) {
		
		sign(1);
		sign(0);
		sign(-1);

	}
	
	
	public static void sign(int n){
		int a = (n>0)?1:(n<0)?0:-1;
		String answer = (a==1)?"양수":(a==0)?"음수":"다시 출력해주세요.";
		System.out.println(answer);
	}
	

}


/*// sign 메소드 : 정수 n을 매개변수로 전달 받아 부호를 판별하여 전달

// (n이 양수이면 1, 음수이면 0을 return 하도록 하시오.)

// main() 메소드에서 호출한 sign메소드를 정의하기

// main() 메소드에서 1이면 "양수"출력, 0이면 "음수"출력

// (출력결과는 자유롭게 만들어 보세요 ^^)
 * 
 * 
 * 
 * 
 * 
 * 
 */


