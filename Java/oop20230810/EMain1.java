package oop20230810;

import java.util.*;

public class EMain1 {  //5, 16, 29, 34, 38, 45
	
	public static void main(String[] args) {
		startLotto();
	}
	static Scanner inputNum = new Scanner(System.in);
	
	//내 로또번호를 리턴하는 메소드
	public static int[] chooseLottoNum(){
		
		Set<Integer> myLottoNumbers = new HashSet<>();
		int[] myLottoNumList = new int[6];
		int count = 1;
		
		System.out.println("로또를 시작하겠습니다.");
		System.out.println("1에서 45까지의 정수를 입력해주세요.");

		while(myLottoNumbers.size()!=6) {
			System.out.printf("%d번째 번호 입력 : " , count);
			int lottoNum = inputNum.nextInt();
			
			//로또 숫자의 범위 지정
			if (lottoNum < 1 || lottoNum > 45) {
				System.out.println("입력하신 수의 범위가 맞지 않습니다.");
				continue;
			}
			if (!myLottoNumbers.add(lottoNum)) {
				System.out.println("중복된 수입니다. 다른 수를 입력해주세요.");
				continue;
			}
			myLottoNumbers.add(lottoNum);	
			count++;
		}//while 	
		
		//HashSet으로 받은 수를 내가 찍은 번호 배열에 담기
		Iterator<Integer> pickUpLottoNum = myLottoNumbers.iterator();
			
		for (int i = 0; i < myLottoNumList.length; i++) {
			myLottoNumList[i] = pickUpLottoNum.next();
		}
			
		return myLottoNumList;
	 }//chooseLottoNum() end
	
	//당첨 번호를 리턴하는 메소드
	public static int[] getWinningLottoNum(){
		
		Set<Integer> winningNumbers = new HashSet<>();
		int[] winningNumList = new int[6];
		
		Random winningNumberGenerator = new Random();
		
		while(winningNumbers.size()!=6) {
			winningNumbers.add(winningNumberGenerator.nextInt(45)+1);
		}//while 	
		
		Iterator<Integer> pickUpLottoNum = winningNumbers.iterator();
		
		for (int i = 0; i < winningNumList.length; i++) {
			winningNumList[i] = pickUpLottoNum.next();
		}
		
		return winningNumList;
	}//getWinningLottoNum() end
	
	//내 로또 번호와 담청 번호를 받아 일치하는 번호의 수를 리턴하는 메소드
	public static int checkResult(int[] myLottoNumList, int[] winningNumList) {
		
		int sameNumCount = 0;
		Arrays.sort(myLottoNumList);
		System.out.println("입력하신 번호 : " + Arrays.toString(myLottoNumList));
		Arrays.sort(winningNumList);
		System.out.println("당첨 번호    : " + Arrays.toString(winningNumList));
		
		for(int myNum : myLottoNumList) {
			if(Arrays.binarySearch(winningNumList, myNum) >= 0) sameNumCount++;
		}		
		return sameNumCount;
	 }//checkResult() end
	
    //일치하는 번호를 받아 결과를 출력하는 기능을 가진 메소드
	public static void printResult(int sameNumCount) {
		switch(sameNumCount) {
			case 6: {System.out.println("1등입니다"); break;}
			case 5: {System.out.println("2등입니다"); break;}
			case 4: {System.out.println("3등입니다"); break;}
			default: {
			System.out.println("숫자가 " + sameNumCount + "번 일치합니다. 꽝입니다"); 
			}
		}
	  }
	
	public static void startLotto() {
		int[] myLottoNumList =chooseLottoNum();
		inputNum.close();
		int[] winningNumList = getWinningLottoNum();
		int sameNumCount = checkResult(myLottoNumList, winningNumList);
		printResult(sameNumCount);
   }
}