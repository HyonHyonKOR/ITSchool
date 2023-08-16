package com.hyonhyon.aug161.main;

import java.io.InputStream;

import com.hyonhyon.http.client.HyonHyonHttpClient;

public class HMain1 {

	public static void main(String[] args) {
		try {
			InputStream is = HyonHyonHttpClient.download("https://www.naver.com");
			
			String result = HyonHyonHttpClient.convert(is, "UTF-8");
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}