function checkSignUpValid() {
	
	let m_id = document.signUpForm.m_id;
	let m_pw = document.signUpForm.m_pw;
	let m_pw2 = document.signUpForm.m_pw2;
	let m_name = document.signUpForm.m_name;
	let m_phone = document.signUpForm.m_phone;
	let m_photo = document.signUpForm.m_photo;
	
	if (isEmpty(m_id) || containsAnother(m_id)) {
		alert("Please Fill in ID Properly.");
		m_id.value = "";
		m_id.focus();
		return false;
		
	} else if (isEmpty(m_pw) || notEqualPw(m_pw, m_pw2)) {
		alert("Please Fill in Password Properly.");
		m_pw.value = "";
		m_pw2.value = "";
		m_pw.focus();
		return false;
		
	} else if(isEmpty(m_name)) {
		alert("Please Fill in Name Properly.");
		m_name.value = "";
		m_name.focus();
		return false;
		
	} else if (isEmpty(m_phone) || isNotNumber(m_phone)) {
		alert("Please Fill in Phone Number Properly.");
		m_phone.value = "";
		m_phone.focus();
		return false;
		
	} else if (isEmpty(m_photo) || (isNotType(m_photo, "png")
		&& isNotType(m_photo, "gif") && isNotType(m_photo, "webp")
		&& isNotType(m_photo, "png") && isNotType(m_photo, "jpeg"))) {
		alert("Please Fill in Photo Properly.");
		m_photo.value = "";
		m_photo.focus();
		return false;
	}
	return true;
}


function checkloginValid() {
	let m_id = document.loginForm.m_id;
	let m_pw = document.loginForm.m_pw;
	
	if (isEmpty(m_id) || containsAnother(m_id)) {
		alert("Please Fill in ID Properly.");
		m_id.value = "";
		m_id.focus();
		return false;
	} else if (isEmpty(m_pw)) {
		alert("Please Fill in Password Properly.");
		m_pw.value = "";
		m_pw.focus();
		return false;
	}
	return true;
}


function checkUpdateValid(){
	
	let m_id = document.signUpForm.m_id;
	let m_pw = document.signUpForm.m_pw;
	let m_pw2 = document.signUpForm.m_pw2;
	let m_name = document.signUpForm.m_name;
	let m_phone = document.signUpForm.m_phone;
	let m_photo = document.signUpForm.m_photo;
	
	if (isEmpty(m_id) || containsAnother(m_id)) {
		alert("Please Fill in ID Properly.");
		m_id.value = "";
		m_id.focus();
		return false;
		
	} else if (isEmpty(m_pw) || notEqualPw(m_pw, m_pw2)) {
		alert("Please Fill in Password Properly.");
		m_pw.value = "";
		m_pw2.value = "";
		m_pw.focus();
		return false;
		
	} else if(isEmpty(m_name)) {
		alert("Please Fill in Name Properly.");
		m_name.value = "";
		m_name.focus();
		return false;
		
	} else if (isEmpty(m_phone) || isNotNumber(m_phone)) {
		alert("Please Fill in Phone Number Properly.");
		m_phone.value = "";
		m_phone.focus();
		return false;
	} 
	
	return true;
}