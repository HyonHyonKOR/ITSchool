package oop20230717;

public class Break1 {

	public static void main(String[] args) {
		//1. 유한 for문 : 5회(번) "JAVA"출력
		for(int i =1; i<=5; i++) {
			System.out.println("JAVA");
		}
		//2. 유한 while문: 5회(번) "JAVA"출력
		int i =1;
		while(i<=5){
			//i++;
			System.out.println("JAVA" + i);
			i++;
		}
		//3. 무한 while문 : 5회 "java"출력
		int a = 0;
		while(true) {
			if(a==5) { 
			   break;
			}
			System.out.println("java"); //반복대상
			a++;
		 }//while
	   }
    }