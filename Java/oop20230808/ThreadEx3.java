package oop20230808;

public class ThreadEx3 {

	public static void main(String[] args) {
		
		long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority();
		Thread.State s = Thread.currentThread().getState();
		
		System.out.println("Thread id : " +  id);
		System.out.println("Thread name : " + name);
		System.out.println("Thread Priority : " + priority);
		System.out.println("Thread status : " + s);
	}

}
