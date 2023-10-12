package com.hyon.oct1212.fruit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyon.oct1212.fruit.FruitMapper;

@Service
public class FruitDAO {

	@Autowired
	private SqlSession ss;
	
	public void getAllFruits(HttpServletRequest req) {
	
		try {
			req.setAttribute("fruits", ss.getMapper(FruitMapper.class).getAllFruits());
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "등록 실패");
		}
		
		
	}
	
	public void getPriceFruit(Fruit f, HttpServletRequest req) {
		
		try {
			req.setAttribute("fruits", ss.getMapper(FruitMapper.class).getPriceFruit(f));
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "등록 실패");
		}
	}
	
	//Spring에서 XML 끌어오는 시스템: XML AJAX Server
	//현재 DB에 있는 과일데이터를 하나를 표현할 JavaBean(Fruit.java)를 가지고 있는 상태
	//우리가 필요한 것]
	//   1. DB에 있는 '과일테이블'을 표현할  또 하나의 JavaBean이 필요
	//   2. Spring이 XML로 바꿀수 있도록
	//   각각의 JavaBean에 @XmlRootElement 달기
	//   3. 각각의 setter 위에 @XmlElement 달기
	//   특정 데이터 => XML 형태로 바꾸는 것: 마샬링(Mashalling)
	public Fruits getXML(HttpServletRequest req) {
		List<Fruit>fruits = ss.getMapper(FruitMapper.class).getAllFruits();
		Fruits fruitss = new Fruits(fruits);
		return fruitss;
	}
	
	
	public Fruits getPriceFruitXML(Fruit f,HttpServletRequest req) {
		return new Fruits(ss.getMapper(FruitMapper.class).getPriceFruit(f));
	}

}
