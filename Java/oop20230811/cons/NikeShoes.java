package oop20230811.cons;

public class NikeShoes {
	public String name;
	public int size;
	public int price;
	public static final String BRAND = "NIKE";
	
	
	
	
	public NikeShoes(String name, int size, int price) {
		this.name = name;
		this.size = size;
		this.price = price;
	}
	
	public void disp() {
		System.out.printf("모델명  : %s\n" ,name);
		System.out.printf("사이즈 : %d\n" ,size);
		System.out.printf("가격  : %d원\n" ,price);
		System.out.printf("브랜드 : %s\n" ,BRAND);
	}
	
	
}
