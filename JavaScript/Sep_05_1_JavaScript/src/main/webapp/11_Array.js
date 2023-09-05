//11. 배열
// 순서가 있는 리스트
let students = ["곽두팔","김춘삼","이춘식"];
console.log(students[1]); //인덱스는 0부터 시작!!!

//배열은 문자뿐만 아니라, 숫자, 객체, 함수,...포함할 수 있음
let arr = [
	"비버",
	3,
	false,
	{
		name:"비붜",
		age:7,
	},
	function(){
		console.log('Test');
	}
]

console.log(arr);

//length: 배열의 길이
console.log(arr.length);

let days =["월","화","수"];
console.log(days);

//stack data structure
days.push("목");
console.log(days);

days.pop();
console.log(days);

//shift(),unshift() : 배열의 제일 앞에 있는 요소 제거/추가
days.shift();
console.log(days);

//unshift()는 여러개 요소들을 추가할 수 있음!
days.unshift("목","금","토");
console.log(days);

//배열을 쓰는 가장 큰 이유는 중 하나는 => 반복문을 사용하기 위해서...
for(let i =0; i<days.length; i++){
	console.log(days[i]);
}

console.log("-----------");
//for . of (Java의 for-each)
for(let day of days){
	console.log(day);
}

days.unshift("오늘 수업 끝");
console.log(days);