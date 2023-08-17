package com.hyonhyon.aug171.main;


import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.hyonhyon.http.client.HyonHyonHttpClient;

public class WeatherMain {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("도시 이름: ");
		String cityname = URLEncoder.encode(sc.nextLine(),"UTF-8"); 
		InputStream is = HyonHyonHttpClient.download("https://api.openweathermap.org/data/2.5/weather?q="+cityname+"&appid=42008a8c8e7402a3fc9d3b1a7df8fee9&units=metric&lang=kr");
		String data = HyonHyonHttpClient.convert(is, "UTF-8");
		
		JSONParser jp = new JSONParser();
		JSONObject root = (JSONObject) jp.parse(data);
		JSONObject sys = (JSONObject) root.get("sys");
		JSONArray weather = (JSONArray)root.get("weather");
		JSONObject weatherObj = (JSONObject)weather.get(0);
		JSONObject main = (JSONObject) root.get("main");
		
		System.out.printf("나라 이름 : %s\n",sys.get("country"));
		System.out.printf("도시 이름 : %s\n",root.get("name"));
		System.out.printf("날씨 정보 : %s\n",weatherObj.get("description"));
		System.out.printf("기온     : %s℃\n",main.get("temp"));
		System.out.printf("체감 온도 : %s℃\n",main.get("feels_like"));
		System.out.printf("최저 기온 : %s℃\n",main.get("temp_min"));
		System.out.printf("최고 기온 : %s℃\n",main.get("temp_max"));
		System.out.printf("기압     : %shPa\n",main.get("pressure"));
		System.out.printf("습도     : %s",main.get("humidity") +"%");
		
		sc.close();
	}
}