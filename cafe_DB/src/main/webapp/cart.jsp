<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>		<!-- 리스트 형태로 -->
<%@ page import="vo.CartVO" %>					<!-- 장바구니를 받아옴 -->
<%@ page import="java.text.DecimalFormat" %>	<!-- 숫자 자동 콤마처리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<style>
	table > * > * {
		border: solid 1px black;
	}
</style>
</head>
<%	
	String userPhoneNumber = (String)request.getSession().getAttribute("userPhoneNumber");
	ArrayList<CartVO> List = (ArrayList<CartVO>)request.getAttribute("List");
	DecimalFormat commas = new DecimalFormat("###,###");
%>
<body>
<div id="container">
	<table style="border:solid 1px black">
		<thead>
			<tr>
				<td>메뉴</td>
				<td>선택한 옵션</td>
				<td>수량</td>
				<td>가격</td>
			</tr>
		</thead>
		<tbody>
		<%
		if(!List.isEmpty()){
			int totalPrice = 0;
			for(int i = 0; i < List.size(); ++i){
				CartVO cmenu = List.get(i);
				int iPrice = cmenu.getcPrice();
				totalPrice += iPrice;
				String sPrice = commas.format(iPrice);
			
		%>
			<tr>
				<td>
					<%=cmenu.getmName() %>
				</td>
				<td>
					<%=cmenu.getcOptions() %>
				</td>
				<td>
					<%=cmenu.getcQuantity() %>
				</td>
				<td>
					<%=cmenu.getcPrice() %>
				</td>
				<td>
					
				</td>
			</tr>
		<%
			}
		%>
		</tbody>
		<tfoot>	
			<tr>
				<td>
					총 가격 : <%=totalPrice %>
				</td>
			</tr>
		</tfoot>
	</table>
	<%
		}
	%>
	<%
		
	%>
	<form action="./choice.jsp" method="get">
		<input type="submit" value="주문하기">
	</form>
</div>
</body>
</html>