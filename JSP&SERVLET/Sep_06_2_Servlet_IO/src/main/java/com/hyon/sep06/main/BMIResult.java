package com.hyon.sep06.main;

import java.io.File;
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
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * Servlet implementation class BMIResult
 */
@WebServlet("/BMIResult")
public class BMIResult extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		
		String path= request.getServletContext().getRealPath("img");
		
		
		MultipartRequest mr = new MultipartRequest(request, path,
		10*1024*1024,
		"UTF-8",
		new DefaultFileRenamePolicy()
		);
     			
		String name = mr.getParameter("NAME");
		double height = Double.parseDouble(mr.getParameter("HEIGHT"));
		double weight = Double.parseDouble(mr.getParameter("WEIGHT"));
		double bmi = weight/((height/100)*(height/100));
		String fileName = mr.getFilesystemName("PHOTO");
		String fat = "";
		
		if(bmi<18.5) fat = "저체중(멸치)";
		else if(bmi>=18.5 && bmi<25) fat = "정상(돼지아님)";
		else if(bmi>=25 && bmi<30) fat = "과체중(돼지입문)";
		else if(bmi>=30 && bmi<35) fat = "경도비만(초급돼지)";
		else if(bmi>=35 && bmi<40) fat = "중등도비만(중급돼지)";
		else if(bmi>=40) fat = "고도비만(고급돼지)";
		
		fileName = URLEncoder.encode(fileName, "UTF-8");
				
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><meta charset='UTF-8'</head>");
		out.print("<body>");
		out.printf("<h2>이름 : %s</h2>", name);
		out.printf("<h2>키 : %.1fcm</h2>", height);
		out.printf("<h2>몸무게 : %.1fkg</h2>", weight);		
		out.printf("<h2>BMI지수 : %.1f</h2>", bmi);		
		out.printf("<h2>비만도 : %s</h2>", fat);		
		out.printf("<img src='img/%s'>", fileName);
		out.print("</body>");
		out.print("</html>");
		
		}
}
