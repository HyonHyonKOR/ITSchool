<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <% 
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
	
	String bmi2 =String.format(., bmi)
	
	fileName = URLEncoder.encode(fileName, "UTF-8");
	
	%>
	
	   <table id="resultTBl">
	   	 <tr>
	   	    <th colspan="2">BMI Result</th>
	   	 </tr>
	   	  <tr>
	   	    <td class="td1" align:"center">이름</td>
	   	    <td class="td1" align:"center">이름</td>
	   	 </tr>
	   	 	   	  <tr>
	   	    <td class="td1" align:"center">키</td>
	   	    <td class="td1" align:"center">이름</td>
	   	 </tr>
	   	 	   	  <tr>
	   	    <td class="td1" align:"center">몸무게</td>
	   	    <td class="td1" align:"center">이름</td>
	   	 </tr>
	   	 	   	  <tr>
	   	    <td class="td1" align:"center">BMI</td>
	   	    <td class="td1" align:"center">이름</td>
	   	 </tr>
	   	 	   	  <tr>
	   	    <td class="td1" align:"center">이름</td>
	   	    <td class="td1" align:"center">이름</td>
	   	 </tr>
	   	 	   	  <tr>
	   	    <td class="td1" align:"center">이름</td>
	   	    <td class="td1" align:"center">이름</td>
	   	 </tr>
	   </table>
</body>
</html>