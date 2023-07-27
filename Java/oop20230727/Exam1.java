package oop20230727;

public class Exam1 extends Object{
	String name;
	int kor, eng, math;
	int tot;
	double avg;
	public Exam1() {}
	public Exam1(String name, int kor , int eng , int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public int calcTot() {
		this.tot = kor + eng +math;
		return this.tot;
	}
	public double calcAvg() {
		this.avg = (double)tot/3;
		return this.avg;
	}
	public void outputResult() {
		System.out.println("이름 :" + name + "총점: " + calcTot()  + "평균 :" + calcAvg());
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
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	

}
