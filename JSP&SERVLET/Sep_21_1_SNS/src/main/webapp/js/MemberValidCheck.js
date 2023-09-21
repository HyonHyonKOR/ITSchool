	
	let m_id = document.form.m_id; 
	let m_password = document.form.m_password; 
	let m_password2 = document.form.m_password2; 
	let m_name = document.form.m_name; 
	let m_phonenum = document.form.m_phonenum; 
	let m_photo = document.form.m_photo;
	
	const checkNum=/[0-9]/;
	const checkEng = /[a-zA-Z]/;
	const checkKor = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	const checkExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/;
	const checkPhone = /01[016789][^0][0-9]{2,3}[0-9]{3,4}/;
	const MAXSIZE=10*1024*1024;	
	
	function checkJoinValid(){
	
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
	
	if(!checkEng.test(m_password.value) || !checkNum.test(m_password.value) || !checkExp.test(m_password.value)){
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
	
	if(notEqualPw(m_password,m_password2)){
	alert("입력된 비밀번호와 다릅니다.");
	m_password2.focus();
	m_password2.value="";
	return false;
	}

     
    if(!checkKor.test(m_name.value)&&!checkEng.test(m_name.value)){
	alert("이름은 한글 혹은 영어만 입력 가능합니다.");
	m_name.focus();
	m_name.value="";
	return false;
	}else if(checkKor.test(m_name.value)&& checkEng.test(m_name.value)){
	alert("한 종류의 문자만 입력 가능합니다.");
	m_name.focus();
	m_name.value="";
	return false;
	}else if(atLeastLetter(m_name,2)){
	alert("2자리 이상의 문자를 입력해주세요.");
	m_name.focus();
	m_name.value="";
	return false;
	}
	
    if(!checkPhone.test(m_phonenum.value)|| atLeastLetter(m_phonenum,11)){
	alert("핸드폰 번호를 다시 입력해주세요");
	m_phonenum.focus();
	m_phonenum.value="";
	return false;
	}	
	
	if(m_photo.files[0].size > MAXSIZE){
	alert("10mb 이하의 사진만 업로드 가능합니다.");
	m_photo.focus();
	return false;	
    }
	
	return true;
	
}//checkJoinValid()
	
	
	function checkUpdateValid(){
	
	
	if(!checkEng.test(m_password.value) || !checkNum.test(m_password.value) || !checkExp.test(m_password.value)){
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
	
	if(notEqualPw(m_password,m_password2)){
	alert("입력된 비밀번호와 다릅니다.");
	m_password2.focus();
	m_password2.value="";
	return false;
	}

    if(!checkKor.test(m_name.value)&&!checkEng.test(m_name.value)){
	alert("이름은 한글 혹은 영어만 입력 가능합니다.");
	m_name.focus();
	m_name.value="";
	return false;
	}else if(checkKor.test(m_name.value)&& checkEng.test(m_name.value)){
	alert("한 종류의 문자만 입력 가능합니다.");
	m_name.focus();
	m_name.value="";
	return false;
	}else if(atLeastLetter(m_name,2)){
	alert("2자리 이상의 문자를 입력해주세요.");
	m_name.focus();
	m_name.value="";
	return false;
	}
	
    if(!checkPhone.test(m_phonenum.value)|| atLeastLetter(m_phonenum,11)){
	alert("핸드폰 번호를 다시 입력해주세요");
	m_phonenum.focus();
	m_phonenum.value="";
	return false;
	}	
	
	if(m_photo.files[0].size > MAXSIZE){
	alert("10mb 이하의 사진만 업로드 가능합니다.");
	m_photo.focus();
	return false;	
    }
	
	return true;
	
}//checkUpdateValid()
	
	
	function checkLoginValid(){
	
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
	
	if(!checkEng.test(m_password.value) || !checkNum.test(m_password.value) || !checkExp.test(m_password.value)){
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
}//checkLoginValid()




