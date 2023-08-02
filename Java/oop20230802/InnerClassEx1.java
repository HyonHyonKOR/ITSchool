package oop20230802;

class WebProgram {
	String title = "Java Programming";
	class Language{
		String basic = "Java, HTML, JavaScript";
		void disp() {
			System.out.println("기초수업: " + basic);
		}
	}
	class Smart{
		String basic = "Object-C";
		void disp() {
			System.out.println("기초수업: " + basic);
		}
	}
}

public class InnerClassEx1 {

	public static void main(String[] args) {
		//#inner class : 내부 클래스
		//(외부)클래스 안의 (내부)클래스가 있는 경우
		// 외부에서 접근할 필요가 없는 클래스
		// GUI 어플리케이션의 (AWT,SWING)
		// 이벤트(마우스 클릭, 마우스 오버, 키보드 눌렀을 때) 처리에 많이 사용
		// JS -> jQuery, Ajax
		
		//외부 클래스를 통해 단계적으로 접근해야 한다.
		//Language lang = new Language(); //에러
		//Smart smart = new Smart(); //에러

		WebProgram web= new WebProgram();
		System.out.println(web.title);
		
		WebProgram.Language lang = new WebProgram().new Language();
		System.out.println(lang.basic);
		lang.disp();
		
		WebProgram.Smart sma = new WebProgram().new Smart();
		System.out.println(sma.basic);
		sma.disp();
	
	}
	
}
