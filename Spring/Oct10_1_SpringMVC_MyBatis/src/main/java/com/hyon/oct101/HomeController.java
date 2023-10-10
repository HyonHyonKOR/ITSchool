package com.hyon.oct101;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hyon.oct101.test.TestDAO;


@Controller
public class HomeController {
	
    private final TestDAO tDAO;
	
	@Autowired
	public HomeController(TestDAO tDAO) {
		this.tDAO = tDAO;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		tDAO.getAllTest(req);
		return "input";
	}
	
}
