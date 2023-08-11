 package oop20230811.oop;

public class Referee {  
	
   int count = 0; 	
   //나 부르기
   public Me callMe() {
	   System.out.println("Referee : Ya! Nawa!");
	   System.out.println("Me : 이 몸 등장 ㄴㅇㄱ");
	   return new Me();
   }
   
   //친구에게 답 요구
   public int askFriAns(Friend f) {
	   int friAns = f.writeFriAns();
	   return friAns;
   }
   
   //나에게 답 요구 
   //판정(답 맞출때까지)
   //시도 횟수 몇 번 만에 맞췄는지
   public int askMyAns(Me me, int friAns) {
	   System.out.println("Referee : 정답을 말해주세요.");
	   count++;
	   int myAns = me.speakMyAns();
	   if(friAns == myAns ) return count;
	   else if(friAns > myAns) {
		   System.out.println("UP");
		   return askMyAns(me, friAns);
	   }
	   else {
		   System.out.println("DOWN");
		   return askMyAns(me, friAns);
	   }
   }
   
   public void judge(int count) {
	   System.out.println();
	   System.out.println(count + "번의 시도 끝에 정답을 맞췄습니다.");
   }
   
}