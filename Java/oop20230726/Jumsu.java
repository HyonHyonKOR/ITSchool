package oop20230726;

//f
public class Jumsu {
	private int no;
	private String name;
	private int[] answer = new int[5]; //답안 제출
	private char[] ox = new char[5]; //'O' or 'X'
	public int score;
	public int rank;
//f end	
//c	
public Jumsu() {}

public Jumsu(int no, String name, int a, int b, int c, int d, int e){
	this.no = no; 
	this.name = name;
	this.answer[0] = a;
	this.answer[1] = b;
	this.answer[2] = c;
	this.answer[3] = d;
	this.answer[4] = e;
	this.rank = 1;
}//c end
	
//m

public void compute() {
	
	int[] dap = {3,3,3,3,3};
	for(int idx = 0; idx<dap.length; idx++) {
		if(dap[idx] == answer[idx]) {
			ox[idx] = 'O';
			score = score + 20;
		}else {
			ox[idx] ='X';
		}
	  }	
   }

public void disp() {
	System.out.print(this.no+" ");
	System.out.print(this.name+" ");
	System.out.print(this.ox[0]+" ");
	System.out.print(this.ox[1]+" ");
	System.out.print(this.ox[2]+" ");
	System.out.print(this.ox[3]+" ");
	System.out.print(this.ox[4]+" ");
	System.out.print(this.score+" ");
	System.out.print(this.rank+" ");
	System.out.println();
}


	
	

}
