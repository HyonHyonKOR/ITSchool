package oop20230725;

public class CalculatorEx {

	public static void main(String[] args) {

	}
	
	private int num1;
	private int num2;


	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	public int add() {
		return this.num1 + this.num2;
	}
	
	public int min() {
		return this.num1 - this.num2;
	}
	
	public int mul() {
		return this.num1 * this.num2;
	}
	
	public int div() {
		if(num2==0) {
			System.out.println("0으로 나눌 수 없습니다. 두 숫자를 다시 입력해주세요");
			return 0;
		}
		else {
		return this.num1 / this.num2;
		}
	}

}
