package com.hyon.oct1212.fruit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FruitController {
	
	private final FruitDAO fDAO;
	
	@Autowired
	public FruitController(FruitDAO fDAO) {
		this.fDAO = fDAO;
	}
	
	@RequestMapping(value = "/fruit.getXML", method= RequestMethod.GET,
			produces = "application/xml; charset=UTF-8")
	public @ResponseBody Fruits getFruitXML(HttpServletRequest req) {
		return fDAO.getXML(req);
	}
	
	@RequestMapping(value="/fruit.getPriceFruitXML", method= RequestMethod.GET,
			produces = "application/xml; charset=UTF-8")
	public @ResponseBody Fruits getPriceFruitXML(Fruit f,HttpServletRequest req) {
		return fDAO.getPriceFruitXML(f,req);
	}
	
}
