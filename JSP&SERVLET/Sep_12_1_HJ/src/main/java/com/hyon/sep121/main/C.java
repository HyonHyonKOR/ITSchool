package com.hyon.sep121.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/C")
public class C extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getParameterNames().hasMoreElements()) {
		    request.setAttribute("r", 0);
	        request.setAttribute("w", 0);
	        request.setAttribute("l", 0);
	        request.setAttribute("g","승부를 시작하세요");
	        request.setAttribute("wr", "전적 없음");	
		}else{
		HJGameEngine hjg = HJGameEngine.getInstance();
		hjg.getResult(request);
		}
		request.getRequestDispatcher("HJ.jsp").forward(request, response);
	    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HJGameEngine hjg = HJGameEngine.getInstance();
		hjg.reset(request);
		 request.setAttribute("r", 0);
	     request.setAttribute("w", 0);
	     request.setAttribute("l", 0);
	     request.setAttribute("g","승부를 시작하세요");
	     request.setAttribute("wr", "전적 없음");
		request.getRequestDispatcher("HJ.jsp").forward(request, response);
	    }

}
