package oop20230731;

public class WrapperTest {
	
	public static void main(String[] args) {
		
		//기본형의 값을 객체로 처리
		//Boolean,Byte,Character,Short,Integer,Long,Float,Double
		boolean b1 = true;
		//Boolean b2 = new Boolean(true);
		//Boolean b3 = new Boolean("true");
		

		System.out.println(b1);
		//System.out.println(b2.toString());
		//System.out.println(b3.booleanValue());
		
		//int t1 = 3;
		//Integer t2 = new Integer(5);
		//Integer t3 = new Integer("7");
		
		//int hap = t1 + t2.intValue() + t3.intValue();
		
		//System.out.println(hap);
		
		System.out.println(Integer.max(3, 5));
		System.out.println(Integer.min(3, 5));
		System.out.println(Integer.sum(3, 5));
		
		
		//char c1 = 'R';
		//Character c2 = new Character('r');
		//System.out.println(c2.toString());
		System.out.println(Character.isWhitespace(' '));
	}
	
	
}
