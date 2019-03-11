<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="index.Person" %>
<%
//スコープからデータを受け取る、キャストする必要がある
ArrayList<Person> list = (ArrayList<Person>)session.getAttribute("itiran");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr><td>id</td><td>名前</td><td>価格</td><td colspan="2">操作</td></tr>
		<%for (int i = 0; i < list.size(); i++) {	%>
		<tr>
				<td>No.<%=list.get(i).id %></td>
				<td><%=list.get(i).name %>さん</td>
		        <td><%=list.get(i).age%>さい</td>
		        <td><a href="">変更</a></td>
		        <td><a href="">削除</a></td>
		 </tr>
		<%}	%>
	</table>
	<a href="index.jsp">トップページへ</a>
</body>
</html>
