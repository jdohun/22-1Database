<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>		<!-- 리스트 형태로 -->
<%@ page import="vo.CafeMenuVO" %>				<!-- 카페메뉴를 받아옴 -->
<%@ page import="java.text.DecimalFormat" %>	<!-- 숫자 자동 콤마처리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문하기</title>
</head>
<%	
	ArrayList<CafeMenuVO> List = (ArrayList<CafeMenuVO>)request.getAttribute("List");
	DecimalFormat commas = new DecimalFormat("###,###");
%>
<body>
<!-- header -->
<header>
	<button onclick="location.href='goHome.do'">홈</button>
	<button class="cart" onclick="window.open('showCart.do', 'cart', 'width=430, height=600, location=no, status=no, scrollbars=yes');">장바구니</button>
</header>
<!--main-->
<div id="Container">
	<div class="contents">
		<div class="titleArea">
			<h3 style="margin-top: 100px;margin-bottom: 30px;font-size: 30px;">MAIN</h3>
		</div>
		<div class="itemList">
			<ul>
				<%
					if(!List.isEmpty()){
						for(int i = 0; i < List.size(); ++i){
							CafeMenuVO menu = List.get(i);
							int iPrice = menu.getmPrice();
							String sPrice = commas.format(iPrice);
				%>
				<!-- <button value=<%=menu.getmName() %> onclick="window.open('detail.do?category=<%=menu.getCategory() %>')"> -->
				<li>
					<div class="menubox">
						<button class="menus" onclick="window.open('menuInfo.do?mNum=<%=menu.getmNum() %>', 'menuInfo', 'width=430, height=600, location=no, status=no, scrollbars=yes');">
							<p class="menuCategory"><%=menu.getCategory() %> </p>
							<p class="menuInfo"><%=menu.getmName() %> </p>
							<p class="price"><%=sPrice %></p>
						</button>
					</div>
				</li>
				<%
						}
					}
					else{
						String msg = (String)request.getAttribute("msg");
					%>
						<p>등록된 상품이 없습니다.</p>
					<%	
					}
				%>
			</ul>
		</div>
	</div>
</div>
<!--/main-->
</body>
</html>