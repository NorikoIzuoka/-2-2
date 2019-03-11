<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
//スコープからデータを受け取る、キャストする必要がある
String mes = (String)session.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
結果：
<%=mes %><br>
	<a href="index.jsp">トップページへ</a>

</body>
</html>