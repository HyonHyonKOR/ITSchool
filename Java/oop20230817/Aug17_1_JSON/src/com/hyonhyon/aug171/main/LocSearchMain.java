package com.hyonhyon.aug171.main;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.hyonhyon.http.client.HyonHyonHttpClient;

public class LocSearchMain {
	//https://dapi.kakao.com/v2/local/search/address.$
	//RestAPI 16e6c58f062166934ed7652260b1bc03
	//Authorization	Authorization: KakaoAK ${16e6c58f062166934ed7652260b1bc03}
	public static void main(String[] args) throws Exception {
		//기준점 주변 반경 5km이내에 검색한 키워드(입력)가 포함된 가게들은 거리기준으로 !정렬! 출력
		//총 검색 결과 수
		//현재 페이지 결과 수
		//주소
		//전화번호
		//상호명
		//기준점과의 거리
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색하고 싶은 키워드를 입력해주세요 : ");
		String keyword = URLEncoder.encode(sc.next(),"UTF-8");
		
		String address = "https://dapi.kakao.com/v2/local/search/keyword.json"
				+ "?y=37.5693582"
				+ "&x=126.9858652"
				+ "&query="
				+ keyword
			    + "&sort=distance";
		
		HashMap<String, String> headers = new HashMap<>();
		headers.put("Authorization","KakaoAK 16e6c58f062166934ed7652260b1bc03");
		InputStream is = HyonHyonHttpClient.download(address,headers);
		String data = HyonHyonHttpClient.convert(is,"UTF-8");
		
		JSONParser jp = new JSONParser();
		JSONObject root = (JSONObject) jp.parse(data);
		JSONObject meta = (JSONObject) root.get("meta");
		
		System.out.printf("총 검색 결과 수 :%s개\n",meta.get("total_count"));
		System.out.printf("현재 페이지 결과 수 :%s개\n",meta.get("pageable_count"));
		System.out.println();
		
		
		JSONArray ja =(JSONArray)root.get("documents");
		
		for(int i = 0; i< ja.size(); i++) {
		JSONObject jo3 =(JSONObject)ja.get(i);	
		System.out.printf("주소 : %s\n",jo3.get("address_name"));
		System.out.printf("전화번호 :%s\n",jo3.get("phone"));
		System.out.printf("상호명 :%s\n",jo3.get("place_name"));
		System.out.printf("거리 :%sm\n",jo3.get("distance"));
		System.out.println();
		}
		
		sc.close();
	}
}