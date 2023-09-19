package com.hyon.sep191.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//값
//	갈색요청 소속
//		parameter(a,b)
//		attribute(cc)
//	갈색이 닿으면 값 사용 가능 O
//  새로운 요청이 일어나는 상황에서는 값 사용 불가!!
//  Third까지 살아서 갈 수 있는 방법이 필요(현재 Third까지는 요청이 닿지 않음)
//  Session/Cookie를 통해서 해결해야함

// -parameter
//  V에서 만든 값
//  String or String[]
//  request 소속

//  값 읽기
//   Java: request.getParameter("파라미터명")
//   JSP(EL) : ${param.파라미터명}

// -request 소속 attribute
//  M에서 만든 값
// Object
// request 소속

//  값 읽기
//   Java: request.getParameter("어트리뷰트명")
//   JSP(EL) : ${어트리뷰트명}


public class M{
	public static void makeSecondData(HttpServletRequest req, HttpServletResponse res) {
		int c = 3000;
		req.setAttribute("cc", c);
		
		int d = 40000;
		HttpSession hs = req.getSession(); //사용자와 서버간의 연결 상태
		hs.setMaxInactiveInterval(15);     //session의 유지시간을 15초
		hs.setAttribute("d", d);           //session 소속의 attribute
		
		String e = "500000";
		Cookie ck = new Cookie("e", e);   
		ck.setMaxAge(15);                  //15초 동안은 사용자 컴퓨터 파일에 저장//응답 객체에 쿠키를 추가 
		res.addCookie(ck);                 //응답 객체에 쿠키를 추가
	}
	
	public static void printSecondDataNew(HttpServletRequest req) {
		try {
			HttpSession hs = req.getSession();
			int d = (Integer)hs.getAttribute("d");
			System.out.println(d);
		}catch(Exception e) {
			
		}
		// 이 프로젝트 , naver, daum, youtube, ...
		// 현재 사용자 컴퓨터에 있는 쿠키들
		Cookie[] cks = req.getCookies(); //저장되어있는 쿠키'들'이라서 배열
		for(Cookie ck : cks) {
			if(ck.getName().equals("e")) { //쿠키 이름이 e인 값을
				System.out.println(ck.getValue()); // 출력 
			}
		}
	}	
	
	public static void printSecondData(HttpServletRequest req) {
		int a = Integer.parseInt(req.getParameter("a"));
		int b = Integer.parseInt(req.getParameter("b"));
		int c = (Integer)req.getAttribute("cc");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
