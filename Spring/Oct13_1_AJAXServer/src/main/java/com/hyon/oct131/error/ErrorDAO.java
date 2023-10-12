package com.hyon.oct131.error;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorDAO {

	@Autowired
	private SqlSession ss; 
	
	public void getAllErrors(HttpServletRequest req) {
		try {
		req.setAttribute("errors", ss.getMapper(ErrorMapper.class).getAllErrors());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
