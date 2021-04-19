<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.gsm.model.*" %>   
<%
        List<MemberVO> list=(List<MemberVO>)request.getAttribute("list");
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
  <script type="text/javascript">
      // jQuery API(*)
     function goInput() {
		  location.href="member/memberRegister.html";
	 }
      function goDel(num){
    	  location.href="/m42/memberDelete.do?num="+num;
      }
      function goView(num){
    	  location.href="/m42/memberContent.do?num="+num;
      }
  </script>
</head>
<body>
- 회원리스트-
<table class="table table-hover table-bordered">
   <tr>
     <td>번호</td>
     <td>아이디</td>
     <td>비밀번호</td>
     <td>이름</td>
     <td>나이</td>
     <td>전화번호</td>
     <td>이메일</td>
     <td>삭제</td>
    </tr>
   <% for(MemberVO vo :  list) {%>
	 <tr>
	     <td><%=vo.getNum()%></td>
	     <td><a href="javascript:goView( <%=vo.getNum()%>)"><%=vo.getId()%></a></td>
	     <td><%=vo.getPass() %></td>
	     <td><%=vo.getName()%></td>
	     <td><%=vo.getAge()%></td>
	     <td><%=vo.getPhone()%></td>
	     <td><%=vo.getEmail()%></td>
	     <td><input type="button" value="삭제"  class="btn btn-warning" onclick="goDel(<%=vo.getNum()%>)"/></td>
	   </tr>
	 <% } %>
	 <tr>
	   <td colspan="8" align="right">
	       <input type="button" value="회원가입" class="btn btn-primary"   onclick="goInput()"/>
	   </td>
	 </tr>
</table>
</body>
</html>