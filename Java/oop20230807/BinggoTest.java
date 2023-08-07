package oop20230807;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;


public class BinggoTest {

	public static void main(String[] args) {
		
		HashSet<Integer> set = new HashSet<>();
		Random random = new Random(System.currentTimeMillis());
 		int[][] bingo = new int[5][5];
		
		while(set.size()!=25) {
			int num = (random.nextInt(49)+1);
			set.add(num);
		}
			
		ArrayList<Integer> list = new ArrayList<Integer>(set);
		Collections.shuffle(list);
		Iterator<Integer> iter = list.iterator();
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				bingo[i][j] = iter.next();
				System.out.printf("%2d ", bingo[i][j]);
			}
			System.out.println();
		}	
			
	 }
}


