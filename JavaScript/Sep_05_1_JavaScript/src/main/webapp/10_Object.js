//10. 객체(Object)

let mouse = {
	manufacture:"로지텍",
	price: 32000,
}

//객체는 중괄호 안에서 구성되며,key와 value값으로 구성된 프로퍼티(속성)
//각각 쉼표로 구분하고 마지막에는 쉼표가 없어도 되지만 나중에 수정할 것을 생각하면 적어도 됨

//접근
console.log(mouse.manufacture);
console.log(mouse['price']);

//추가
mouse.size=15;
mouse['color'] = 'black';
console.log(mouse);

//삭제
delete mouse.size;
console.log(mouse);
////////////////////////////

let name = "Hyon";
let age = 5;

let person = {
	name:name,
	age:age,
	gender:"male",
}


/*
let person = {
    name,
    age,
    gender:"male",
}
*/
//이런 형태로 표현 가능(key=value)
//존재하지 않는 속성에 접근하면, 에러가 발생하는 게 아닌 undefined값이 나옴

//이떄, 'in' 연산자를 사용하면 내가 찾는 속성이 있는지 확인할 수 있음
console.log('birthday' in person);
console.log('age' in person);

for(let key in person){
	console.log(key);
	console.log(person[key])
}

//함수로 객체 만들기
function makeObject(name,age){
	return{
		name,
		age,
		hobby:"Game",
	}
}

let beaver = makeObject("Beaver",5);
console.log(beaver);