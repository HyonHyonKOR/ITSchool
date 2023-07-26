package oop20230726;
public class Goods {
	private String name;
	private int price;
	private int numberOfSold;
	private int numberOfStock;
	

public Goods() {}	

public Goods(String name) {this.name = name;}

public Goods(String name, int price) {this.name = name; this.price = price;}

public Goods(String name, int price, int numberOfSold) {this.name = name; this.price = price;this.numberOfSold = numberOfSold;}
	
public Goods(String name, int price, int numberOfSold, int numberOfStock) {
 	this.name = name;
	this.price = price;
	this.numberOfSold = numberOfSold;
	this.numberOfStock = numberOfStock;
}
		
	
public void inputGoods(String name, int price, int numberOfSold, int numberOfStock) {
    	this.name = name;
    	this.price = price;
    	this.numberOfSold = numberOfSold;
    	this.numberOfStock = numberOfStock;
    }



public void printGoods() {
	System.out.printf("%d만원 %s 상품은 금일 %d개 판매 후, 재고가 %d개입니다.\n", this.price,this.name,this.numberOfSold,this.numberOfStock);
	}

}

