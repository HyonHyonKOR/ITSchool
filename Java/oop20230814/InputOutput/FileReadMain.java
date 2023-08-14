package oop20230814.InputOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadMain {
	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			FileReader fr = new FileReader("C:\\temp\\hyonhyon.txt");
			br = new BufferedReader(fr);
			
			String line = null;
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
		br.close();
	   }catch(IOException e) {
		   e.printStackTrace();
	   }
	}
}
