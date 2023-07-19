package oop20230719;

public class InsertSort {

	public static void main(String[] args) {
		//삽입정렬
		//[삽입법] 삽입정렬 개념을 학습후, (SWAP코드 없음) (배열내의 위치이동)
		//삽입정렬을 이용하여 배열 a의 오름차순과 내림차순한 결과를 출력하시오.
		//int[] a = {11,23,7,9,14};
		int[] a = {11,23,7,9,14};
		
		int key = 0,prev =0; //삽입 정렬의 키(삽입대상)       key값은 좌측영역과 우측영역 사이에 있다. 
		//1부터 마지막 원소까지 순회 (회전수)                   [[정렬o(작은 놈)  ] key[정렬 x        ]]
		for(int i=1; i<a.length; i++) {
			key = a[i];
			prev = i- 1;
			//첫 번째 원소까지 비교하면서 삽입해 나갑니다.
			while(prev >= 0 && a[prev]> key) {          //각 회전에서의 비교횟수(명확하지 않으므로 for이 아닌 while을 써야한다)
				a[prev + 1] = a [prev];
				prev--;
			}
			
			a[prev + 1] = key; //현재 prev + 1 위치에 temp값에 넣었던 arr[i]값을 넣어줍니다. 
		}
		
		System.out.println();
		System.out.println("===정렬 후===");
		for(int c:a) {
			System.out.println(c);
		}

	}

}
