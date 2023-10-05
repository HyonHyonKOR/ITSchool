package com.hyon.oct052.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

// 멤버변수 없으면 : static method 기반
// M / DAO에는 게시판 같은 기능을 구현한다면 멤버변수가 생김
//      => static 기반 method는 포기 => 객체를 만들어서 사용해야하는데
//      => new CalcDAO(); => 새로고침 or 요청
//		=> calculate.do로 요청할때마다 새로운 CalcDAO가 생성됨
//      => 메모리 폭발(메모리를 계속 사용하게 됨, 비효율적)
//		 + allCalcCount도 제대로 카운팅 X!

// 해결방안 : CalcDAO를 singtone처리!
@Service //servlet-context.xml에 CalcDAO 객체를 하나 등록해놓은 효과!
public class CalcDAO {
   private int allCalcCount; // 몇 번 계산했는지
  
   public void calculate(CalcResult cr , HttpServletRequest req) {
	   allCalcCount++;
	   System.out.println(allCalcCount);
	   int add= cr.getX() + cr.getY();
	   req.setAttribute("r", add);
   }
  
}
