<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="css/style.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="HJ">
<header>
<span>홀짝 게임</span>
</header>
<main>
<form class=oddeven__btn action="C">
<button class=oddeven__btn-odd name="oe" value="1"><span>홀</span></button>
<button class=oddeven__btn-even name="oe" value="0"><span>짝</span></button>
</form><br>
<div><span>선택하신 답 ${u}</span></div>
<div><span>컴퓨터의 동전 갯수 ${c}</span></div>
<div><span>${g}</span></div><br>
<div><span>전적 ${r}전 ${w}승 ${l}패 </span></div>
<div><span>승률 ${wr}</span></div>
</main>
<footer>
<form class= "reset__btn" action="C" method="post">
<button name="reset" value="reset"><span>리셋</span></button>
</form>
</footer>
</div>
</body>
</html>