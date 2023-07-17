package oop20230717;

public class Array1 {

	public static void main(String[] args) {
		
		
	//日本語　８０点、英語　６０点　、　数学１００点
	//それぞれの科目点数を出力！
	//（１）変数１個のみ使用する
		
	int score;   //4byte
	score = 80;
	System.out.println("日本語点数　：" + score );
	score = 60;	
	System.out.println("英語点数　：" + score);	
	score = 100;	
	System.out.println("数学点数　：" + score);	
	//一括処理不可能、入力→処理→出力　区分不可能
		
		
		
		
		
		
		
	/*배열변수(stack) vs 배열(객체, heap)
	  배열(array) : 확장자료형 > 동질형 자료의 연속적 모임
	                                  (메모리 주소)
	                                  요소(element)
	                                  일괄처리(Batch, 배치)
		
	*/	
		
		String abab = "ABAB";
		String result = abab.replace("A","X").replace("B", "A").replace("X", "B");
		System.out.println(result);
		
	}

}
