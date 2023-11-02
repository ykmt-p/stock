<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>削除</title>
    <link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=philosopher">
	<link rel="stylesheet" href="css/style.css"> 
</head>
<body>
<div class="wrapper">
	<div class="item"><jsp:include page="header.jsp"/></div>
	<div class="item"><a href="ShoppingList"><img class="outerBorder" src="<c:url value='/images/miniShoppingList.png' />" alt="お買い物リスト"></a></div>
	<div class="item"><a href="StockList"><img class="outerBorder" src="<c:url value='/images/miniInventoryList.png' />" alt="ストックリスト"></a></div>
</div>
<h1 class="center formTitle">ストックしておきたいもの一覧表</h1>
	<!-- デリートストックリストを表示 -->
	<div class="outerBorder center" id="list">
		<c:choose>
    	<c:when test="${not empty deleteStockList}">
    		<!-- デリートストックリストが空でない場合 -->
        	<form action="Delete" method="post">
            <ul>
                <c:forEach items="${deleteStockList}" var="item">
                    <li>
                    <!-- 商品名と店舗を表示 -->
                    <input type="checkbox" name="selectedItems" value="${item.getQuantity()}-${item.getProduct_name()}-${item.getUser_id()}" onclick="checkIfAnyCheckboxChecked();" /> 
                    ${item.getProduct_name()}<c:if test="${not empty item.getStore()}">: ${item.getStore()}</c:if>  
                    <!-- QUANTITYを非表示のinputフィールドとして渡す -->
                    <input type="hidden" name="quantities" value="${item.getQuantity()}" />
                    </li>
                </c:forEach>
            </ul>
            <input type="submit" value="選択した項目を削除" />
        	</form>
    	</c:when>
    	<c:otherwise>
    	<!-- デリートストックリストが空の場合 -->
    		<img src="<c:url value='/images/emptyList.png' />" alt="ストックリストは空です">
        </c:otherwise>
        </c:choose>
	</div>
</body>
<script src="javaScript/checkList.js"></script>
<script src="javaScript/checkbox.js"></script>
</html>