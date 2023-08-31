package com.hyon.aug313.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		String 
		
		out.print("<html>");
		out.print("<head><title>Hello!</title><meta charset='UTF-8'>");
		out.print("</head>");
		out.print("<body>");
		out.print("아아아");
		out.print("</body>");
		out.print("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String input = request.getParameter("input");
		PrintWriter out = response.getWriter();

		doGet(request, response);
	}

}
