package com.hyon.oct133.weather;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class WeatherDAO {
    
	public String getKoreanWeather(HttpServletRequest req){
	try {
		URL u = new URL("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1150060300");
		HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			
		InputStream is = huc.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,"UTF-8");
		BufferedReader br = new BufferedReader(isr);
			
		// 나오는 하나하나를 한 덩어리로 뭉치기
	    StringBuffer sb = new StringBuffer();	
		
		String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line.replace("\r\n", ""));
			}
			// 다운받아온 데이터를 한 덩어리로 뭉쳤고, 엔터키를 없앰
			return sb.toString();
		}catch(Exception e) {
		 e.printStackTrace();
		 return null;
		}
	}
}
