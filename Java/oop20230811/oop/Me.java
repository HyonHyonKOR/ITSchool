package oop20230811.oop;

import java.util.Scanner;

public class Me {
	
	static Scanner sc = new Scanner(System.in);
	
	public int speakMyAns() {
		System.out.print("Me : ");
		int myAns = sc.nextInt();
		return (myAns>0 && myAns<101 )? myAns: speakMyAns();
	}
	
	
}
