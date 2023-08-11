package oop20230811.oop;

public class OMain1 {
	
	public static void main(String[] args) {
		Referee referee = new Referee();
	    referee.judge(referee.askMyAns(referee.callMe(),referee.askFriAns(new Friend())));
	}
}

//심판 / 친구 / 나 
//주도적으로 끌고 갈 인물 (심판)
//등장인물이 다 등장해야...
//심판, 친구는 나와있고 => 심판이 나를 불ㄹ내는 상황
// 심판 => 친구 답 요규 => 종이에 답을 적어서 제출
// 심판 => 나 답 요구 => 말로 대답을 할 것
// 판정
// 맞출때까지 진행