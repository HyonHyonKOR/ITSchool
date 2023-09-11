<%@page import="com.hyon.sep112.main.RSPGameEngine"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>가위바위보</title>
  </head>
  <body>
  <%
  RSPGameEngine rspReferee = RSPGameEngine.getInstance();
  %> 
    <header>
      <h1>가위바위보</h1>
    </header>
    <main>
      <div class="computer-choice"></div>
      <div class="user-choice">
        <form action="HomeController" class="user-choice__column">
          <button name="userhand" value="1"><img src="1.png" alt="가위"></button>
          <button name="userhand" value="2"><img src="2.png" alt="바위"></button>
          <button name="userhand" value="3"><img src="3.png" alt="보"></button>
        </form>
      </div>
      <div class="rsp-result">
      <h1>player: <img name="user" src="${user}"></h1>
      <h1>com: <img name="com" src="${com}"></h1>
      <h1>${r} </h1>
      </div>
      <div class="rsp-record">
      <h1>${w }</h1>
      <h1>${d }</h1>
      <h1>${l }</h1>
      </div>
    </main>
  </body>
</html>