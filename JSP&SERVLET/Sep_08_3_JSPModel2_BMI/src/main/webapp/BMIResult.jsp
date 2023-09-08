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
    <title>실행 결과</title>
    <style>
    {
      main{
      align-items: center;
      flex-direction: column;
      }
      marquee{
      font-size: 2em;
      }
    }
    </style>
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

patient.setPhoto(URLDecoder.decode(patient.getPhoto(),"UTF-8"));
String photo = patient.getPhoto();


%>
   <div class="box__menu">
      <span>체질량 지수(BMI) 계산</span>
    </div>
    <header>
      <h1><%=name %>님의 BMI 결과</h1>
    </header>
    <main>
       <img src="img/<%=photo %>">
       <h2>이름:<%=name %></h2>
       <h2>신장:<%=height %></h2>
       <h2>몸무게: <%=weight %></h2>
       <h2>BMI: <%=bmi %></h2>
	   <marquee>당신은 <%=status %> 입니다.</marquee> 
	   </main>
</body>
</html>