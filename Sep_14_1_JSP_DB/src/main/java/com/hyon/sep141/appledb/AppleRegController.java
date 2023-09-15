package com.hyon.sep141.appledb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppleRegController")
public class AppleRegController extends HttpServlet {
          
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("cp", "apple/applereg.jsp");
   	request.getRequestDispatcher("index.jsp").forward(request, response);		
   	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	AppleDBManager.getInstance().insertTable(request);
	AppleDBManager.getInstance().showTable(request);
	request.setAttribute("cp", "apple/apple.jsp");
	request.getRequestDispatcher("index.jsp").forward(request, response);	
	}
}
