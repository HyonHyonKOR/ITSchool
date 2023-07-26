package oop20230726;

public class Exam {
	private String name;
	private int kor, eng, math;
	
	Exam(){
		System.out.println("생성 완료 후 자동호출 -> 초기화");
		this.name = "꾸엑";
		this.kor  = 50;
		this.eng  = 70;
		this.math = 80;
	}
	
	Exam(String name){
		System.out.println("생성 완료 후 자동호출 -> 초기화");
		this.name = name;
		this.kor  = 50;
		this.eng  = 70;
		this.math = 80;
	}
	
	
	public void set(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor  = kor;
		this.eng  = eng;
		this.math = math;
	}
	
	public void disp(){
		System.out.printf("%s %d %d %d\n",this.name,this.kor,this.eng,this.math);
	}
	

}//Exam class end 
