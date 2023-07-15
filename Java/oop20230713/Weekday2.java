package oop20230713;

public class Weekday2 {
	
    public static void main(String[] args) {
       
		int inputYear = 2023;
		int inputMonth =7;
		int inputDay =15;	
		
		boolean isLeapYear = (inputYear%4==0 && inputYear%100 !=0 || inputYear%400==0);
		
		int howManyLeapYear = 0;
		int howManyComnYear = 0;
		
		int preYearsOfDaysSum = 0;
		int preMonthsOfDaysSum = 0;
		int totalDaysSum =0;
		int whatDayIsToday =0;
		
		String whatDay = "";
		
		
		if(isLeapYear) {
			  
			  //평년 및 윤년 횟수
			  for(int startYear=1; startYear<inputYear; startYear++) {
				  
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
		      switch(inputMonth) {
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
			  totalDaysSum = preYearsOfDaysSum + preMonthsOfDaysSum + inputDay;
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
			  System.out.println("이번달까지의 일수 : " + inputDay);
			  System.out.println("오늘까지의 누적일수 :" + totalDaysSum);
			  System.out.printf("윤년 오늘은 %s입니다.\n" , whatDay);
		     
		}//if{}end  : Leap Year
		
		
		else{
			  
			  //평년 및 윤년 횟수
			  for(int startYear=1; startYear<inputYear; startYear++) {
				  
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
		      switch(inputMonth) {
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
			  totalDaysSum = preYearsOfDaysSum + preMonthsOfDaysSum + inputDay;
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
			  System.out.println("이번달까지의 일수 : " + inputDay);
			  System.out.println("오늘까지의 누적일수 :" + totalDaysSum);
			  System.out.printf("평년 오늘은 %s입니다.\n" , whatDay);
			     
		 }//else if{} end : Common Year
		
    }//main()end
 }//Class end
		

		
   