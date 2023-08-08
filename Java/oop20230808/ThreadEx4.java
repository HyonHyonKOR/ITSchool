package oop20230808;
// 두 스레드(2) 가 공유프린터 객체(1)를 통해 동시에 출력(처리)하는 경우
// "공유자원" <= synchronized 메서드 -- 멀티스레딩
class SharePrinter{
	 synchronized void print(String text) {
		for(int i = 0; i< text.length(); i++) {
			System.out.print(text.charAt(i));
		}
		System.out.println();
	}
}
class WorkerThread extends Thread{  //스레드 클래스
	private SharePrinter p; //공유 프린터 주소
	private String[] text;
	public WorkerThread(SharePrinter p, String[] text) {
		this.p = p;
		this.text = text;
	}
	//스레드는 반복적으로 공유 프린터 text.length번 접근하여 text[]를 출력
	@Override
		public void run() {
			for(int i=0; i< text.length; i++) { //한 줄씩 출력
				p.print(text[i]);  //공유 프린터에 출력
			}
		}
 }

public class ThreadEx4 {

	public static void main(String[] args) {
		SharePrinter p = new SharePrinter();  //공유 프린터(자원, 데이터 ) 생성
		
		String[] entText = { "Twinkle Twinkle, Little Star",
				"How I wonder what you are",
				"Up above the world so high",
				"Like a diamond in the sky",
				"Twinkle Twinkle Little Star",
				"How I wonder what you are!" };
		String[] korText = { "반짝반짝 작은별",
				"나는 네가 무엇인지 궁금해",
				"세상 저 높은곳에서",
				"하늘의 다이아몬드처럼",
				"반짝반짝 작은별",
				"나는 네가 무엇인지 궁금해" };
				
		Thread th1 = new WorkerThread(p,entText);  //영문 출력 스레드	
		Thread th2 = new WorkerThread(p,korText); //국문 출력 스레드 
		// 두 스레드 실행(멀티 스레딩)
	    th1.start();
	    th2.start();
		
		
	}

}
