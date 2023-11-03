<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
<title>STOCK</title>
<meta name="description" content="買い物リストとストック管理を紐付けて書い忘れを防ぐWEBアプリ">
<link rel="icon" type="image/png" href="images/favicon.png">
<%--CSS --%>
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" >
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="center">
<button id="toggleButton">使い方</button>
<div id="content" class="hidden">
	<div class="circle">
	<ul>
		<li><a href="AddStockList" class="pink">ストックリスト</a>に家にあるものを入力</li>
		<li><a href="AddShoppingList" class="blue">お買い物リスト</a>に家に無いものを入力</li>
		<li>購入したら<a href="ShoppingList" class="blue">お買い物リスト</a>にチェックを入れる<br>&nbsp;&nbsp;→<a href="StockList" class="pink">ストックリスト</a>に反映される</li>
		<li>使い切ったら<a href="StockList" class="pink">ストックリスト</a>にチェックを入れる<br>&nbsp;&nbsp;→<a href="ShoppingList" class="blue">お買い物リスト</a>に反映される</li>
		<li>不要になったら<a href="DeleteStockList" class="orange">一覧表</a>から削除する</li>
		<li>取扱い店が限られている商品は店舗名も一緒にメモする</li>	
	</ul>
	</div>
</div>
<script src="javaScript/instructions.js"></script>
</div>
<div class="center"><a href="DeleteStockList"><img class="outerBorder  mini" src="<c:url value='/images/allThings.png' />" alt="ストックリストから削除"></a></div>
<div class="center wrapper" id="index">
	<div class="item">
		<a href="ShoppingList"><img class="outerBorder" src="<c:url value='/images/shoppingList.png' />" alt="お買い物リスト"></a>
	</div>
	<div class="item">
		<a href="StockList"><img class="outerBorder" src="<c:url value='/images/inventoryList.png' />" alt="ストックリスト"></a>
	</div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>