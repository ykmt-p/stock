<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
<title>STOCK ユーザー登録</title>
<meta name="description" content="買い物リストとストック管理を紐付けて買い忘れを防ぐWEBアプリ">
<link rel="icon" type="image/png" href="images/favicon.png">
<%--CSS --%>
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" >
</head>
<body>
<h1 class="center formTitle">ユーザー情報の新規登録</h1>
<!-- エラーメッセージを表示 -->
 <c:if test="${not empty errorMessage}">
    <div class="center" style="color: red;">${errorMessage}</div>
 </c:if>
 <!-- 新規登録フォーム。ユーザー情報の入力を行う -->
 <div class="center">
	<form action="Registration" method="post">
    	  ユーザーID：<br><input type="text" name="user_id"/><br>
    	  パスワード：<br><input type="password" name="pass"/><br>
    	メールアドレス：<br><input type="email" name="mail" required/><br>
    	<input type="submit" id="loginButton"  value="登  録"/>
	</form>
</div>
<div class="center">
	<form action="Welcome" method="get">
		<input type="submit" value="戻  る"/>
	</form>
</div>
</body>
</html>