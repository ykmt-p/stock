<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
	<title>追加</title>
	<meta name="description" content="買い物リストとストック管理を紐付けて書い忘れを防ぐWEBアプリ">
	<link rel="icon" type="image/png" href="images/favicon.png">
    <link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
	<link rel="stylesheet" href="css/style.css"> 
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" >
</head>
<body>
<div class="wrapper">
	<div class="item"><jsp:include page="header.jsp"/></div>
	<div class="item"><a href="ShoppingList"><img class="outerBorder" src="<c:url value='/images/miniShoppingList.png' />" alt="お買い物リスト"></a></div>
	<div class="item"><a href="StockList"><img class="outerBorder" src="<c:url value='/images/miniInventoryList.png' />" alt="ストックリスト"></a></div>
</div>
<h1 class="formTitle">お買い物リストに追加</h1>
		<c:if test="${product_name != null}">
    		<h2><c:out value="${product_name}"/>を追加しました！</h2>
		</c:if>
	<form id="listForm" class="addListForm" action="AddShoppingList" method="post">
	 	<div>
	 		<label for="name">品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名*：</label>
	 		<input type="text" name="product_name">
	 	</div>
	    <div>
	   	 	<label for="name">取扱い店：</label>
	   	 	<input type="text" name="store">
	    </div>
        <!-- 必要数量は常に0として送信 -->
        <input type="hidden" name="quantity" value="0">
	    <input class="right" type="submit" value="お買い物リストに追加">
	</form>
	<jsp:include page="footer.jsp"/>
</body>
<script src="javaScript/validation.js"></script>
</html>
