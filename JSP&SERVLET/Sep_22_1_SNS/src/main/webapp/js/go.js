function goHome(){
  location.href="HomeController";
}

function goSignUp(){
  location.href="SignUpController";
}

function goLogout(){
  location.href="LoginController";
}
function goMemberInfo(){
  location.href="MemberInfoController";
}

function goDeletePage(){
	let check = prompt("정말로 삭제하겠습니까? Y/N");
	if(check == "Y"){
	location.href="MemberDeleteController";
	}
}
function goBoard(){
	location.href="BoardController";
}

function boardUpdate(b_no){
	let b_text = prompt("변경 내용");
	//alert(b_text);
	if(b_text.length<=200){
		location.href="BoardUpdateController?b_no=" + b_no + "&b_text=" + encodeURI(b_text);
	}
}

function goDelete(b_no){
	let t  = confirm("삭제하시겠습니까?");
	if(t){
		location.href="BoardDeleteController?b_no=" + b_no;
	}
}