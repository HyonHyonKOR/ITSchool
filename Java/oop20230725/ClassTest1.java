package oop20230725;

class Score{
	private String name;
	private int kor, eng, math;
	
	
	public void disp() {
		System.out.println(name);
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(math);
	}
	public void set(String name,int kor,int eng,int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
}

public class ClassTest1 {

	public static void main(String[] args) {
		Score s1 = new Score();
		s1.setName("홍길동");
		s1.set("홍길순", 50, 75, 90);
		s1.disp();
		System.out.println(s1);
		s1.set("홍길철", 50, 75, 90);
		s1.disp();
		System.out.println(s1);

	}

}
