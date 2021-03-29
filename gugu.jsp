<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-bordered table-hover">
<tr>
<% for(int i=2;i<=9;i++){%>
<td><%=i%>단</td>
<% }%>
</tr>
<tr>
<% for(int i=1;i<=9;i++){%>
<tr>
	<%for(int j=2;j<=9;j++){ %>
<td><%=j%>X<%=i%>=<%=i*j %></td>
	<%}%>
</tr>
<%}%>
</tr>
</table>
</body>
</html>