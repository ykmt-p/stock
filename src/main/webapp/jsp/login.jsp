<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
<title>ログイン</title>
<meta name="description" content="買い物リストとストック管理を紐付けて書い忘れを防ぐWEBアプリ">
<link rel="icon" type="image/png" href="images/favicon.png">
<%--CSS --%>
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" >
</head>
<body>
<h1 class="center formTitle">-STOCK- にログインする</h1>
<%-- メッセージを表示 --%>
<div class="center">
    <p>${requestScope.message}</p>
</div>
<!-- ログインフォーム。ユーザーIDとパスワードの入力を行う -->
<div class="center">
	<form action="Login" method="post">
    	ユーザーID：<input type="text" name="user_id"><br>
    	パスワード：<input type="password" name="pass"><br>
    	<input type="submit" id="loginButton" value="ログイン">
	</form>
</div>
<div class="center">
	<form action="Welcome" method="get">
		<input type="submit" value="戻る"/>
	</form>
</div>
</body>
</html>