//2. 자료형
// 문자형 String

let name1 = "Beaver";
let name2 = 'Beaver';
let name3 = `Beaver`;  //~표시할 때 shift 안누른키 ``(backtick)

let message1 = "I'm a boy.";
let message2 = 'I\'m a boy.'; //작은 따옴표 사용시 \ 역슬래시 넣으면
                              //'를 특수문자로 인식함

//문자열 내부에 변수를 표현할 때 사용하면 좋은 backtick!!
//${변수명}을 넣어서 표현함
let message3 = `my name is ${name1}`;
document.write(message3 + `<br>`);
let message4 = "my name is ${name1}";
document.write(message4 + '<br>');

//계산(표현식)도 사용 가능
let message5 = `I am ${100+99} years old.`;
document.write(message5 + '<br>');
document.write('---------------------------<br>');

//숫자형 Number (정수 / 실수)
let age = 100;
let height = 187.3;

//역시나 사칙연산이 가능!
document.write(1+2 + '<br>'); //더하기
document.write(1-2 + '<br>'); //빼기
document.write(1*2 + '<br>'); //곱하기
document.write(1/2 + '<br>'); //나누기
document.write(6%4 + '<br>'); //나머지

let a =1/0;
document.write(a+'<br>'); //무한

let b = name1 / 2;
document.write(b+'<br>'); //NaN(Not a Number)

//글자끼리 이어주기도 가능 O 
let aa = "나는 ";
let bb = "입니다.";
document.write(aa + name1 + bb + '<br>');
document.write(aa + age + '살' + bb +'<br>');
document.write('---------------------------<br>');

// 논리형
let c = true;
let d = false;

document.write((name1 == "Beaver") + '<br>');
document.write((age<20) + '<br>');
document.write('---------------------------<br>');

// null, undefinded
let e;  
document.write(e+'<br>');

let f = null;
document.write(f+'<br>');
document.write('---------------------------<br>'); //null: 존재하지 않는 값

//typeof연산자: 변수의 자료형을 알아낼 때 사용
//직접 코드를 짰으면 당연히 이 연산자는 쓸모 X
//다른 개발자가 코드를 짰을 때, 변수에 대한 자료형을 알아야 할 때 
// or API를 통해서 받아온 데이터의 자료형을 알아내서 
// 다른 방식으로 처리해야하는 경우에 사용 
document.write(typeof name1 + '<br>');
document.write(typeof age + '<br>');
document.write(typeof c + '<br>');
document.write(typeof e + '<br>');
document.write(typeof f + '<br>');
