package oop20230724;

public class BookEx {
	
	String title="JAVA 프로그래밍";
	String author="박철수";
	int price=25000;
	
	public void show() {
		System.out.printf("%s 저자의 [%s]은 %d원입니다.\n" ,author,title,price);
	}
	
	
}
