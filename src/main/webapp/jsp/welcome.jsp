<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STOCK</title>
<meta name="description" content="買い物リストとストック管理を紐付けて書い忘れを防ぐWEBアプリ">
<link rel="icon" type="image/png" href="images/favicon.png">
<%--CSS --%>
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1 class="center title">-STOCK- へようこそ</h1>
<p  class="center introduction">おうちの在庫管理を頭の中から取り出してスッキリさせる<br>そんなちょっとしたお助けアプリ-STOCK-<br>日々の家事が少しでも楽になったら幸いです.＊</p>

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