package com.hyon.sep08.main;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class Doctor {
	public static void calculateBMIResult(HttpServletRequest request) throws IOException {
			
	request.setCharacterEncoding("UTF-8");
	String path = request.getServletContext().getRealPath("img");
	
	MultipartRequest mr = new MultipartRequest(request, path, 1024*1024*10,"UTF-8", new DefaultFileRenamePolicy()
	);
	
	String name = mr.getParameter("NAME");
	double height = Double.parseDouble(mr.getParameter("HEIGHT"));
	double weight = Double.parseDouble(mr.getParameter("WEIGHT"));
	double bmi = weight/((height/100)*(height/100));
	String photo = mr.getFilesystemName("PHOTO");
	String status= "";
	
	if(bmi>=40) status = "고도비만(고급돼지)";
	else if(bmi>=35) status = "중등도비만(중급돼지)";
	else if(bmi>=30) status = "경도비만(초급돼지)";
	else if(bmi>=25) status = "과체중(돼지입문)";
	else if(bmi>=18.5) status = "정상(돼지아님)";
	else status = "저체중(멸치)";
	
	photo = URLEncoder.encode(photo,"UTF-8");
	photo.replace("+"," ");
	
	
	request.setAttribute("patient" ,new Patient(name, height, weight, photo, bmi, status));
	}
}
