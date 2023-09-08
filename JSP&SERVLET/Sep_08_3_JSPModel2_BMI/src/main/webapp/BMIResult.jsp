<%@page import="java.net.URLDecoder"%>
<%@page import="com.hyon.sep08.main.Patient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
  <head>
    <link rel="stylesheet" href="css/style.css" />
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script type="text/javascript" src="ValidCheck.js"></script>
    <script type="text/javascript" src="BMIValidCheck.js"></script>
    <title>BMI 결과</title>
  </head>
  <body>
  
<%
request.setCharacterEncoding("UTF-8");

Patient patient = (Patient)request.getAttribute("patient");
String name =patient.getName();
double height =patient.getHeight();
double weight=patient.getWeight();
double bmi =patient.getBmi();
String status =patient.getStatus();

String bmi2 = String.format("%.2f",bmi);

patient.setPhoto(URLDecoder.decode(patient.getPhoto(),"UTF-8"));
String photo = patient.getPhoto();


%>
    <style>
		main{
    	display: flex;
    	flex-direction: column;
    	justify-content: center;
    	align-items:center;
    	gap:20px;
		}
		img{
    	width:330px;
    	}
   		h2{
		font-size: 24px;
		display: flex;
		}
    </style>
   <div class="box__menu">
      <span>체질량 지수(BMI) 계산</span>
    </div>
    <header>
      <h1><%=name %>님의 BMI 결과</h1>
    </header>
    <main>
       <img src="img/<%=photo %>">
       <h2>이름:&nbsp<%=name %></h2>
       <h2>신장:&nbsp<%=height %>cm</h2>
       <h2>몸무게:&nbsp<%=weight %>kg</h2>
       <h2>BMI:&nbsp<%=bmi2 %></h2>
	   <h1>당신은&nbsp<%=status %> 입니다.<h1>
	   </main>
</body>
</html>