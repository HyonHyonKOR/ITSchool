<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript" defer>
   $(function(){
	   //AJAX (Asynchoronous Javascript And XML)
	   // : 자바스크립트를 통해서 서버에 데이터를 요청하는 것
	   $('#btn').click(()=>{
		 
		  $.ajax({   //함수 X , 객체 O
			  url:'fruit.getXML',  //url속성에 value 값 (Controller에 설정한 요청 주소)
		      success : function(asd){  //요청 성공하면 function 동작
		    	  //alert(asd);xml 문서라는게 확인됨
		    	  
		    	  //DOM객체 하나 불러올때마다 나오는 콜백 함수
		    	  $(asd).find('fruit').each((i,f) => {
		    		  //alert(i + ')'   +  f);
		    	      let f_name = $(f).find('f_name').text();
		    	      let f_price = $(f).find('f_price').text();
		    	      alert(f_name + ']' + f_price);
		    	  });
		      }
	   
	   });
	   
   });
   
      //fruit.getXML에 요청해서
      //나오는 모든 데이터를 가지고
      //테이블을 구성해주세요
      
      
      $.ajax({
    	  url:'fruit.getXML', 
    	  success : function(maketable){
    	  
          $(maketable).find('fruit').each((i,f) => {
        	  
        	 $('#fruitTbl')
        	 .append('<tr><td>' 
        			 + $(f).find('f_name').text() 
        			 + '</td><td>' 
        			 + $(f).find('f_price').text()
        			 +'</td></tr>');    
            });		  
         }
      }); //function.end
      
      
      //input에 숫자를 입력받아서 => 검색버튼 누르면
      // 입력한 숫자 이하의 가격인 과일들의 이름, 가격 데이터를 가지고
      // 테이블을 구성하기!
      
      $('#btn2').click(() => {
    	  let frVal = $("#searchinput").val();
    	 
          $.ajax({
        	  url:'fruit.getPriceFruitXML', 
        	  data: {f_price: frVal},
        	  success : function(maketable){
        	  
              $("#fruitTbl").empty();
              $(maketable).find('fruit').each((i,f) => {
            	  
            	 $('#fruitTbl')
            	 .append('<tr><td>' 
            			 + $(f).find('f_name').text() 
            			 + '</td><td>' 
            			 + $(f).find('f_price').text()
            			 +'</td></tr>');    
                });		  
             }
          });
    	  
      });
       
      
      $('#searchinput').keyup(()=>{
    	 //if(e.keyCode == 13){
			$('#btn2').trigger('click');   		 
    	// }
      });
      
      
   
}); 
</script>
</head>
<body>
   <table id="fruitTbl" border="1">
   
   
   </table>
   <hr>
   <button id="btn">버튼</button>
   <hr>
   
   <input id="searchinput" name="f_price"> <button id="btn2">가격 전송</button>

</body>
</html>