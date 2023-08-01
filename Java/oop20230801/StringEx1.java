package oop20230801;

import java.util.Arrays;

public class StringEx1 {

	public static void main(String[] args) {
		
		String[] friends = { "Jack", "John", "Aman", "Brute", "Hank", "Canny", "Lee", "Louis", "June", "Frank" };
		
		for(int i=0; i<friends.length-1;i++) {
			for(int j=i+1; j<friends.length; j++) {
				if(friends[i].compareTo(friends[j])>0) {
						String temp = friends[i];
						friends[i]  = friends[j];
						friends[j]  = temp;		
				
				}
			  }
		}
		
		System.out.println(Arrays.toString(friends));

	}

}
