package oop20230803;
class Test{
	
	void view() throws Exception{
		int a = 3 / 0 ;
	}
	void disp() throws Exception{
		Integer in = null;
		int a = in.intValue();
	}
}// class end

public class ExceptionEx6 {
	
	public static void main(String[] args) {
		//throws 
		//메소드와 함께 사용
		Test test = new Test();
	
		System.out.println("START");
		try {
			test.view();
			test.disp();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("END");
		}
	}
}
