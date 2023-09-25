function checkBoardValid(){
	let b_text = document.boardForm.b_text;
	
	if (isEmpty(b_text)) {
		alert('내용을 입력해주세요');
		b_text.value = "";
		b_text.focus();
		return false;
	}
	return true;
}
