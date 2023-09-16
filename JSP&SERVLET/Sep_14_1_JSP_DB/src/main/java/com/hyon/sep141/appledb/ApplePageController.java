package com.hyon.sep141.appledb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ApplePageController")
public class ApplePageController extends HttpServlet {

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppleDBManager adm =AppleDBManager.getInstance();
		int pageNum = Integer.parseInt(request.getParameter("page"));
		adm.makeAllPages(request);
		adm.groupApples(pageNum,request);
		request.setAttribute("cp", "apple/apple.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
