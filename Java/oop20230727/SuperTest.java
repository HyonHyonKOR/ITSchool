package oop20230727;
class Parent{
	int i,j;
	public Parent() {System.out.println("s");}
	public Parent(int i, int j) {
		this.i = i;
		this.j = j;
	}
}//class end
class Child extends Parent{
	int k;
	public Child() {
		super();  //부모클래스 기본생성자 호출 
	}
	public Child(int ii, int jj, int kk) {
	//	this.i = ii;
	//	this.j = jj;
		super(ii,jj);  //부모클래스 매개변수 생성자 호출 
		this.k = kk;
	}
}//class end


public class SuperTest {

	public static void main(String[] args) {
		//Parent() 생성자 ->  Child() 생성자 호출
		Child child = new Child();
		System.out.println(child);
	}

}
