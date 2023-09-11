package com.hyon.sep911.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class RSPGameEngine {

	private static final RSPGameEngine rspg = new RSPGameEngine();
	
	private RSPGameEngine() {
		
	}
	
	
	
	public static RSPGameEngine getRspg() {
		return rspg;
	}



	private int t;
	private int win;
	private int draw;
	private int lose;
	
	
	
	public void doRSP(HttpServletRequest request) {
		int userHand = Integer.parseInt(request.getParameter("userHand"));
		request.setAttribute("uh", userHand + ".jpg");
		
		int comHand = new Random().nextInt(3)+1;
		request.setAttribute("ch", comHand + ".jpg");
		
		//판정
		int result = userHand - comHand;
		if(result == 0) {
			request.setAttribute("r", "무");
			draw++;
			t++;
		}else if(result == -1 || result == 2) {
			request.setAttribute("r", "패");
			lose++;
			t++;
		}
		else {
			request.setAttribute("r", "승");
			win++;
			t++;
	   } 
		
		
		request.setAttribute("t", t + "전");
		request.setAttribute("w", win + "승");
		request.setAttribute("d", draw + "무");
		request.setAttribute("l", lose + "패");
	
	}
	
	public void reset(HttpServletRequest request) {
		t = 0;
		win = 0;
		draw = 0;
		lose = 0;
	}



	
	
}
