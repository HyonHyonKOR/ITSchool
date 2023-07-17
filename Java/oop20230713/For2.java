package oop20230713;

public class For2 {

	public static void main(String[] args) {
	//중첩 for문: 구구단
		
	int i;
	int j;
	
	for(i=2; i<10; i++) {
		for(j=1; j<10; j++) {
			System.out.printf("%d x %d = %d\n", i, j, (i*j));
		}
	}
		
		
	}//main() end

}//Class end
