package oop20230731;

public class Product {
	static int count = 0;
	int serialNo;
	public void countUP() {
		count++;
		serialNo = count;
	}

	public static void main(String[] args) {
		Product.count++;
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		System.out.println("p1의 제품번호(serialNo)는" + p1.serialNo);
		System.out.println("p2의 제품번호(serialNo)는" + p2.serialNo);
		System.out.println("p3의 제품번호(serialNo)는" + p3.serialNo);
		
		
		p1.countUP();
		System.out.println("p1의 제품번호(serialNo)는" + p1.serialNo);
		p2.countUP();
		System.out.println("p2의 제품번호(serialNo)는" + p2.serialNo);
		p3.countUP();
		System.out.println("p3의 제품번호(serialNo)는" + p3.serialNo);
	}

}
