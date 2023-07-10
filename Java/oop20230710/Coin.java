package oop20230710;

import java.util.Scanner;

public class Coin {

	public static void main(String[] args) {
	
	//입력
	Scanner sc = new Scanner(System.in);
	System.out.print("금액 입력(원) : ");
	int inputMoney = sc.nextInt();
	
	//500원 연산
	int c500= inputMoney/500;
	int leftMoney = inputMoney%500;
	System.out.printf("500원 짜리 : %d개\n", c500 );
	
	//100원 연산
	int c100 = leftMoney/100;
	leftMoney = leftMoney%100;
	System.out.printf("100원 짜리 : %d개\n", c100 );
	
	//50원 연산
	int c50 = leftMoney/50;
	leftMoney = leftMoney%50;
	System.out.printf("50원 짜리  : %d개\n", c50 );
	
	//10원 연산
	int c10 = leftMoney/10;
	leftMoney = leftMoney%10;
	System.out.printf("10원 짜리  : %d개\n\n\n", c10);

	//잔돈 연산
    System.out.printf("바꾸지 못한 잔돈은 %d원입니다", leftMoney);
	
    sc.close();
   }
}


/*

// 입력된 액수만큼 500원, 100원, 50원, 10원짜리 동전으로 교환해주는 프로그램
​// [HINT] 대입연산자(=)와 나머지 연산자(%)와 나누기 연산자(/) 사용
// money c500 c100 c50 c10 잔돈
// 조건1 : 동전의 총수를 최소화
// 조건2 : 고액의 동전을 먼저 교환


[결과]

=== 동전 교환 ====

금액 입력(원) : 1637 (엔터)
500원 짜리 : XXX개
100원 짜리 : XXX개
50원 짜리 : XXX개
10원 짜리 : XXX개

바꾸지 못한 잔돈은 X원입니다. 
 * 
 * 
 * 
 * 
 */
