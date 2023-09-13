package com.hyon.sep133.main;

import javax.servlet.http.HttpServletRequest;

public class Calculator {

	public static void Calculate(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		int plus = x+y;
		int minus =x-y;
		int multiply =x*y;
		int divide =x/y;
		
		
		request.setAttribute("plus",plus);
		request.setAttribute("minus",minus);
		request.setAttribute("divide",divide);
		request.setAttribute("multiply",multiply);
	}
	
}
