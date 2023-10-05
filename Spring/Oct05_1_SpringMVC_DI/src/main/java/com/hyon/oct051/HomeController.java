package com.hyon.oct051;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hyon.oct051.fruit.Fruit;
import com.hyon.oct051.member.MemberDAO;


@Controller
public class HomeController {
	
	@Autowired
	private Fruit f;
	
	@Autowired
	private MemberDAO mdao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//Fruit 클래스 => 이름 / 가격
		//Fruit의 속성값은 servlet-context.xml에서 넣기
		//이 메소드에서 출력
		
		System.out.println(f.getName());
		System.out.println(f.getPrice());
		
		mdao.test();
		
		return "home";
	}
	
}
