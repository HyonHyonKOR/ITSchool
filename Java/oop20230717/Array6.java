package oop20230717;

public class Array6 {

	public static void main(String[] args) {
		
		
		int[] scores = {52,53,54,95,55,60,61,63,67,70,75,100};
		int[] rank = new int[scores.length];
		
		for(int i=0; i<scores.length; i++) {
			rank[i]=1;
		}
		
		for(int i=0; i<scores.length; i++) {
			for(int j=0; j<rank.length; j++) {
				if(scores[i] < scores[j])
					rank[i]++;
			}
		}
		
		for(int i=0; i<scores.length;i++) {
			System.out.println(scores[i] + "点は"+rank[i] + "位です。");
		}
	
	}

}
