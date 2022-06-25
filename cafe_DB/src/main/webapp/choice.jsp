<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.MembershipVO" %>					<!-- 멤버십회원을 받아옴 -->    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%	
	MembershipVO user = (MembershipVO)request.getSession().getAttribute("userPhoneNumber");
%>
<body>
<div id="container">
	<%
		if(user != null){
	%>
	<p><%=user.getMemberName() %></p>
	<%
		}
	%>
	<form action="./login.jsp" method="get">
		<input type="submit" value="멤버십 로그인">
	</form>
	<form action="./order.do" method="get">
		<input type="submit" value="바로 주문하기">
	</form>
</div>
</body>
</html>