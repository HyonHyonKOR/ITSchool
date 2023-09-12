package com.hyon.sep122.main;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;

public class NBEngine {
	private int round=0;  
	private int strike=0;
	private int ball=0;
	private String comNum="";
	
	private static final NBEngine nbe = new NBEngine();
			
	private NBEngine() {}

	public static NBEngine getNBEngine() {
		return nbe;
	}

	public void pickNum() {
		HashSet<String> set = new HashSet<>();
		while(set.size()!=3) {
			set.add(new Random().nextInt(10)+"");
		}
		
		ArrayList<String> list = new ArrayList<String>(set);
		Collections.shuffle(list);
		
		for (String num : list) {
		  comNum += num;
		} 
		
		
	}
	
	public void checkNum(HttpServletRequest request) throws UnsupportedEncodingException {
		if(comNum.length()!=3) {
			pickNum();
		}
		request.setCharacterEncoding("UTF-8");
		String userNum = request.getParameter("num");
		
		for(int i=0; i<userNum.length();i++) {
			for(int j=0; j<comNum.length();j++) {
			  if(userNum.charAt(i) == comNum.charAt(j)&& i==j) {
				  strike++;
			  }
			  else if(userNum.charAt(i) == comNum.charAt(j)&& i!=j) {
				  ball++;
			  }
			}
		}
		
		round++;
		request.setAttribute("s",strike +"Strike!!");
		request.setAttribute("b",ball + "ball!!");
		request.setAttribute("r", round +"th Round");
		request.setAttribute("c",comNum);
		strike=0;
		ball=0;
	}
	
	public void reset() {
		round=0;  
		strike=0;
		ball=0;
		comNum="";
	}
	
}
