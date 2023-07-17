package oop20230713;

public class Weekday {

	public static void main(String[] args) {
		
	    setDay(2023, 7, 15);  // 원하는 날짜를 입력해주세요.
	    getWhatDayIsToday();  // 입력하신 날짜의 요일을 출력합니다.
	    
	    setDay(year, month, day);
	    
	 }//Main end;
	    
	
	
	    public static void setDay(int inputYear, int inputMonth, int inputDay) {
	       year =  inputYear; 
	       month = inputMonth;
	       day =   inputDay;
	       isLeapYear = (year%4==0 && year%100 !=0 || year%400==0);
	       
	     }
	    
	    public static void getWhatDayIsToday(){
	    	
	       if(isLeapYear) {
				  //평년 및 윤년 횟수
				  for(int startYear=1; startYear<year; startYear++) {
					  
					  if(startYear%4==0 && startYear%100 !=0 || startYear%400==0) {
						  howManyLeapYear++;
					  }
					  else {
						  howManyComnYear++;
					  }
					  
				  }
			  
				  //작년까지의 누적 일수
			      preYearsOfDaysSum =(366*howManyLeapYear)+(365*howManyComnYear);
					
		      
			      //이전 달까지의 누적 일수
			      switch(month) {
			      case 1: break;
			      case 2: preMonthsOfDaysSum= 31; break;
			      case 3: preMonthsOfDaysSum= 60; break; //+29
			      case 4: preMonthsOfDaysSum= 91; break;
			      case 5: preMonthsOfDaysSum= 121;break;	 
			      case 6: preMonthsOfDaysSum= 152;break;
			      case 7: preMonthsOfDaysSum= 182;break;
			      case 8: preMonthsOfDaysSum= 213;break;
			      case 9: preMonthsOfDaysSum= 244;break;
			      case 10:preMonthsOfDaysSum= 274;break; 
			      case 11:preMonthsOfDaysSum= 305;break;
			      case 12:preMonthsOfDaysSum= 335;break;
			      }	
			    	      
			      
				  //오늘까지의 누적 일수    
				  totalDaysSum = preYearsOfDaysSum + preMonthsOfDaysSum + day;
				  whatDayIsToday = totalDaysSum%7;
				     
				  
				  //누적 일수를 통해 요일 산출 	    
				  switch(whatDayIsToday) {
				  case 0 : whatDay = "일요일"; break;
				  case 1 : whatDay = "월요일"; break;
				  case 2 : whatDay = "화요일"; break;
				  case 3 : whatDay = "수요일"; break;
				  case 4 : whatDay = "목요일"; break;
				  case 5 : whatDay = "금요일"; break;
				  case 6 : whatDay = "토요일"; break;
		    	  }	  
				     
				  System.out.println("평년횟수 : " + howManyComnYear);
				  System.out.println("윤년횟수 : " + howManyLeapYear);
				  System.out.println("작년까지의 누적일수 : " + preYearsOfDaysSum);
				  System.out.println("저번달까지의 누적일수 : " + preMonthsOfDaysSum);
				  System.out.println("이번달까지의 일수 : " + day);
				  System.out.println("오늘까지의 누적일수 :" + totalDaysSum);
				  System.out.printf("%d년 %d월 %d일은 %s입니다.\n" ,year,month,day,whatDay);
			     
			}//if{}end  : Leap Year
			
			
			else
			{
				  
				  //평년 및 윤년 횟수
				  for(int startYear=1; startYear<year; startYear++) {
					  
					  if(startYear%4==0 && startYear%100 !=0 || startYear%400==0) {
						  howManyLeapYear++;
					  }
					  else {
						  howManyComnYear++;
					  }
					  
				  }
			  
				  //작년까지의 누적 일수
			      preYearsOfDaysSum =(366*howManyLeapYear)+(365*howManyComnYear);
				
			      
				  //이전 달까지의 누적 일수
			      switch(month) {
			      case 1: break;
			      case 2: preMonthsOfDaysSum= 31; break;
			      case 3: preMonthsOfDaysSum= 59; break; //+28
			      case 4: preMonthsOfDaysSum= 90; break;
			      case 5: preMonthsOfDaysSum= 120;break;	 
			      case 6: preMonthsOfDaysSum= 151;break;
			      case 7: preMonthsOfDaysSum= 181;break;
			      case 8: preMonthsOfDaysSum= 212;break;
			      case 9: preMonthsOfDaysSum= 243;break;
			      case 10:preMonthsOfDaysSum= 273;break; 
			      case 11:preMonthsOfDaysSum= 304;break;
			      case 12:preMonthsOfDaysSum= 334;break;
			      }	
			      
			    	        
				  //오늘까지의 누적 일수    
				  totalDaysSum = preYearsOfDaysSum + preMonthsOfDaysSum + day;
				  whatDayIsToday = totalDaysSum%7;
				     
				  
				  //누적 일수를 통해 요일 산출 	    
				  switch(whatDayIsToday) {
				  case 0 : whatDay = "일요일"; break;
				  case 1 : whatDay = "월요일"; break;
				  case 2 : whatDay = "화요일"; break;
				  case 3 : whatDay = "수요일"; break;
				  case 4 : whatDay = "목요일"; break;
				  case 5 : whatDay = "금요일"; break;
				  case 6 : whatDay = "토요일"; break;
		    	  }	  
				     
				  
				  System.out.println("지금까지의 평년횟수 : " + howManyComnYear);
				  System.out.println("지금까지의 윤년횟수 : " + howManyLeapYear);
				  System.out.println("작년까지의 누적일수 : " + preYearsOfDaysSum);
				  System.out.println("저번달까지의 누적일수 : " + preMonthsOfDaysSum);
				  System.out.println("이번달까지의 일수 : " + day);
				  System.out.println("오늘까지의 누적일수 :" + totalDaysSum);
				  System.out.printf("%d년 %d월 %d일은 %s입니다.\n" ,year,month,day,whatDay);
				     
			 }//else {} end : Common Year

	       
	        

	     }//method end
	    
		   private static int year;
		   private static int month;
		   private static int day;
		   private static boolean isLeapYear = (year%4==0 && year%100 !=0 || year%400==0);
		   private static int howManyLeapYear = 0;
		   private static int howManyComnYear = 0;
		   private static int preYearsOfDaysSum = 0;
		   private static int preMonthsOfDaysSum = 0;
		   private static int totalDaysSum =0;
		   private static int whatDayIsToday =0;
		   private static String whatDay = "";


	  }//Class end