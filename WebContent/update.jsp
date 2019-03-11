<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String id=request.getParameter("id");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
変更するID:<%=id%><br>
<from action="UpdateServlet"method="POST">
ID<input type="hidden"name="id"value=<%=id %>"><br>
名前<input type="text"name="name"><br>
年齢<input type="text"name="age"><br>
<input type="submit"value="変更">
</from>
</body>
</html>