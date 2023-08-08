package oop20230808;


//방법2) Runnable 인터페이스를 구현하는 방법
class TimerRunnable implements Runnable{
	int n = 0;
		
	@Override
	public void run() {
		while(true) {
			System.out.println( n + "초");
			n++;
			try {
				Thread.sleep(1000); //1초 동안 멈춤(1000ms) -> 깨어남(재개)
			} catch(InterruptedException e) {
				return;
			}
		}
	 }
}
public class ThreadEx2 {

	public static void main(String[] args) {
		Thread th = new Thread(new TimerRunnable());  //스레드 객체 생성;
		th.start(); //스레드 시작
		th.interrupt();  //스레드 강제종료 
	}

}
