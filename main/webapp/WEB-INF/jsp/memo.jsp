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
	<h1>メモ一覧</h1>
	<c:forEach var="memo" items="${memoList}">
		<hr/>
		<div><c:out value="${memo.title}" /></div>
		<div><c:out value="${memo.modified_date}" /></div>
		<div><c:out value="${memo.memo}" /></div>
	</c:forEach><br>
	<a href="Main">ホームへ戻る</a>
</body>
</html>