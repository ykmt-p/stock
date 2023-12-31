<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
	<title>お買い物リスト</title>
	<meta name="description" content="買い物リストとストック管理を紐付けて買い忘れを防ぐWEBアプリ">
	<link rel="icon" type="image/png" href="images/favicon.png">
    <link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
	<link rel="stylesheet" href="css/style.css"> 
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" >
</head>
<body>
	<div class="wrapper">
		<div class="item"><jsp:include page="header.jsp"/></div>
		<div class="item"><a href="AddShoppingList"><img class="outerBorder" src="<c:url value='/images/addList.png' />" alt="お買い物リストに追加"></a></div>
		<div class="item"><a href="StockList"><img class="outerBorder" src="<c:url value='/images/miniInventoryList.png' />" alt="ストックリスト"></a></div>
		<div class="item"><a href="AllThings"><img class="outerBorder" src="<c:url value='/images/allThings.png' />" alt="一覧表"></a></div>
	</div>
	<!-- パンくずリストを表示 -->
	<ol class="breadcrumb" itemscope itemtype="https://schema.org/BreadcrumbList">
  		<li itemprop="itemListElement" itemscope　itemtype="https://schema.org/ListItem">
      		<a itemprop="item" href="Index">
        		<span itemprop="name">ホーム</span></a>
      		<meta itemprop="position" content="1" />
  		</li>
  	<!-- 2つめ -->
  		<li itemprop="itemListElement" itemscope　itemtype="https://schema.org/ListItem">
      		<a itemprop="item" href="ShoppingList">
       	 	<span itemprop="name">お買い物リスト</span></a>
     		 <meta itemprop="position" content="2" />
  		</li>
	</ol>
	<h1 class="center formTitle">お買い物リスト</h1>
	<!-- お買い物リストを表示 -->
	<div class="center outerBorder" id="list">
    <c:choose>
        <c:when test="${not empty shoppingList}">
        <!-- お買い物リストが空でない場合 -->
            <form action="CompleteShopping" method="post">
                <ul>
                    <c:forEach items="${shoppingList}" var="item">
                        <li>
                            <!-- 商品名と店舗を表示 -->
                            <input type="checkbox" name="selectedItems" value="${item.getQuantity()}-${item.getProduct_name()}-${item.getUser_id()}" onclick="checkIfAnyCheckboxChecked();" /> 
                            ${item.getProduct_name()}<c:if test="${not empty item.getStore()}">: ${item.getStore()}</c:if> 
                            <!-- QUANTITYを非表示のinputフィールドとして渡す -->
                            <input type="hidden" name="quantities" value="${item.getQuantity()}" />
                        </li>
                    </c:forEach>
                </ul>
                <input type="submit" value="お買い物完了" />
            </form>
        </c:when>
        <c:otherwise>
        	 <!-- お買い物リストが空の場合 -->
            <img src="<c:url value='/images/emptyList.png' />" alt="お買い物リストは空です">
        </c:otherwise>
    </c:choose>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
<script src="javaScript/checkList.js"></script>
<script src="javaScript/checkbox.js"></script>
</html>