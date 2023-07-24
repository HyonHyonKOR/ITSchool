package oop20230724;

public class MethodEx7 {

	public static void main(String[] args) {
		
		String str = "LEVEL";
		
		if(checkPalindrome(str)) {
			System.out.println(str + "은 회문입니다.");
		}
		else {  
			System.out.println(str + "은 회문이 아닙니다.");
		}		}
		

	
	public static boolean checkPalindrome(String str) {

	
	if(str.length()<=1)   return true;  
	
	if(str.charAt(0)!=str.charAt(str.length()-1)) return false;
	
	else {	  
	  return checkPalindrome(str.substring(1,str.length()-1)); //재귀
	} 
  }
}

