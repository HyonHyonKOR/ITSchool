package oop20230811.oop;

import java.util.Random;

public class Friend {
	
	Random brain = new Random();
	
	public int writeFriAns() {
		// 머리속으로 숫자 하나를 <생각> 해서
		// 종이에 적어 답 제출
		int think = brain.nextInt(100)+ 1;
		System.out.println("친구가 답을 정했다!");
		return think;
	}
}
