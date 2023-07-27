package oop20230727;

public class Exam2 extends Exam1{
	int mus, com;
	 
	public Exam2() {}
	public Exam2(String name, int kor , int eng , int math, int mus, int com){
	  super(name,kor,eng,math);
	  this.mus = mus;
	  this.com = com;
  }
	
	public int calcTot() {
		this.tot = kor + eng +math + mus + com;
		return this.tot;
	}
	public double calcAvg() {
		this.avg = (double)tot/5;
		return this.avg;
	}
	

}
