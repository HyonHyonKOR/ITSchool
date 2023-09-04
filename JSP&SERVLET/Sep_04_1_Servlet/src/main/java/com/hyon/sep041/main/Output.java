package com.hyon.sep041.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Output
 */
@WebServlet("/Output")
public class Output extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//파일 업로드에는 아래 인코딩 방식이 안통하므로, 이번에는 사용하지 않는다.
		
		//기존(선생님 그림설명 내 주황색) 방식으로 전송된 파라미터를 한글처리하려면?
		//request.setCharacterEncoding("UTF-8");
			
		//기존 방식으로 전송된 파라미터를 UTF로 읽어오려면?
		//String title = request.getParameter("title");
				
		response.setCharacterEncoding("UTF-8");
				
		// 파일을 업로드하려면, 파일 전송을 위해 만들어둔 폴더의 "절대경로" 를 입력해야 한다.
				
		String path = request.getServletContext().getRealPath("img"); // 전송을 위한 폴더 명이 img였다.
		System.out.println(path);
				
		// 파일 실제 업로드하기 : 기존의 request를 얘가 대신할 예정, request와 위 파일전송 경로를 받아서 생성됨
		MultipartRequest mr = new MultipartRequest(
		request, path,
		//아래는 허용할 파일의 최대 크기
		10 * 1024 * 1024,
		//요청파라미터의 인코딩 방식을 지정 : 위 주석처리한 인코딩 지정 코드들을 대체함.
		"UTF-8", 
		//업로드하려는 파일 명이 중복될 떄의 처리 방식 지정
		//현재는 중복 시에, 파일명 뒤에 숫자를 붙여나가는 방식으로 간다.
		new DefaultFileRenamePolicy()
		);
				
		//이후로는 기존의 JSP를 이용하는 방식과 동일하다.
				
		String title = mr.getParameter("title");
				
		// 업로드할 파일명(중복처리 포함)
		String fileName = mr.getFilesystemName("photo");
				
		// DB(Oracle)에 파일명을 저장해야 한다면, 용량을 "상당히" 여유있게 만들어야 한다.
		// 이유 : 톰캣은 한글로 된 파일명을 인식하지 못하기 때문에, 한글파일명을 3바이트로 쪼개서 보관하여 용량이 커지기 때문.
		// 예시 : f_name varchar2(200 char)
				
		fileName = URLEncoder.encode(fileName, "UTF-8");
		fileName = fileName.replace("+", " ");
				
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><meta charset='UTF-8'</head>");
		out.print("<body>");
				
		out.printf("<h1>제목 : %s</h1>", title);
		out.printf("<h1>파일명 : %s</h1>", fileName);
		out.printf("<img src='img/%s'>", fileName);
				
		out.print("</body>");
		out.print("</html>");
	}

}
