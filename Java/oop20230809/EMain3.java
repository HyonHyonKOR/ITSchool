package oop20230809;

import java.util.*;

public class EMain3 {

	public static void main(String[] args) {

	rockScissorPaper();
	
	}//main() end
	
	public static void rockScissorPaper() {
		System.out.println("지금부터 가위바위보 게임을 시작합니다.");
		System.out.println("룰은 간단합니다.\n가위바위보에서 이기거나 비기면 생존, 지면 사망입니다.");
		System.out.println("본 게임은 당신이 사망할때까지 계속 진행됩니다.");
		System.out.println("죽음의 가위바위보 게임에 참가하신 것을 환영합니다.");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		int win = 0;
		String[] rcp = {"가위","바위","보"};
		
		while(true) {
			System.out.println("가위는 1, 바위는 2, 보는 3을 입력해주세요.");
			System.out.print  ("입력 : ");
			
			int playerChoice = sc.nextInt();
			if(playerChoice <1 || playerChoice > 3) {
				System.out.println("잘못 입력했습니다. 다시 입력하세요.");
				System.out.println();
			    continue;
			}
			
			Random random = new Random();
			int computerChoice = random.nextInt(3)+1;
			
			System.out.printf("컴퓨터는 %s를 내었습니다.\n" , rcp[computerChoice-1]);
			System.out.printf("당신은 %s를 내었습니다.\n" , rcp[playerChoice-1]);
			
			int gameResult = playerChoice - computerChoice;  
			
			if(gameResult == 0) {
				System.out.println();
				System.out.println("비겼습니다");
				System.out.println();
			}else if((gameResult==1 || gameResult==-2)) {
				win++;
				System.out.println();
				System.out.println("이겼습니다.");
				System.out.println();
			}else {
				System.out.println();
				System.out.println("당신은 사망했습니다.");
				System.out.println("지금까지의 승리 횟수 : " + win +"번");
				System.out.println();
				sc.close();
				break;
			}
		}	
	 }//method
}// class end
