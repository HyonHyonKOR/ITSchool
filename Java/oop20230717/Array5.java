package oop20230717;

public class Array5 {

	public static void main(String[] args) {
		// 順位、ランキング  
		
		//宣言、入力
		int[] score = {90,90,80,50,70};
		int[] rank = {1,1,1,1,1};          
		
		//処理
		for(int i=0; i<score.length; i++) { //등수를 구하는 대상(위치)            //30 = rank[0]  -> 1(me) -> 2 -> 3 ->4 ->5
		  for(int j=0; j<rank.length; j++) { //비교 횟수(5회)                 //90 = rank[1]  -> 1 -> 1(me)----------->1 
			 if(score[i]<score[j])                                        //80 = rank[2]  -> 1 -> 2 -> 2(me) ->2 ->2 
				rank[i]++;                           
		  }
		}                                           
		   
		
		//出力
		for(int i=0; i<score.length;i++) {
			System.out.println(score[i] + "点は"+rank[i] + "位です。");
		}
		
		

	}//main() end

}//Class end
