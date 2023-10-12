package com.hyon.oct1212;

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

import com.hyon.oct1212.fruit.Fruit;
import com.hyon.oct1212.fruit.FruitDAO;


@Controller
public class HomeController {
	
	private final FruitDAO fDAO;
	
	@Autowired
    public HomeController(FruitDAO fDAO) {
		this.fDAO = fDAO;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAllFruits(HttpServletRequest req) {
		fDAO.getAllFruits(req);
		return "index2";
	}
	
}
