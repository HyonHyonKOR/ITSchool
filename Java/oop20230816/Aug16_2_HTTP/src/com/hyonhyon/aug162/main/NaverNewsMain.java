package com.hyonhyon.aug162.main;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import com.hyonhyon.http.client.HyonHyonHttpClient;

//akgnOKaAly9U6NNvSb7N
//uS4BagcuKc

//https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=0&acr=3&acq=%EC%A3%BC%EC%88%A0%ED%9A%8C%EC%A0%84+2&qdt=0&ie=utf8
//&query=%EC%A3%BC%EC%88%A0%ED%9A%8C%EC%A0%84+2%EA%B8%B0

//인터넷 주소 체계
//  프로토콜:// -통신방식
//		컴퓨터의 주소/
//		폴더명/폴더명/..../파일명
//		? 다음에 나오는
//			변수명=값&변수명=값&....
//			 요청 파라미터 : 클라이언트가 서버에게 공개적으로 전달할 정보 

// 한글, 특수문자가 바로 들어가서는 안됨!!!
// 	  ex) 주술회전 2기 => ?where=nexearch&sm=top_sug.pre&fbm=0&acr=3&acq=%EC%A3%BC%EC%88%A0%ED%9A%8C%EC%A0%84+2&qdt=0&ie=utf8
//&query=%EC%A3%BC%EC%88%A0%ED%9A%8C%EC%A0%84+2%EA%B8%B0(URL 인코딩)

public class NaverNewsMain {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)){
			String address= "https://openapi.naver.com/v1/search/news.xml";
			System.out.print("검색어: ");
			String search = sc.nextLine();
			System.out.println(search);
			System.out.println();
			search = URLEncoder.encode(search,"UTF-8");
			address += "?query=" + search;
			
			HashMap<String, String> headers =new HashMap<>();
			headers.put("X-Naver-Client-Id","akgnOKaAly9U6NNvSb7N");
			headers.put("X-Naver-Client-Secret","uS4BagcuKc");
			InputStream is = HyonHyonHttpClient.download(address,headers);
//			String result = HyonHyonHttpClient.convert(is,"UTF-8");
//			System.out.println(result);
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
		    xpp.setInput(is,"UTF-8");
		    
		    int type = xpp.getEventType();
		    String tagName = null;
		    boolean data = false;
		    String t = null;
		    
		    while(type != XmlPullParser.END_DOCUMENT) {
		    	 if(type == XmlPullParser.START_TAG) {
		    		tagName = xpp.getName();
		    		if(tagName.equals("item")) {
		    			data = true;
		    		}
		    	}else if(type == XmlPullParser.TEXT) {
		    		if(data) {
		        	   if(tagName.equals("title")) {
		        		   t = xpp.getText();
		        		   t = t.replaceAll("[<b>,&apos,&lt,&gt,;]", "");
			    		   System.out.println("제목 : " + t);
			    	   }else if(tagName.equals("description")) {
			    		   t = xpp.getText();
			    		   t = t.replaceAll("[<b>,&apos,&lt,&gt,;]", "");
		        		   System.out.println("내용 : " + t);
			    		   System.out.println("=========================");
			    	   }
		    		}
		    	}else if(type == XmlPullParser.END_TAG) {
		    		tagName = "";
		    	}
		    	xpp.next();
		    	type = xpp.getEventType();
		    }		
//			//HttpsURLConnection 활용 => 안에 있는 기낭
//			URL u = new URL(address);
//			HttpsURLConnection huc = (HttpsURLConnection)u.openConnection();
//			
//			//요청 헤더
//			huc.addRequestProperty("X-Naver-Client-Id","akgnOKaAly9U6NNvSb7N");
//			huc.addRequestProperty("X-Naver-Client-Secret","uS4BagcuKc");
// 
//			InputStream is = huc.getInputStream();
//			String result = HyonHyonHttpClient.convert(is,"UTF-8");
//			System.out.println(result);
			
			//뉴스의 title / description
			//title :Naver Open API = news - ?
			//description : Naver Search Result
			//  => 안나오게!!
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
