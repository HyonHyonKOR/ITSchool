package oop20230718;

public class WeekdayArray {
	
    public static void main(String[] args) {

    	setDays(2023, 7, 18);
    	getDay();
    	
	}//main()end
	
	
	
	public static void setDays(int iyear, int imonth, int iday) {
		year = iyear;
		month = imonth;
		day = iday;
       }
	
		private static int year; 
		private static int month; 
		private static int day;
		private static int hap = 0;  //변수 hap : 총날수
		
		
	 public static void getDay() {	
		//(1) 서기 1년 ~ 서기 2022년
		for(int y = 1; y < year; y++) {
			if(y%4 == 0 && y%100 != 0 || y%400==0) {   //y가 윤년이니(판단)?
				hap += 366;
			} else {
				hap += 365;
			}
			
		}//for end
		
		//(2) 2023년(당해년) 1월~12월
	               //0월 1월 	2월  3월 4월
		int[] mon = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31}; 
		if(year%4 == 0 && year%100 != 0 || year%400==0) { //cYear가 윤년이니(판단)?
			mon[2] = 29;
		}
		for(int m = 1; m < month; m++ ) { //2023년의 1월~6월까지의 총날수
			hap +=mon[m];
		}
		
		//(3) (해당월) 7월의 날수
		hap += day;
		
		//System.out.println(hap); //738719
		switch(hap % 7) {
		case 0: System.out.println("일"); break;
		case 1: System.out.println("월"); break;
		case 2: System.out.println("화"); break;
		case 3: System.out.println("수"); break;
		case 4: System.out.println("목"); break;
		case 5: System.out.println("금"); break;
		case 6: System.out.println("토"); break;
		}
		
	    	
	 }

}//class end
