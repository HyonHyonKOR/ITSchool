package oop20230710;

import java.util.Scanner;

public class Calory {

	public static void main(String[] args) {
 
		
	Scanner sc = new Scanner(System.in);
    
    
    System.out.print("지방 :");
    int fat = sc.nextInt();
    
    System.out.print("탄수화물 :");
    int carbohydrate = sc.nextInt();
    
    System.out.print("단백질 :");
    int protein =sc.nextInt();
    
     
    double kcalory =((fat*9.0)+(carbohydrate*4.0)+(protein*4.0)/1000);
    
    
 
    
    System.out.print("총 칼로리 :" +kcalory +"kcal");
    sc.close();
    
	}

}

//[3] 지방(fat), 탄수화물(carbohydrate), 단백질(protein) 칼로리의 합계를 계산하는 프로그램

//클래스명(파일명) : Calory.java

//사용자가 지방, 탄수화물, 단백질의 그램을 입력

//총 칼로리(calory) 구하기

//- 지방 1그램은 9칼로리, 단백질과 탄수화물은 1그램에 4칼로리

//- 총 칼로리 = 지방 * 9 + 단백질 * 4 + 탄수화물 * 4 

//- nextInt() 이용 입력

//- 화면 출력

//- kcal 구해보기(결과가 실수가 나오도록 출력)

//- 총 칼로리/1000
