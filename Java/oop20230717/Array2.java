package oop20230717;

public class Array2 {

	public static void main(String[] args) {
		
		//double []d;    //                 (1) 참조형 변수 선언문;      
		//d = new double[] {1.1, 2.2, 3.3}  (2) 변수 대입문;
		
		//double[] d= new double[] {1.1,2.2,3.3}   //배열 초기
		double[] d = {1.1,2.2,3.3};  //8byte x 3 -> 24byte
		//			   배열의 인덱스는 0부터 시작 ~ (배열의 크기-1)
		//             index, 인덱스 ,위치, ~번째
		// 배열명[인덱스]
		d[0] = 5.5;
		System.out.println(d[0]);
		
		
		//향상된 for(each-for) : 배열의 요소를 접근(참조), 차례대로 "모든 요소" -> "순회"
		
		int count=0;
		char[] word = {'H','a','p','p','y'};
		
		
		for(int i = 0; i < word.length; i++) {
			char c = word[i];
			if(c>= 'A' && c<= 'Z') //알파벳 대문자이니?
			   c = (char)(c+32);  //대문자를 소문자로 변환
			//단어내의 모음 문자 소문자 판별(구별)
			
			switch(c){
			case 'a': case 'e' : case 'i' : case 'o' : case 'u':
				count++;
			}
			
		   }
		 System.out.println("모음의 갯수 : " + count);
		}
	}	

