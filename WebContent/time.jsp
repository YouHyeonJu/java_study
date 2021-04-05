<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //java.util.Date d=new java.util.Date();
    // 1~100까지의 총합=?
    kr.mem.util.MyUtil my=new kr.mem.util.MyUtil();
    int sum=my.hap();
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
  <td>1~100까지의 총합</td>
  <td><%=sum%></td>
</tr>
</table>
</body>
</html>