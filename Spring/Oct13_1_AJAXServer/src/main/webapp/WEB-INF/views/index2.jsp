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
	  
	   alert('wow');
	   
	   $.ajax({
		   url :'error.getJSON',
		   success: function(zxc){
			  alert(JSON.stringify(zxc));   
		   }
	   });
	   
	   ///JSON으로 AJAX하기 간단한 ver.
	   //$.getJSON('요청주소'?파라미터=값&...", 값을 받아오는데 성공하면 발동하는 콜백함수)
	   $.getJSON('error.getJSON',function(zxc){
		 //alert(JSON.stringify(zxc));
		 //let ar = zxc.error;
		 //alert(ar[0].e_where);
		 $.each(zxc.error, function(i,e){
			 let td1 = $('<td></td>').text(e.e_what);
			 let td2 = $('<td></td>').text(e.e_where);
			 
			 let tr = $('<tr></tr>').append(td1,td2);
			 $('table').append(tr);
		 });		   
	   });
	   
	   
	   $('button').click(()=>{
		   let selectInput = $('input').val();

		   $.getJSON('error.getSelectedJSON?e_what=' + selectInput ,(result)=>{
		    
			 $('table').empty();
		     
		     $.each(result.error, (i, e)=>{
		       let td1 = $('<td></td>').text(e.e_what);
		       let td2 = $('<td></td>').text(e.e_where);
		       
		       let tr = $('<tr></tr>').append(td1, td2);
		       $('table').append(tr);
		       
		     });
		   });
		 });
	   
	   $('input').keyup(()=>{
	    	 //if(e.keyCode == 13){
				$('button').trigger('click');   		 
	    	// }
	      });
	   
   });
</script>
</head>
<body>
    <input name="e_what"><button>보내기</button>
    <hr>
	<table border ="1">
	
	</table>
</body>
</html>