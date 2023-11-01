<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>お買い物リスト</title>
    <link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=philosopher">
	<link rel="stylesheet" href="css/style.css"> 
</head>
<body>
	<div class="wrapper">
		<article>
			<jsp:include page="header.jsp"/>
		</article>
		<aside id="addShoppingButton">
			<a href="AddShoppingList"><img class="shoppingList" src="<c:url value='/images/addShoppingList.png' />" alt="お買い物リストに追加"></a>
		</aside>
	</div>
	<h1 class="container">お買い物リスト</h1>
	<!-- お買い物リストを表示 -->
	<div class="shoppingList wrapper">
    	<c:if test="${not empty shoppingList}">
        	<form action="CompleteShopping" method="post">
            <ul>
                <c:forEach items="${shoppingList}" var="item">
                    <li>
                    <!-- 商品名と店舗を表示 -->
                    <input type="checkbox" name="selectedItems" value="${item.getQuantity()}-${item.getProduct_name()}-${item.getUser_id()}" onclick="checkIfAnyCheckboxChecked();" /> 
                    ${item.getProduct_name()} : ${item.getStore()} 
                    <!-- QUANTITYを非表示のinputフィールドとして渡す -->
                    <input type="hidden" name="quantities" value="${item.getQuantity()}" />
                    </li>
                </c:forEach>
            </ul>
            <input type="submit" value="お買い物完了" />
            
        	</form>
    	</c:if>
	</div>
</body>
<script src="javaScript/checkbox.js"></script>
</html>