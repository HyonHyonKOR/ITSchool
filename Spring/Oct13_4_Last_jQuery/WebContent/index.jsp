<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="jQuery.js"></script>
<script type="text/javascript" defer>

   $(function(){
	  
	
	   $('button').click(()=>{
		  let iVal = $('input').val();
		  
		  //$.getJSON 기능이 딸려서..
		  $.ajax({
			 url:'https://dapi.kakao.com/v3/search/book',
			 data:{query: iVal},
			 beforeSend:function(req){ //요청을 보내기 전에 콜백 함수
				 req.setRequestHeader('Authorization','KakaoAK 0ad31319314db7770c095cf2a6bcbd63');
			 },
			 success:function(bookJSON){
				// alert(JSON.stringify(bookJSON));
				
				//이미지 사진/ 책제목 - 출판사 / 정가 / 판매가
				$('table').empty();
				
				$.each(bookJSON.documents, (i,b) =>{
					let img = $('<img>').attr('src',b.thumbnail);
					let td1 = $('<td></td>').append(img);
					let td2 = $('<td></td>').text(b.title + '-' + b.publisher);
					let td3 = $('<td></td>').text(b.price + '원');
					let td4 = $('<td></td>').text(b.sale_price + '원');
					
					let tr = $('<tr></tr>').append(td1,td2,td3,td4);
					$('table').append(tr);
				});
			 }
		  });
		  
	   });
   });
</script>
<title>Insert title here</title>
</head>
<body>
  <input><button>찾기</button>
  <hr>
   <div id="chartContainer" style="height: 300px; width: 100%;">
  <table border="1"></table>
  </div>
</body>
</html>