<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STOCK</title>
<%--CSS --%>
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<%-- メッセージを表示 --%>
    <p>${requestScope.message}</p>
<!-- ログインフォーム。ユーザーIDとパスワードの入力を行う -->
<form action="Login" method="post">
    ユーザーID：<input type="text" name="user_id"><br>
    パスワード：<input type="password" name="pass"><br>
    <input type="submit" value="ログイン">
</form>
</body>
</html>