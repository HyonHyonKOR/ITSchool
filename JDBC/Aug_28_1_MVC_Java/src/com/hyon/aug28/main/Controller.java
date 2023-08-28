package com.hyon.aug28.main;

import java.util.ArrayList;

import com.hyon.aug28.reservation.Reservation;
import com.hyon.aug28.torikizoku.Torikizoku;

public class Controller {
    	
	public static void main(String[] args) {
	
		int menu;
		String result;
		Torikizoku t = null;
		Reservation r = null;
		ArrayList<Torikizoku> tlist = null;
		ArrayList<Reservation> rlist = null;
		
		System.out.println("Torikizoku Program Start!");
		while(true) {
			try {
				menu =ConsoleScreen.showMenu();
				if(menu==9) {
					System.out.println("bye bye");
					System.exit(0);
				}
				else if(menu==1) {
					r = ConsoleScreen.ShowReserveEnrollMenu();
					result = DAO.insertReservation(r);
					ConsoleScreen.printResult(result);
				    }
				else if(menu==2) {
					t = ConsoleScreen.showTorikiEnrollMenu();
					result = DAO.insertTorikizoku(t);
					ConsoleScreen.printResult(result);
					}
				else if(menu==3) {
					  rlist = DAO.selectAllReserve();
				      ConsoleScreen.showReserveListResultMenu(rlist);
					}
				else if(menu==4) {
					tlist = DAO.selectAllToriki();
					ConsoleScreen.showTorikiListResultMenu(tlist); 
					}
				else if(menu==5) {ConsoleScreen.printResult(null);}
				else if(menu==6) {ConsoleScreen.printResult(null);}
				else if(menu==7) {ConsoleScreen.printResult(null);}
				else if(menu==8) {ConsoleScreen.printResult(null);}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}//main
}//class
