package com.hyon.aug252.main;
import java.util.Date;

public class Reservation {
	
	  private int reservationNum;
	  private String reservationPersonSName;
      private Date reservationDay;
      private String reservationPersonSMobileNum;
      private String reservationRestaurantBranch;
	
      public Reservation() {
		super();
      }

	public Reservation(int reservationNum, String reservationPersonSName, Date reservationDay,
			String reservationPersonSMobileNum, String reservationRestaurantBranch) {
		super();
		this.reservationNum = reservationNum;
		this.reservationPersonSName = reservationPersonSName;
		this.reservationDay = reservationDay;
		this.reservationPersonSMobileNum = reservationPersonSMobileNum;
		this.reservationRestaurantBranch = reservationRestaurantBranch;
	}

	public int getReservationNum() {
		return reservationNum;
	}

	public void setReservationNum(int reservationNum) {
		this.reservationNum = reservationNum;
	}

	public String getReservationPersonSName() {
		return reservationPersonSName;
	}

	public void setReservationPersonSName(String reservationPersonSName) {
		this.reservationPersonSName = reservationPersonSName;
	}

	public Date getReservationDay() {
		return reservationDay;
	}

	public void setReservationDay(Date reservationDay) {
		this.reservationDay = reservationDay;
	}

	public String getReservationPersonSMobileNum() {
		return reservationPersonSMobileNum;
	}

	public void setReservationPersonSMobileNum(String reservationPersonSMobileNum) {
		this.reservationPersonSMobileNum = reservationPersonSMobileNum;
	}

	public String getReservationRestaurantBranch() {
		return reservationRestaurantBranch;
	}

	public void setReservationRestaurantBranch(String reservationRestaurantBranch) {
		this.reservationRestaurantBranch = reservationRestaurantBranch;
	}

	@Override
	public String toString() {
		return "Reservation [reservationNum=" + reservationNum + ", reservationPersonSName=" + reservationPersonSName
				+ ", reservationDay=" + reservationDay + ", reservationPersonSMobileNum=" + reservationPersonSMobileNum
				+ ", reservationRestaurantBranch=" + reservationRestaurantBranch + "]";
	};

      
    	
}	