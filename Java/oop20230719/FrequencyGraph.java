package oop20230719;

public class FrequencyGraph {

	public static void main(String[] args) {
		
		int[] number = new int[100];
		int[] counter = new int[10];

		for(int i=0; i<number.length; i++) {
			number[i] = (int)(Math.random()*10);
			switch(number[i]) {
			case 0: counter[0]++;  break;
			case 1: counter[1]++;  break;
			case 2: counter[2]++;  break;
			case 3:	counter[3]++;  break;
			case 4: counter[4]++;  break;
			case 5: counter[5]++;  break;
			case 6: counter[6]++;  break;
			case 7:	counter[7]++;  break;
			case 8:	counter[8]++;  break;
			case 9:	counter[9]++;  break;
			}
			System.out.print(number[i]);
		}
		    System.out.println();
		
		
		    int count = 0;
		     for(int i=0; i<counter.length; i++) {
			 System.out.print(i+ "의 개수: ");
			    for(int j=0;j<counter[i];j++) {
			    count++;
			    System.out.print("#");
			   }
			System.out.print(" "+count);
		    count =0;
			System.out.println();
		}
		
	}

}
/*
// int[] number = new int[100];
// int[] counter = new int[10];

​

[결과][예]
0680620805880442322786217701163149015988171591256896095473209613223300098055181460576100855486850687
0의 개수 : ################# 17
1의 개수 : ############ 12
2의 개수 : ######### 9
3의 개수 : ###### 6
4의 개수 : ###### 6
5의 개수 : ########### 11
6의 개수 : ########### 11
7의 개수 : ####### 7
8의 개수 : ############## 14
9의 개수 : ####### 7


*/