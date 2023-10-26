<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<jsp:include page="header.jsp"/>
<h1 class="container">STOCKへようこそ</h1>
<div class="container">
<button id="toggleButton">使い方</button>
<div id="content" class="hidden">
	<ul>
		<li><span class="brown">ストックリスト</span>に必要なものを入力→<br>&nbsp;&nbsp;ストックが不足していると<span class="pink">お買い物リスト</span>に反映される</li>
		<li>無事に購入したら<span class="pink">お買い物リスト</span>にチェックを入れる→<br>&nbsp;&nbsp;<span class="brown">ストックリスト</span>にストック数が反映される</li>
		<li>使い切ったら<span class="brown">ストックリスト</span>にチェックを入れる→<br>&nbsp;&nbsp;<span class="brown">ストックリスト</span>のストック数に反映される</li>
	</ul>
</div>
<script src="javaScript/instructions.js"></script>
</div>
<div class="buy wrapper">
	<article>
		<a href="#"><img class="buyList" src="<c:url value='/images/buyList.png' />" alt="お買い物リスト"></a>
	</article>
	<aside>
		<p>買い忘れなかったかなー。</p>
	</aside>
</div>
<div class="stock wrapper">
	<article>
		<p>アレまだあったっけなー。</p>
	</article> 
	<aside>
		<a href="#"><img class="stockList" src="<c:url value='/images/stockList.png' />" alt="ストックリスト"></a>	
	</aside>
</div>
</body>
</html>