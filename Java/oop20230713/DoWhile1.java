package oop20230713;

public class DoWhile1 {

	public static void main(String[] args) {
		//7단 구구단 출력하기 (곱셈 수식 9번 출력)
		int i;
		var val = 7;
		
		i = 1;
		do {
			System.out.printf("%d x %d = %d\n" , val, i, val*i);
			i++;
		   }
		
		while(i<=9);
		
	}

}
