<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="NBcheck.js"></script>
<title>⚾숫자야구⚾</title>
</head>
<body>
   <div class="nb__board">
	<aside>
	<div class="aside__block aside__block-baseball">
     <img src="baseball-logo.png" alt="숫자야구" / >
     </div>
	<div class="aside__block aside__block-text">숫자야구</div>
	<div class="aside__block aside__block-rounds">${r}</div>
	</aside>
	<main>
		<div class="block">
			<div class="block-text">S</div>
			<div class="block-result"><span>${s}</span></div>
		</div>
		<div class="block">
			<div class="block-text">B</div>
			<div class="block-result"><span>${b}</span></div>
		</div>
		<div class="block">
			<div class="block-text inputblock">P</div>
			<form class="ff" name=f action="HomeController" onsubmit="return checkValid();" >
			<input name="num" type=text autocomplete="off">
			<button>보내기</button>
			</form>
		</div>
	 </main>
	<footer>
	<form class="fo" action="HomeController" method="post">
	<button>다시하기</button>
	</form>
	<marquee>아무나 이겨라~~~~</marquee>
	</footer>
   </div>	
</body>
</html>