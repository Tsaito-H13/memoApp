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
<h1>メモウェブ退会</h1>
<c:if test="${not empty errorMessage}">
    <p class="error">${errorMessage}</p>
</c:if>
<form action="SecessionServlet" method="post">
ユーザーID:<input type="text" name="userId"><br>
パスワード:<input type="password" name="pass"><br>
<input type="submit" value="退会"><br>
<a href="Main">キャンセル</a><br>
</form>
</body>
</html>