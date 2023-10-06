package com.hyon.oct062;

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

import com.hyon.oct062.student.StudentDAO;


@Controller
public class HomeController {
	
	private StudentDAO sDAO;

	@Autowired
	public HomeController(StudentDAO sDAO) {
		this.sDAO = sDAO;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {	
		sDAO.readAllStudents(req);
		return "index";
	}
}
