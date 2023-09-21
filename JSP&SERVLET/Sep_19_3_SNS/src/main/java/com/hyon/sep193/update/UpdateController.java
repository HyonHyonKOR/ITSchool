package com.hyon.sep193.update;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyon.sep193.main.DateManager;
import com.hyon.sep193.member.MemberDAO;


@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MemberDAO.getMdao().loginCheck(request)) {
		DateManager.getCurYear(request);
		request.getRequestDispatcher("db/update.jsp").forward(request, response);
		}
	}	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MemberDAO.getMdao().loginCheck(request)) {
		DateManager.getCurYear(request);
		MemberDAO.getMdao().update(request);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
