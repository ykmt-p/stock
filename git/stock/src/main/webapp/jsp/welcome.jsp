<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
<title>STOCK</title>
<meta name="description" content="買い物リストとストック管理を紐付けて買い忘れを防ぐWEBアプリ">
<link rel="icon" type="image/png" href="images/favicon.png">
<%--CSS --%>
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" >
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
</head>
<body>
<h1 class="center">-STOCK- へようこそ</h1>
<p  class="center introduction">おうちの在庫管理を頭の中から取り出してスッキリさせる<br>そんなちょっとしたお助けアプリ-STOCK-<br>日々の家事が少しでも楽になったら幸いです.＊</p>
<div class="center video">
	<video controls muted autoplay playsinline poster="images/sample.png">
  		<source src="video/STOCK.mp4" type="video/mp4">
  		<p>ブラウザに対応していないため、動画を再生できません。</p>
	</video>
</div>
<div class="wrapper center">
	<div class="item">
		<form action="Login" method="get">
		<input type="submit" value="ログイン"/>
		</form>
	</div>
	<div class="item">
		<form action="Registration" method="get">
		<input type="submit" value="新規登録"/>
		</form>
	</div>
</div>
</body>
</html>