function checkLoginValid(){
	
	let m_id = document.login.m_id; 
	let m_password = document.login.m_password; 
	
	const checkNum=/[0-9]/;
	const checkEng = /[a-zA-Z]/;
	const regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/;
		 
	if(!checkNum.test(m_id.value)&&!checkEng.test(m_id.value)){
	alert("아이디는 영어와 숫자만 가능합니다.");
	m_id.focus();
	m_id.value="";
	return false;
	}
	else if(atLeastLetter(m_id,6)){
	alert("6자리 이상의 아이디를 입력해주세요.");
	m_id.focus();
	m_id.value="";
	return false;
	}
	
	if(!checkEng.test(m_password.value) || !checkNum.test(m_password.value) || !regExp.test(m_password.value)){
	alert("비밀번호는 영문자,숫자,특수문자가 1자 이상 포함되어야합니다.");
	m_password.focus();
	m_password.value="";
	return false;
	}
	else if(atLeastLetter(m_password,6)){
	alert("6자리 이상의 비밀번호를 입력해주세요.");
	m_password.focus();
	m_password.value="";
	return false;
	}
	
	
	return true;
}
	
	


