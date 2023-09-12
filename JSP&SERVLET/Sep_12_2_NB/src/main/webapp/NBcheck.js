function checkValid(){
	
	let num = document.f.num;

		if(!num.value){
			alert('세자리의 숫자를 입력해주세요.\n각 자리는 서로 다른 숫자만 입력 가능합니다.\n예시: 987,156');
			num.value="";
			return false;
		}
	
		if(num.value.length!=3){
			alert('세자리의 숫자만 입력 가능합니다.\n각 자리는 서로 다른 숫자만 입력 가능합니다.\n예시: 987,156');
			num.value="";
			return false;
		}
	
	const checkNum = /[0-9]/;
		if(!checkNum.test(num.value)){
			alert('숫자만 입력 가능합니다.\n각 자리는 서로 다른 숫자만 입력 가능합니다.\n예시: 987,156');
			num.value="";
			return false;
		}
	
	function checkDuplication(num){
    	if(num.value[0]==num.value[1]&&num.value[1]==num.value[2]){
		alert('모두 다 중복된 숫자입니다.\n각 자리는 서로 다른 숫자만 입력 가능합니다.\n올바른 예) 987,156');
		return true;
		}
    	else if(num.value[0]==num.value[1]){
		alert('첫번째 숫자와 두번째 숫자가 같습니다.\n각 자리는 서로 다른 숫자만 입력 가능합니다.\n올바른 예) 987,156');
		return true;	
		}
		else if	(num.value[0]==num.value[2]){
		alert('첫번째 숫자와 마지막 숫자가 같습니다.\n각 자리는 서로 다른 숫자만 입력 가능합니다.\n올바른 예) 987,156');
		return true;
		}
		else if(num.value[1]==num.value[2]){
		alert('두번째 숫자와 마지막 숫자가 같습니다.\n각 자리는 서로 다른 숫자만 입력 가능합니다.\n올바른 예) 987,156');
		return true;
    	}
    return false;
    }
    
    if(checkDuplication(num)){
	num.value="";
	return false;
	}
	
	return true;
}