<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STOCK ユーザー登録</title>
</head>
<body>
<h1>ユーザー情報の新規登録</h1>
 


<!-- 新規登録フォーム。ユーザー情報の入力を行う -->
<form action="Account" method="post">
    ユーザーID：<input type="text" name="user_id"><br>
    パスワード：<input type="password" name="pass"><br>
    メールアドレス：<input type="text" name="mail"><br>
    氏名：<input type="text" name="name"><br>
    <input type="submit" value="登録">
</form>
</body>
</html>