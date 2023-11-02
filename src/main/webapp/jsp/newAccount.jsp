<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STOCK ユーザー登録</title>
<%--CSS --%>
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1 class="center formTitle">ユーザー情報の新規登録</h1>
<!-- エラーメッセージを表示 -->
 <c:if test="${not empty errorMessage}">
    <div class="alert alert-danger">${errorMessage}</div>
</c:if>
 <!-- 新規登録フォーム。ユーザー情報の入力を行う -->
 <div class="center">
	<form action="Registration" method="post">
    	  ユーザーID：<br><input type="text" name="user_id"/><br>
    	  パスワード：<br><input type="password" name="pass"/><br>
    	メールアドレス：<br><input type="text" name="mail"/>
    	<input type="submit" id="loginButton"  value="登録"/>
	</form>
</div>
<div class="center">
	<form action="Welcome" method="get">
		<input type="submit" value="戻る"/>
	</form>
</div>
</body>
</html>