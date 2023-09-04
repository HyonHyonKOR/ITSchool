package com.hyon.aug313.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignInResult")
public class SignInResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");
		String gd = request.getParameter("GD");
		String lc = request.getParameter("LC");
		String[] hb = request.getParameterValues("HB");
		String ind = request.getParameter("IND");
		
		//textarea에서의 엔터 : \r\n
		//웹페이지에서의 줄바꾸기 : <br>
		ind = ind.replace("\r\n", "<br>");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>회원가입결과</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		out.print("<h1>회원가입결과</h1>");
		out.printf("<h2>ID :%s<h2>",id);
		out.printf("<h2>PW :%s<h2>",pw);
		out.printf("<h2>성별 :%s<h2>",gd);
		out.printf("<h2>지역:%s<h2>",lc);
		if(hb!=null) {
			out.print("<h2>취미 :");
			for(String s : hb) {
				out.print(s + "");
			}
			out.print("</h2>");
		}
		
		out.printf("<h2>자기소개 : %s</h2>",ind);
		out.print("</body>");
		out.print("</html>");
		
	}

}
