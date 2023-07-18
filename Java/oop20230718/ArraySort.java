package oop20230718;

public class ArraySort {

	public static void main(String[] args) {
		// (1) 選択ソート
		int[] a = new int[] {11,23,7,9,14};
        System.out.println("====整列前====");
		for(int idx : a) {
		System.out.printf("%d ", idx);
		}
		System.out.println();
		
		
		for(int i =0; i < 4; i++) {//総回転数(段階)数, 4段階(0,1,2,3)
			for(int j = i+1; j<5; j++ ) {//各回転の比較回数 (4->3->2->1) 
				if(a[i] > a[j]) {    //前 > 後:  (小->大)
					              //前 < 後 : 降順(大->小)
				//swap	
			    int temp = a[i];
				    a[i] = a[j];
				    a[j] = temp;
				}		 		
			} //(j)for end
		System.out.printf("\n==[%d回転語]==\n" , i+1);
		for(int idx = 0; idx<5; idx++) {
			System.out.printf("%d ", a[idx]);
			
		} //(i) for end
		System.out.println();
	  } 
		
		System.out.println();
		System.out.println("====整列後====");
		
		for(int idx = 0; idx<5; idx++) {
			System.out.printf("%d ", a[idx]);
   
	    }		
   }
}
