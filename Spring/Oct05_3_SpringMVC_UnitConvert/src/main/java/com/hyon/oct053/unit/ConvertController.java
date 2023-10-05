package com.hyon.oct053.unit;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConvertController {

	@Autowired
	private ConvertServiceImpl csi;

	@RequestMapping(value ="unit.convert", method = RequestMethod.GET)
	public String returnUnitConvertResultPage(ConvertResult cr, HttpServletRequest req) {
			csi.convert(cr, req);
			return "output";
		}	
   }
