package oop20230726;

public class JumsuTest {

	public static void main(String[] args) {
		//성적 프로그램 
		System.out.println("[시험결과]");
		System.out.println("=====================");
		System.out.println("번호 이름 1 2 3 4 5 점수 등수");
		System.out.println("=====================");
		
		Jumsu[] student = {
			new Jumsu(1,"홍길동",1,3,1,1,1),
			new Jumsu(2,"최길동",1,1,1,1,1),
			new Jumsu(3,"장길동",2,3,3,4,1),
			new Jumsu(4,"오길동",4,1,2,1,1),
			new Jumsu(5,"구길동",1,1,2,3,4),
			new Jumsu(6,"창길동",3,3,3,3,3)
		};
		
		int size = student.length;
		//ox, 점수 구하기
		for(int idx = 0; idx< size; idx++) {
			student[idx].compute();
		}
		//등수 구하기
		for(int a =0; a<size; a++) {
			for(int b = 0; b< size ; b++) {
				if(student[a].score < student[b].score)
					student[a].rank++;
			}
		}
		
		//출력하기
		for(Jumsu a : student) {
			a.disp();
		}
		
		
	}

}
