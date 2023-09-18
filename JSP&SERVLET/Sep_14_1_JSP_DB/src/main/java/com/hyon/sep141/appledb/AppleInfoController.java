package com.hyon.sep141.appledb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AppleInfoController")
public class AppleInfoController extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(AppleDBManager.getInstance().searchApples(request)){
		request.setAttribute("cp", "apple/appleInfo.jsp");
		}
		else{
		AppleDBManager.getInstance().groupApples(1, request);
		}	
		request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(AppleDBManager.getInstance().updateApple(request)) {
		request.setAttribute("cp", "apple/apple.jsp");
		}
		else{request.setAttribute("cp", "apple/apple.jsp");
		}
		AppleDBManager.getInstance().groupApples(1, request);
		request.getRequestDispatcher("index.jsp").forward(request, response);		
		}
}
