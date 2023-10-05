package com.hyon.oct053.unit;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl {
     
	private HashMap<String, String> units;
	
	public void setUnit(HashMap<String, String> units) {
		this.units = units;
	}
	
	public void convert(ConvertResult cr , HttpServletRequest req) {
				
		double beforeNum = cr.getBeforeNum();
		String convertUnit = req.getParameter("convertUnit");
		double convertedNum = beforeNum * 1.61;
		if(convertUnit.equals("length")) {
			convertedNum = beforeNum*0.39;	
		}else if(convertUnit.equals("area")) {
			convertedNum = beforeNum*0.3;
		}else if(convertUnit.equals("temparature")) {
			convertedNum = beforeNum*1.8 + 32;
		}
		
		String[] u = units.get(convertUnit).split(",");
		cr.setConvertedNum(convertedNum);
		cr.setBeforeUnit(u[0]);
		cr.setConvertedUnit(u[1]);
		
		req.setAttribute("cr", cr);
	}
}


