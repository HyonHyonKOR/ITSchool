package oop20230726;
public class GoodsEx {

	public static void main(String[] args) {
		
		Goods iphone = new Goods();
		iphone.printGoods();
		iphone.inputGoods("아이폰", 100000, 1, 1);
		iphone.printGoods();
		
		Goods iphone2 = new Goods("아이폰2", 500000, 1, 5);
		iphone2.printGoods();

	}

}
