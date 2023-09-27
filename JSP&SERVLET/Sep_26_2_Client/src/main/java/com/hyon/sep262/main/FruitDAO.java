package com.hyon.sep262.main;

import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.beaver.http.client.BeaverHttpClient;

public class FruitDAO {
	
	public static void getAllFruitsXML(HttpServletRequest req) {
		try {
			
		//事前に作成したHttpClientオブジェクトからurlのbodyをダウンロード。そのために、InputStream活用
		 InputStream is = BeaverHttpClient.download("http://localhost/Sep_26_1_Ajax/GetFruit");

		 //XmlPullParserFactoryから、XmlPullParserのInterfaceに具象オブジェクトを参照させます。
		 XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
		 XmlPullParser xpp = xppf.newPullParser();
		 //XmlPullParserからEncodingすれば、XMLにパーサー！
		 xpp.setInput(is, "UTF-8");
		 
		 int type = xpp.getEventType();
		 String tagName = null;
		 
		 ArrayList<Fruit> fruits = new ArrayList<Fruit>();
	     Fruit fruit = null;
	     
	     //ROUTE 1 OR ROUTE 2
	     while(type!=XmlPullParser.END_DOCUMENT) {
	    	 //ROUTE 1 start tagなら
	    	 if(type==XmlPullParser.START_TAG) {
	    		 //タグ名をパーサーから得てString変数tagNameに入れて
	    		 tagName = xpp.getName();
	    		 //1->fruit そのタグ名がfruitの場合、DTOを生成
	    		 if(tagName.equals("fruit")) {
	    			 fruit=new Fruit();
	    		 }
	    	 }//ROUTE 2 start tagだけどfruitでなないなら
	    	else if(type == XmlPullParser.TEXT) {
	                  if(tagName.equals("f_name")) {
	                fruit.setF_name(xpp.getText());
	                 } else if(tagName.equals("f_price")) {
	                   fruit.setF_price(Integer.parseInt(xpp.getText()));
	                 }
	    	}
	    	///ROUTE 3 end tagなら
	        else if(type == XmlPullParser.END_TAG) {
	                 if(xpp.getName().equals("fruit")) {
	                     fruits.add(fruit);
	                 }
	             }
	    	 
	    	 xpp.next();
	         type = xpp.getEventType();
	     }
	     
	     req.setAttribute("fruitsxml", fruits);
		 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}



	public static void getAllFruitsJSON(HttpServletRequest req) {
	
	 try {
		 //事前に作成したHttpClientオブジェクトからurlのbodyをダウンロード。そのために、InputStream活用
		 InputStream is = BeaverHttpClient.download("http://localhost/Sep_26_1_Ajax/GetFruitJSON");
		 //もらったバイナリをUTF-8に変換
		 String data = BeaverHttpClient.convert(is, "UTF-8");
		 
		 JSONParser jp = new JSONParser();
		 JSONArray ja = (JSONArray)jp.parse(data);
		 
		 JSONObject jo = null;
         ArrayList<Fruit> fruits = new ArrayList<>();
		 Fruit fruit = null;
		 
		 for(int i= 0; i<ja.size(); i++) {
			jo =  (JSONObject)ja.get(i);
			fruit = new Fruit();
			//JSONObjectをStringに変換してからfruitをDTOとして活用
			fruit.setF_name(jo.get("f_name").toString());
			fruit.setF_price(Integer.parseInt(jo.get("f_price").toString()));
			fruits.add(fruit);
		 }
		 req.setAttribute("fruitsjson",fruits);
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
		
	}
}
