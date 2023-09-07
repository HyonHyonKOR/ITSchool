<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>구구단</title>
    <style>
    body{
    display:flex;
    }
    table{
    width:150px;
  	border-collapse: collapse;
  	border-spacing: 0;
	}
	tr:nth-child(10n+1){
	background-color:pink;
	}
	tr:nth-child(10n+1)> td{
	color:white;
	font-weight:700;
	}
	td{
	border:1px solid red;
	text-align: center;
	color:red;
	font-size:100%;
	}
    
    </style>
</head>
<body>
    
        <%
            for (int i = 2; i <= 9; i++) {
        %>
        <table>
        <tr>
            <td><%= i %>단</td>
        </tr>
        <%
                for (int j = 1; j <= 9; j++) {
        %>
        <tr>
            <td><%= i %> x <%= j %> = <%= i * j %></td>
        </tr>
        <%
                }
        %>
        </table>
        <%
            }
        %>
    
</body>
</html>