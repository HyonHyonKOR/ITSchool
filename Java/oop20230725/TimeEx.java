package oop20230725;

public class TimeEx {

	public static void main(String[] args) {
		
		Time time = new Time();
		time.setHour(25);
		time.setHour(0);
		time.setMinute(60);
		time.setMinute(-1);
		time.setSecond(60);
		time.setSecond(-1);
		time.getTime();
		
	}

	}
	
class Time{
		
	private int hour = 0;
	private int minute = 0;
	private int second = 0;
	
	public void setHour(int hour) {
		if(hour>24 || hour<0) {
			System.out.printf("다시 입력해주세요. 현재의 hour: %d시\n", this.hour);
			return;
		}    
		else this.hour = hour;
		
		
	}
	public void setMinute(int minute) {
		if(minute>59 || minute<0) {
			System.out.printf("다시 입력해주세요. 현재의 minute: %d분\n", this.minute);
			return;
		}
		else	
		this.minute = minute;
	}
		
		
	public void setSecond(int second) {
		if(second>59 || second<0) {
			System.out.printf("다시 입력해주세요. 현재의 second: %d초\n", this.second);
			return;
		}	   
		else	
		this.second = second;
	}
	
	public void getTime() {
		System.out.printf("현재 시간은 %d시 %d분 %d초입니다.", hour,minute,second);
	}
	
	
}
	
