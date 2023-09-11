package com.hyon.sep911.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class C
 */
@WebServlet("/C")
public class C extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getParameterNames().hasMoreElements()) {
			request.setAttribute(getServletName(), response);
			request.setAttribute("uh", "../css/gogae.gif");
			request.setAttribute("ch", "../css/gogae.gif");
		}else {
			RSPGameEngine rge = RSPGameEngine.getRspg();
			rge.doRSP(request);
		}
		request.getRequestDispatcher("rsp.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RSPGameEngine rge = RSPGameEngine.getRspg();
		rge.reset(request);
		request.setAttribute("uh", "../css/gogae.gif");
		request.setAttribute("ch", "../css/gogae.gif");
		request.getRequestDispatcher("rsp.jsp").forward(request, response);
	}

}
