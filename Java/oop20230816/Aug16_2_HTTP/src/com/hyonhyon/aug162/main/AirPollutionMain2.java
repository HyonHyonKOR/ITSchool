package com.hyonhyon.aug162.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import com.hyonhyon.http.client.HyonHyonHttpClient;

public class AirPollutionMain2 {
	public static void main(String[] args) throws Exception {
		
		//입력
		InputStream is = HyonHyonHttpClient.download("http://openAPI.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/xml/RealtimeCityAir/1/25/");
		XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
		XmlPullParser xpp = xppf.newPullParser();
		xpp.setInput(is,"UTF-8");
		
		//출력
		try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:/temp/airpollution.txt"),"UTF-8"))){
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년-MM월-dd일-a-h시-E요일");
		String date = sdf.format(now);
				
		//처리
		int type = xpp.getEventType();
		String tagName = null;	
		
		while(type != XmlPullParser.END_DOCUMENT) {
			if(type == XmlPullParser.START_TAG) {
				tagName = xpp.getName();
			}	
			else if(type == XmlPullParser.TEXT) {
				if(tagName.equals("MSRSTE_NM")) {
					bw.write(date +",");
					bw.write(xpp.getText()+",");
				}else if(tagName.equals("PM10")) {
					bw.write(xpp.getText()+",");
				}
				else if(tagName.equals("PM25")) {
					bw.write(xpp.getText()+",");
				}
				else if(tagName.equals("O3")) {
					bw.write(xpp.getText()+",");
				}
				else if(tagName.equals("IDEX_MVL")) {
					bw.write(xpp.getText()+"\n");
					bw.flush();
				}
			}else if(type == XmlPullParser.END_TAG) {
				tagName = ""; //XML에서는 띄어쓰기를 텍스트로 인식하는 경우가 있음
			}
			xpp.next(); //다음걸로 넘어감
			type = xpp.getEventType();
		  }
		  bw.write("파일 생성 완료!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}