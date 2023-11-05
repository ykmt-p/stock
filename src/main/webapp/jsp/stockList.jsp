<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
	<title>ストックリスト</title>
	<meta name="description" content="買い物リストとストック管理を紐付けて書い忘れを防ぐWEBアプリ">
	<link rel="icon" type="image/png" href="images/favicon.png">
	<!-- css -->
    <link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
	<link rel="stylesheet" href="css/style.css"> 
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" >
</head>
<body>
	<div class="wrapper">
		<div class="item"><jsp:include page="header.jsp"/></div>
		<div class="item"><a href="AddStockList"><img class="outerBorder" src="<c:url value='/images/addList.png' />" alt="ストックリストに追加"></a></div>
		<div class="item"><a href="AllThings"><img class="outerBorder" src="<c:url value='/images/allThings.png' />" alt="一覧表"></a></div>
	</div>
	<!-- パンくずリストを表示 -->
	<ol class="breadcrumb" itemscope itemtype="https://schema.org/BreadcrumbList">
  		<li itemprop="itemListElement" itemscope　itemtype="https://schema.org/ListItem">
      		<a itemprop="item" href="Main">
        		<span itemprop="name">ホーム</span></a>
      		<meta itemprop="position" content="1" />
  		</li>
  	<!-- 2つめ -->
  		<li itemprop="itemListElement" itemscope　itemtype="https://schema.org/ListItem">
      		<a itemprop="item" href="StockList">
       	 	<span itemprop="name">ストックリスト</span></a>
     		 <meta itemprop="position" content="2" />
  		</li>
	</ol>
	<h1 class="center formTitle">ストックリスト</h1>
	<!-- ストックリストを表示 -->
	<div class="center outerBorder" id="list">
		<c:choose>
    	<c:when test="${not empty stockList}">
    	<!-- ストックリストが空でない場合 -->
        	<form action="Consume" method="post">
            <ul>
                <c:forEach items="${stockList}" var="item">
                    <li>
                    <!-- 商品名と店舗を表示 -->
                    <input type="checkbox" name="selectedItems" value="${item.getQuantity()}-${item.getProduct_name()}-${item.getUser_id()}" onclick="checkIfAnyCheckboxChecked();" /> 
                    ${item.getProduct_name()}<c:if test="${not empty item.getStore()}">: ${item.getStore()}</c:if> 
                    <!-- QUANTITYを非表示のinputフィールドとして渡す -->
                    <input type="hidden" name="quantities" value="${item.getQuantity()}" />
                    </li>
                </c:forEach>
            </ul>
            <input class="center" type="submit" value="消費" />
        	</form>
    	</c:when>
    	<c:otherwise>
    	<!-- ストックリストが空の場合 -->
    		<img src="<c:url value='/images/emptyList.png' />" alt="ストックリストは空です">
        </c:otherwise>
        </c:choose>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
<script src="javaScript/checkList.js"></script>
<script src="javaScript/checkbox.js"></script>
</html>