package com.hyon.oct101.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
 
	private final TestDAO tDAO;

	@Autowired
	public TestController(TestDAO tDAO) {
		this.tDAO = tDAO;
	}
	
	@RequestMapping(value= "/test.reg", method = RequestMethod.GET)
	public String regTest(Test t, HttpServletRequest req) {
		tDAO.regTest(t, req);
		tDAO.getAllTest(req);
		return "input";
	}	
}
