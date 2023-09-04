//6. 조건문
// if-else if- else
// .. 예제 생략 

//switch-case
// case가 다양할 때, 보다 간결하게 나타낼 수 있다는 장점

/*
switch(변수명){
    case 값1:
            내용
    ...
    default:
        내용        
}
*/

let fruit = prompt('가격을 찾고 싶은 과일의 이름을 입력하세요')

switch(fruit){
    case'사과': {
        alert(`${fruit} : 100원`);
break;
    }
    case'바나나':{
        alert(`${fruit} : 200원`);
break;
    }
    case'키위':{
        alert(`${fruit} : 300원`);
break;
    }
    case '수박':
    case '멜론':{
        alert(`${fruit} : 500원`);
break;
    }
    default:
        alert(`${fruit} : 없습니다.`)
}
