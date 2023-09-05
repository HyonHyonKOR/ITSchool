//8. 자스에서의 함수에 대하여

alert("wow");

//파라미터 없는 함수
function showError(){
	alert("에러 발생!!!!");
}
showError();
//이 메시지를 하나의 서비스 중 여러군데에서 쓰고 있다고 가정해보면...
// ex) 로그인 실패, 결제 실패,...
// 위의 showError();를 불러다가 쓰면 된다

//파라미터가 있는 함수
/*
function sayHello(name){
   let msg = "Hello";
   if(name){
	msg+=`, ${name}`
   }
   alert(msg);
}

sayHello("Beaver");
//만약에 이름을 입력하지 않았다면?
sayHello(); //파라미터에 값을 넣지 않고 실행하면 => undefined
*/

let msg = "Hello" ; //어디에서나 접근할 수 있는 변수 : 전역 변수(Global Variable)
console.log("함수 호출 전");
console.log(msg);

function sayHello(name){
   //함수 내부에서 접근할 수 있는 변수 : 지역 변수(Local Variable)
   let msg = "Hello";
   if(name){
	msg+=`, ${name}`
   }
   console.log("함수 내부");
   console.log(msg);
}

sayHello("Beaver");
console.log("함수 호출 후");
console.log(msg);
//지역변수는 함수 내에서 전역변수와 같은 이름으로 지을 수 있고,
//서로 간섭을 받지 않음!

//전역변수가 많아진다면 관리하기 힘들기 때문에
//   =>가능하다면 함수에 특화되어있는 지역변수를 사용하자!!

//OR를 활용해서 기본값 넣기
function sayHello2(name){
	let newName= name || 'friend';
	let msg = `Hello, ${newName}`;
	console.log(msg);
}
sayHello2();
sayHello2("Beaver");

//기본값을 설정해서 (default value)
function sayHello3(name='Friend'){
    let msg = `Hello, ${name}`;
    console.log(msg);
}
sayHello3();
sayHello3("Beaver");

//return으로 값 반환하기
function add(num1,num2){
	return num1 + num2;
}
let result = add(2,3);
console.log(result);
//return은 반환하는 것과 동시에 함수를 종료하는 기능도 있음!

//정리
//-함수는 한번에 한 작업만 하는게 좋다.
//  => 하나의 함수가 여러 작업을 진행한다면, 여러개로 함수로 구현하기 

