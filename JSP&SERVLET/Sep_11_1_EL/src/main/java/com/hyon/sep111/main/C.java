package com.hyon.sep111.main;

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
	//어떤 사이트 첫 접속: GET방식
	//만약에 V1.html에서 버튼 눌렀을 때 GET방식을 써야한다면 ...?
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//요청파라미터명이 없으면 => 이 사이트 첫 접속
	if(!request.getParameterNames().hasMoreElements()) {
		request.getRequestDispatcher("V1.html").forward(request, response);
	}else {
	//요청파라미터명이 있으면 => 사이트의 기능활용을 GET 방식
	   M.multiply(request);
	   request.getRequestDispatcher("V2.jsp").forward(request, response);
	  }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
