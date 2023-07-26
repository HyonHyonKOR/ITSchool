package oop20230725;

public class Tv {
	int channel;
	void channelUp() {
		channel++;
	}
	void channelDown() {
		channel--;
	}
	
	public static void main(String[] args) {
		Tv v1 = new Tv();
		v1.channel =7;
		v1.channelUp();
		System.out.println(v1.channel);
	}

}
