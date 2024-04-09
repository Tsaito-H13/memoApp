<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メモウェブ</title>
</head>
<body>
<h1>ログイン</h1>
<form action="LoginServlet" method="post">
ユーザーID：<input type="text" name="userId" required><br>
パスワード：<input type="password" name="pass" required><br>
<input type="submit" value="ログイン">
</form>
<a href="index.jsp">▶トップへ</a>
</body>
</html>