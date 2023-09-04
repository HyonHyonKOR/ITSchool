//수학, 영어 점수를 입력받아서 평균 점수를 출력해주는 프로그램
//출력(document.write)

let math = prompt("수학 점수를 입력하세요");
let eng = prompt("영어 점수를 입력하세요");
let result = (math+eng)/2;
document.write('두 점수의 평균은  ' + result + '점'+ '<br>'); //4045??

let math2 = 80;
let eng2 = 90;
var result2 = (math2+eng2)/2;
document.write('두 점수의 평균은 ' + result2 + '점'+ '<br>'); //4045??

//prompt로 받은 값은 무조건 문자형(String)
//"80" + "90" = 170(x) /"8090" (o)
//"8090" / 2 = "4045" ...?
//"8090은 분명히 문자열인데 계산이 되었음"
//숫자형이 아니더라도 표현식(_,-,*,/)을 활용했을 때
//숫자형으로 변환할 수 있다면
//자동으로 형 변환이 되어서 계산이 됨
//'자동형변환' 이라고 함

//자동 형변환이 좋아보이지만
//원인을 찾기 힘든 에러를 발생시킨 여지도 충분히 있음...
//=> 항상 의도를 가지고 원하는 자료형으로 변환해서 사용하는 것이 좋음
// '명시적 형변환'

//4. 형 변환

//String()  => 문자형으로 변환
//Number()  => 숫자형으로 변환
//Boolean() => 논리형으로 변환

//형 변환이 왜 필요한가요?
//자료형이 다른 두 변수를 계산했을 때, 원하는 결과가 나오지 않을 수 있음
//String()
document.write("String() <br>");
document.write(
   String(3) + "<br>",
   String(true) + "<br>",
   String(false) + "<br>",
   String(null) + "<br>",
   String(undefined) + "<br>"
);
document.write("---------------------<br>");

//Number()
document.write(Number(1) + "<br>");
;
document.write(
   Number(1234) + "<br>",
   Number("asdf") + "<br>",
   Number(true) + "<br>",
   Number(false) + "<br>"
);
document.write("---------------------<br>");
//false가 나오는 경우들을 알아두면...
// -숫자 0
// -빈 문자열("") / 띄어쓰기 X
// -null
// -undifined
// -NaN
// 이외에는 모두 true가 됨


//주의사항 -> 매뉴얼에 설명은 없으나 이해하기
 Number(null); //0
 Number(undefined) //NaN



 