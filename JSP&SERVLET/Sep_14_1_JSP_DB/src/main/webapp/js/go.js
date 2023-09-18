function goAppleDetail(loc){
	location.href="AppleInfoController?a_location=" + encodeURI(loc);
}
function deleteApple(loc){
	confirm(`${loc} 사과 데이터를 삭제하시겠습니까?`)
	if(t){
	location.href="AppleDeleteController?a_location=" + encodeURI(loc);
	}
}