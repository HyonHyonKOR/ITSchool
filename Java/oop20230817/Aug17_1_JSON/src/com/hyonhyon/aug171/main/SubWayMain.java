package com.hyonhyon.aug171.main;

import java.io.InputStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.hyonhyon.http.client.HyonHyonHttpClient;

public class SubWayMain {
	public static void main(String[] args) {
		try {
		  InputStream is = HyonHyonHttpClient.download("http://openapi.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/json/TbSeoulmetroStOrigin/1/275/");
		  String str = HyonHyonHttpClient.convert(is, "UTF-8");
		
		  JSONParser jp = new JSONParser();
		  JSONObject jo = (JSONObject)jp.parse(str);
		  
		  JSONObject metro = (JSONObject) jo.get("TbSeoulmetroStOrigin"); 
		  //System.out.println(metro);
		  
		  JSONArray row = (JSONArray) metro.get("row");
		  //System.out.println(row);
		  
		  JSONObject data= null;
		  for(int i = 0; i < row.size(); i++) {
			  data = (JSONObject) row.get(i);
			  System.out.println(data.get("STATION_NAME"));
			  System.out.println(data.get("LINE"));
			  System.out.println(data.get("ORIGIN"));
			  System.out.println("================");
		  }
		  
		  
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
