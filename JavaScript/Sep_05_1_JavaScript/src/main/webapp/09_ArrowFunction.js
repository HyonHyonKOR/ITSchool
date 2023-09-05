//함수 표현식
/*
let sayHello = function(){
	console.log("Hello");
}

//함수 선언식 vs 함수 표현식
*/

function sayHello(){
	console.log('Hello');
}
sayHello();

//JS는 프로그램이 실행되기 전에 모든 '함수선언문'을 찾아 모아서 
//메모리에 저장하고 있다가 필요할 때 내부적으로 끌어올려서 사용하는 것 
//저장이 되어 있기 때문에 => 함수가 먼저 호출이 되어도 오류없이 잘 작동함
//실제적으로 코드가 끌려올려지는 것은 아니고, 실제 메모리상에 변화는 없음
//이것을 호이스팅이라고 함

//'함수 표현식'은 코드에 도달하면 생성 
// 여지껏 봤던 함수(함수 선언문)보다 더 간결하게 작성할 수 있는 함수

//1.
/*
let add = function(num1, num2){
	return num1+num2;
}
*/

//2
/*
let add =(num1,num2) =>{
	return num1 + num2;
}
*/

//3
/*
let add = (num1,num2) => {
      num1+num2 
}
*/

//4. 반환할 코드가 한 줄이라면 => 중괄호 생략 가능 O
let add = (num1,num2)=> num1+num2;

//5. 파라미터가 하나라면...
let sayHello2 = name => `Hello, ${name}`;

//6. 파라미터가 없는 함수라면 괄호 생략 가능 X
let asdf = () => console.log('asdf');
asdf();

//Function vs Method
let human= {
	name:"김비버",
	walk:function(){
		console.log("걷는 중");
	}
}
//메소드는 결국 객체의 프로퍼티로 할당된 함수
