<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>メモウェブ</title>
</head>
<body>
	<h1>メモウェブHOME</h1>
	<p>
		<c:out value="${loginUser.userId}" />さん、こんにちは
		<a href="MemoServlet">メモ一覧へ</a>
	</p>
	<c:if test="${not empty errorMessage}">
    	<p style="color:red" class="error">${errorMessage}</p>
	</c:if>
	<p>
	 	<form action="Main" method="post">
  			<input type="text" name="title" size="50"/>
  			<br/>
  			<textarea rows="5" cols="80" name="memo"></textarea>
  			<br/>
  			<input type="submit"/>
 		</form>
 	</p>
	<a href="LogoutServlet">ログアウト</a>
	<a href="SecessionServlet">退会</a><br>
</body>
</html>