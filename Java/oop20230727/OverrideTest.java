package oop20230727;

class School{
	public String name ="학교";
	
	public void disp() {
		System.out.println(this.name);
	}
	//오버로딩
	public void disp(int a, int b) {
		System.out.println(this.name + a + "학년" + b +"반");
	}
}//class end


// 중학교class는 학교class이다. (IS-A관계, 일반화 관계)
//     자식class              부모class
class MiddleSchool extends School{
}


class HighSchool extends School{
	//name = "고등학교"; //명령문; 명령문은 메소드 내에서만 사용하지만 클래스만 보면 명령문이 없다 
	public String name = "고등학교";
	public void disp() {
		System.out.println(super.name);
		System.out.println(this.name);
		System.out.println("메소드 오버라이딩: 변경/추가/수정 가능");
	}
	public void disp(int grade) {   //오버로딩(Overloading), 중복정의
	    System.out.println(this.name + grade + "학년");
	}
	
	
}



public class OverrideTest {

	public static void main(String[] args) {
		MiddleSchool ms = new MiddleSchool();
		System.out.println(ms.name);
		ms.disp();
		
		System.out.println();
		
		HighSchool hs = new HighSchool();
		System.out.println(hs.name);
		hs.disp(); //메소드 바인딩, 동적 바인딩(Binding) 
		hs.disp(2);
		hs.disp(3,5);

	}


}
