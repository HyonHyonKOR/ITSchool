package oop20230808;
//(방법1) Thread 클래스를 상속받는 방법
// 1초 단위로 초 시간을 출력하는 프로그램
class TimerThread extends Thread{
	int n = 0;
	
	@Override
	public void run() {
		while(true) {
			System.out.println( n + "초");
			n++;
			try {
				sleep(1000); //1초 동안 멈춤(1000ms) -> 깨어남(재개)
			} catch(Exception e) {
				return;
			}
		}
	 }		
  }

public class ThreadEx1 {

	public static void main(String[] args) {
		
		TimerThread th = new TimerThread();
		th.start();
	}

}
