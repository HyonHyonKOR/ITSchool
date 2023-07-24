package oop20230724;

import java.util.Scanner;

public class MethodEx10 {

	public static void main(String[] args) {
		
		seqSearchString();
		

	}

	
	public static void seqSearchString() {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 길이를 입력 : ");
		String s = sc.nextLine();
		int size = Integer.parseInt(s);
		String[] arr = new String[size];
		
		for(int i=0; i<size;i++) { 
		  System.out.print("arr["+i+ "] : ");
		  arr[i]=sc.nextLine();
		}
		
		System.out.print("검색할 값 입력 : ");
		String key = sc.nextLine();
		sc.close();
		 
		for(int i=0; i<size; i++) {
		   if(key.equals(arr[i])) {
			   System.out.println("검색성공:배열arr[" +i+ "]에 있습니다.");
			   return;
		   }
		}
		System.out.println("검색실패:배열에 검색할 값이 없습니다.");
     }
	
}
