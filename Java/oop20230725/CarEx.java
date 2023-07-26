package oop20230725;

public class CarEx {

	public static void main(String[] args) {
		
		Car car1 = new Car("Ford","Focus","Red");
		car1.increaseSpeed(255);
		car1.decreaseSpeed(255);
		car1.showCarInfo();

	}
}



 class Car {
 
 private String type;	 
 private String model;	 
 private String color;	 
 private int speed =0;	 
 	
 Car(String type,String model,String color){
	 this.type = type;
	 this.model = model;
	 this.color = color;
 }
 
 public void increaseSpeed(int speed) {
	 if(this.speed>=250 || speed>250) {
		 this.speed =250;
		 System.out.println("차량의 한계 속도를 넘었습니다.");
		 return;
		 
	 }
	 else if(speed<0) {
		 System.out.println("증가하는 스피드는 음수가 될 수 없으므로 다시 입력해주세요.");
		 return;
	 }
	 else {
	 this.speed = speed;
	 System.out.printf("speed를 %d를 증가시켰습니다. 현재 속도는 %dkm/h\n", speed,this.speed);
 
	 }
  }
 public void decreaseSpeed(int speed) {
	 if(this.speed==0) {
		 System.out.println("Speed가 0이므로 감속이 불가능합니다."); 
		 return;
	 }
	 else if(speed>this.speed) {
		 this.speed=0;
		 System.out.println("Speed가 0이므로 이 이상 감속이 불가능합니다.");
		 return;	 
	 }
	 else if(speed<0) {
		 System.out.println("감소하는 스피드는 음수가 될 수 없으므로 다시 입력해주세요.");
		 return;
	 }
	 else this.speed -= speed;
	 System.out.printf("speed를 %d를 감소시켰습니다. 현재 속도는 %dkm/h\n", speed,this.speed);
 }
 
 public void showCarInfo() {
	 System.out.printf("%s사의 %s의 색상은 %s이며 현재 속도는 %dkm/h입니다.\n",type,model,color,speed);
 }
	
 }





