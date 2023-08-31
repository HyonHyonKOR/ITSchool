package com.hyon.aug313.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int result = x + y;

		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Hello!</title><meta charset='UTF-8'>");
		// out.print("<style>");
		// out.print("table { border-collapse: collapse; width: 300px; margin: auto;
		// margin-top: 50px; }");
		// out.print("th, td { border: 1px solid black; padding: 8px; text-align:
		// center; }");
		// out.print("th { background-color: #f2f2f2; width: 50px; }");
		// out.print("th:nth-child(odd) { background-color: #d9d9d9; }");
		// out.print("td { background-color: #f9f9f9; }");
		// out.print("</style>");

		out.print("</head>");
		out.print("<body>");
		out.print("아아아");
		out.print("<table>");
		out.print("<tr>");
		out.print("<th>X</th>");
		out.print("<td>" + x + "</td>");
		out.print("<th>Y</th>");
		out.print("<td>" + y + "</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<th colspan='2'>결과는</th>");
		out.print("<td colspan='2'>" + result + "</td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
