//5. 연산자
// 산술연산자 : + , - , / , * , %

//거듭제곱
//let num1 = 2 ** 3;
//alert(num1);

//우선 순위
//(*,/) > (+,-)

//연산자를 줄여서 쓰는 것도 가능 
let num1 = 10;
//num1 = num1+5;
num1 += 5;

//증감 연산자
let num2 = 20;
num2++;
document.write(num2+"<br>");

//비교연산자(Java 때와 같음)
//<> <= >= == != 
document.write("----------------<br>");
document.write((10>5) + "<br>");
document.write((10==5) + "<br>");
document.write((10<5) +"<br>");
document.write("----------------<br>");

document.write((10=="10")+"<br>"); //true(o)
//=> 자동 형변환때문에 true
document.write(("10" === 10) + "<br>");
// => ===, !== : 일치연산자/ 자료형까지도 비교를 해줌! 

// 논리연산자
// || (OR)
// 여러개 중 하나라도 true면 true를 반환
//     => 모든 값이 false일때만 false를 반환
//     => 첫번재 true 값을 발견하는 즉시 멈춤

//&&(AND)
//모든 값이 true여야 true를 반환
//      => 하나로도 false가 나오면 false를 반환
//     => 첫번째 false값을 발견하는 즉시 멈춤

//!(NOT)
//반대의 값으로 반환
// true => false / false => true



   