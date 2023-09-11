package com.hyon.sep112.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	//Java + JSP + CSS + Servlet
	// 가위바위보 게임 페이지를 만들 것!
	// 디자인은 알아서... (가위/바위/보 이미지를 누르면 게임 한판 진행)
	// WAS 종료할 때까지 전적은 쌓이게 => 매판 진행할 때마다 전적 보이도록(바뀌도록)
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if(!request.getParameterNames().hasMoreElements()) {
		request.setAttribute("user", "https://upload.wikimedia.org/wikipedia/commons/8/88/Start_%28%D0%BA%D0%B8%D0%BD%D0%BE%D1%82%D0%B5%D0%B0%D1%82%D1%80%29.jpg");
		request.setAttribute("com", "https://upload.wikimedia.org/wikipedia/commons/8/88/Start_%28%D0%BA%D0%B8%D0%BD%D0%BE%D1%82%D0%B5%D0%B0%D1%82%D1%80%29.jpg");
	}else {
		RSPGameEngine r = RSPGameEngine.getInstance();
		r.result(request);
	}
	 request.getRequestDispatcher("RSPresult.jsp").forward(request, response);
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
