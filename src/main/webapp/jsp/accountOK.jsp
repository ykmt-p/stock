<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STOCK 登録完了</title>
<%--CSS --%>
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>新規登録が完了しました！</h1>
<h2>よろしくね！<c:out value="${user_id}" />さん</h2>
<a href="Login">ログインページへ</a>
</body>
</html>