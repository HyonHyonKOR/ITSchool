package com.hyon.sep193.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hyon.sep193.member.MemberDAO;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mdao = MemberDAO.getMdao();
		mdao.login(request, response);
		if(mdao.loginCheck(request)) {
			request.setAttribute("lp","login/loginSuccess.jsp");
		}else {
			request.setAttribute("lp","login/login.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
