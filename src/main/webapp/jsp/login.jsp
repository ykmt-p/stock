<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STOCK</title>
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