package oop20230814.InputOutput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//CPU 			:연산장치
//RAM			:저장장치(임시) - 재부팅하면 날아감
//			      static / stack - 프로그램을 끄면 날아감
//  			  heap - 자동으로 날아감 X (GC있으면 자동으로 날아감)
//HDD(SSD)		:저장장치(영구) - 파일
//GPU			:그래픽처리용 (CPU+RAM+HDD)

//입출력장치
//프로그램에서는 데이터를 외부에서 읽고, 다시 외부로 출력하는 작업이 자주 일어나는데
//데이터는 사용자로부터 키보드를 통해서 입력될 수도 있고, (Scanner의 System.in)
//파일/네트워크에서도 입력될 수 있다.

//반대로 데이터는 모니터를 통해서 출력될 수도 있고, (System.out.println)
//파일.네트워크로도 출력될 수 있다			  (Output)

//	System.in  => InputStream
//  System.out => PrintStream

// 기본형
// InputStream : 장치(키보드,파일,네트워크, ....)=> 프로그램으로 입력 (1byte씩)
// InputStreamReader : 장치 => 프로그램(2byte씩) (빨리 크기 UP) + 인코딩방식
// BufferedReader : 장치 => 프로그램()  라인단위

// OutputStream : 장치(키보드,파일,네트워크, ....)=> 프로그램으로 출력 (1byte씩)
// OutputStreamReader : 장치 => 프로그램(2byte씩) (빨리 크기 UP) + 인코딩방식
// BufferedWriter : 장치 => 프로그램()  라인단위

// 개조형(특수 목적에 맞게)

public class FileWriteMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("입력:");
		String cmt = k.nextLine();
		
		System.out.println("=============");
		
		//FileWriter
		//   프로그램 => 파일(OutputStreamWriter 개조형)
		//   파일이 없으면 만들어 주기도 함
		//   폴더는 안만들어줌
		//   Linux의 경로 : E:/Test/beaver1.txt => /로 경로 설정
		//   Windows의 경로 : E:\\Test\\beaver1.txt => \\로 경로 설정 + / 하나로도 가능
		
		//   Java의 \는 : \t, \r, \n, \0, ...에 사용 (이스케이프 문자)
		//   파일 관련 모든 상황에 대해서 -> 예외처리!!
		BufferedWriter bw = null;
		try {
			//지정된 파일이 이미 존재하고 있으면 덮어쓰기 때문에
			//기존에 잇던 내용이 사라지게 됨 
			//기존의 내용 뒤에 덧붙이고 싶으면(데이터를 추가하고 싶다면)
			//두 번째 파라미터의 값으로 true를 주면 됨
			
			//Encoding 방식 지정 x => ANSI로 인코딩됨
			FileWriter fw = new FileWriter("C:\\temp\\hyonhyon.txt",true);
			bw = new BufferedWriter(fw);
			bw.write(cmt + "\r\n");
			bw.write("----------------\r\n");
			bw.flush();
		}catch(Exception e ) {
			e.printStackTrace();
		}
		  try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  k.close();
	}
}
