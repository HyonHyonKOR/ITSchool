package com.hyon.sep121.main;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class HJGameEngine {
	private int round=0;	
	private int win=0;
	private int lose=0;
	
	private static final HJGameEngine hje = new HJGameEngine(); 
	
	private HJGameEngine() {}
	
	public static HJGameEngine getInstance() {
		return hje;
	}
	
	public void getResult(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		
		int user = Integer.parseInt(request.getParameter("oe"));
		if(user==1) {
			request.setAttribute("u", "홀");
		}
		else {
			request.setAttribute("u", "짝");
		}
		
		int com = new Random().nextInt(10)+1;
		request.setAttribute("c", com);
		
        if((com%2)==user) {
        	win++;
        	round++;
        	request.setAttribute("g", "승리하셨습니다");
        }
        else{
        	lose++;
        	round++;
        	request.setAttribute("g", "패배하셨습니다");
        }
	
        request.setAttribute("r", round);
        request.setAttribute("w", win);
        request.setAttribute("l", lose);
     
        
        Double winrate = (double)win/round*100;
        String wr = String.format("%.2f", winrate);
        request.setAttribute("wr", wr + "%");
	}
	
	public void reset(HttpServletRequest request) {
		round=0;
		win = 0;
		lose =0;
	} 
		
}
