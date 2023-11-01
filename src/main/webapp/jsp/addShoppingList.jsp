<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>追加</title>
    <link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=philosopher">
	<link rel="stylesheet" href="css/style.css"> 
</head>
<body>
<jsp:include page="header.jsp"/>
	<h1>お買い物リストに追加</h1>
		<c:if test="${product_name != null}">
    		<h2><c:out value="${product_name}"/>を追加しました！</h2>
		</c:if>
	<form id="shoppingListForm" action="AddShoppingList" method="post">
	 	<div>
	 		<label for="name">品名：</label>
	 		<input type="text" name="product_name" placeholder="柔軟剤">
	 	</div>
	    <div>
	   	 	<label for="name">取扱い店：</label>
	   	 	<input type="text" name="store" placeholder="ウエルシア">
	    </div>
        <!-- 必要数量は常に0として送信 -->
        <input type="hidden" name="quantity" value="0">
	    <input type="submit" value="お買い物リストに追加">
	</form>
	<form action="ShoppingList" method="get">
    	<input type="submit" value="お買い物リストに戻る">
	</form>
</body>
</html>
