package oop20230718;

public class Array8 {

	public static void main(String[] args) {
	//진법 변환(10진수 -> 2진수)
	int dec = 14;	//입력 10진수(14):0~255
		
	int[] bin = new int[8];// (출력) 2진수 00001100	
		
	for(int i=0;dec>0; i++) {
		bin[7-i] = dec%2;
		dec/=2 ;
	}
	
	for(int i=0; i<bin.length; i++) {
		System.out.print(bin[i]);
	}
	
	System.out.println();
	
	dec = 14;
	
	int i=7;
	while(i>0){
	bin[i--] = dec%2;
	dec/=2;
	}
	
	for(int j=0; j<bin.length; j++) {
		System.out.print(bin[j]);
	}
		
		
	}//main()
}//Class
