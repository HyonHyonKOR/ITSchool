package com.hyon.oct051.member;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//유지보수에 용이
//Spring - Maven - MyBatis

//연/월/일의 형태...

//servlet-context.xml에 등록한 효과!!
@Service
public class MemberDAO {

	@Autowired
	private SimpleDateFormat sdf;
	
	public void test() {
		Date now = new Date();
		System.out.println(sdf.format(now));
	}
	
}
