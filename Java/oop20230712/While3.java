package oop20230712;

public class While3 {

	public static void main(String[] args) {
		// 중첩 while: 구구단 출력하기(2단~9단) < -- 
		int i;
	    int k;
		
	    i=2;    //마지막 수 파악할때는   
		while(i < 10) {    // 외부 : 고정 반복
			k=1;   // i는 고정 반복이므로 미리 초기화해도 되나, 마지막에 k는 10이 되므로 루프시 false다. 내부 반복이 있는 k는 반드시 1로 초기화해야함.
			while(k < 10) { // 내부 : 변화 반복
			  System.out.println(i + "x" + k + "=" + (i * k));    //8*9회
			  k++;
		   }
		  i++;
	   }
    }//main
}//class
