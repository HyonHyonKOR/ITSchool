package com.hyonhyon.aug162.main;

import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.hyonhyon.http.client.HyonHyonHttpClient;

// 웹서버(클라이언트가 웹사이트에 요청 => 사이트가 응답)
// 실시간 데이터를 XML Parsing (클라이언트가 데이터를 요청 => XML / JSON 응답)
//		(나중에) 그 데이터를 가지고 웹으로 이미지화를 시켜서 구현 
//		data.go.kr
//		data.seoul.go.kr
//		dev.naver.com
//		dev.kakao.com
//		...

//서울 열린데이터 광장 DB - 미세먼지 데이터

//DB에 있는 데이터를 사람들에게 보여줘야 하는 경우...
// 		대부분의 사람들이 SQL을 할 줄 모른다.
// 		웹사이트 : 보통사람들이 DB쓰기 편하게 만든다.

//		개발자가 데이터만 가져오고 싶음
//		데이터를 특정한 형식으로 표현해줘야 하는데
// 		DB에 있는 데이터를 표현하는 형식 : XML, JSON

//		Parsing = kxm12.jar
//		필요없는 데이터는 걷어내고, 원하는 형태로 가공하는 작업 

//XML(eXtensible Mark-up Language)
//		DB에 있는 데이터를 HTML형태로 표현한 것 
//		<xxx> 		:시작태그 (xxx:태그명)   //태그와 데이터는 각각의 고유한 정수값이 들어있다.
//			yyy		:텍스트	
//		</xxx>		:종료태그

//http://openAPI.seoul.go.kr:8088/(인증키)/xml/RealtimeCityAir/1/25/
//4f626857416f6c6c3632586a416843

//인증키 + 주소값 활용해서
//main메소드에 저 주소에 요청한 데이터들 전부 다 출력
public class AirPollutionMain1 {
	public static void main(String[] args) throws Exception {
		InputStream is = HyonHyonHttpClient.download("http://openAPI.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/xml/RealtimeCityAir/1/25/");
		//String data= HyonHyonHttpClient.convert(is,"UTF-8");
		//System.out.println(data);
		
		XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
		XmlPullParser xpp = xppf.newPullParser();
		xpp.setInput(is,"UTF-8");
		
		//START_DOCUMENT : 문서의 시작
		//END_DOCUMENT : 문서의 끝
		//START_TAG : 시작태그(<xxx>)
		//END_TAG: 종료태그(</xxx>)
		//TEXT:텍스트(시작태그와 종료태그 사이의 내용)
		int type = xpp.getEventType();
		String tagName = null;
		
		while(type != XmlPullParser.END_DOCUMENT) {
			if(type == XmlPullParser.START_TAG) {
				tagName = xpp.getName();
			}else if(type == XmlPullParser.TEXT) {
				if(tagName.equals("MSRSTE_NM")) {
					System.out.printf("%s : ", xpp.getText());
				}else if(tagName.equals("PM10")) {
					System.out.println(xpp.getText());
				}
			}else if(type == XmlPullParser.END_TAG) {
				tagName = ""; //XML에서는 띄어쓰기를 텍스트로 인식하는 경우가 있음
			}
			xpp.next(); //다음걸로 넘어감
			type = xpp.getEventType();
		}
		
	}
}
