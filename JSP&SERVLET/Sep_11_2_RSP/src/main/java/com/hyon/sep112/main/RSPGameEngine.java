package com.hyon.sep112.main;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;

public class RSPGameEngine {
	
	private static final RSPGameEngine rspr = new RSPGameEngine();
	private RSPGameEngine(){}
	
	public static RSPGameEngine getInstance() {
		return rspr;
	}
	
	private int win;
	private int draw;
	private int lose;	 
	
	public void result(HttpServletRequest request) throws UnsupportedEncodingException {
		
		
		request.setCharacterEncoding("UTF-8");
	
		int player = Integer.parseInt(request.getParameter("userhand"));	
		request.setAttribute("user", player+".png");
		
		int com =new Random().nextInt(3)+1;		
		request.setAttribute("com", com+".png");
		
		if(player-com == 0) {
			request.setAttribute("r", "무승부");
			draw++;
		}
		else if(player-com == 1 || player-com == -2){
			request.setAttribute("r", "승리");
			win++;
		}
		else
		{
		    request.setAttribute("r", "패배");
			lose++;
		}
		
		request.setAttribute("w", win + "승");
		request.setAttribute("d", draw + "무");
		request.setAttribute("l", lose + "패");
		
	}

	public void init() {
		win=0;
		draw=0;
		lose=0;
	}
	   
}
