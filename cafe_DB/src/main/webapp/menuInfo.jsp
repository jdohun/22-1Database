<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>		<!-- 리스트 형태로 -->
<%@ page import="vo.CafeOptionVO" %>			<!-- 메뉴 옵션을 받아옴 -->
<%@ page import="vo.CafeMenuVO" %>				<!-- 카페메뉴를 받아옴 -->
<%@ page import="java.text.DecimalFormat" %>	<!-- 숫자 자동 콤마처리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 자세히</title>
</head>
<%	
	ArrayList<CafeOptionVO> List = (ArrayList<CafeOptionVO>)request.getAttribute("List");
	CafeMenuVO menu = (CafeMenuVO)request.getAttribute("menu");
	DecimalFormat commas = new DecimalFormat("###,###");
%>
<body>
<!-- header -->
<header>
	
</header>
<!--main-->
<div id="Container">
	<div class="contents">
	<!-- 
		<div class="titleArea">
			<h3 style="margin-top: 100px;margin-bottom: 30px;font-size: 30px;">MAIN</h3>
		</div>
	 -->
		<div id="OptionList">
			<%
				if(!List.isEmpty()){
					String smPrice = commas.format(menu.getmPrice());
					
					ArrayList<CafeOptionVO> required = new ArrayList<CafeOptionVO>();
					ArrayList<CafeOptionVO> noRequired = new ArrayList<CafeOptionVO>();
					for(int i = 0; i < List.size(); ++i){
						CafeOptionVO option = List.get(i);
						if(option.getRequired().equals("Y")){
							required.add(option);
							
						}
						else{
							noRequired.add(option);	
						}
					}
			%>
			<div id=menu>
				<input type="hidden" name="menuPrice" value=<%=menu.getmPrice() %>>
				<p><%=menu.getmName() %></p>
				<p><%=smPrice %></p>
			</div>
			<table>
				<thead>
					<tr>
						<td>필수</td>
					</tr>
				</thead>
				<tbody>
					<%
						for(int i =0; i< required.size(); ++i){
							CafeOptionVO option = required.get(i);
							int iPrice = option.getOpPrice();
							String sOpPrice = commas.format(iPrice);
					%>
					<tr>
						<td>
							<input type="radio" name="required" required="required" value=<%=option.getOpName() %> onclick="checkSelected()" >
							<input type="hidden" value=<%=iPrice %>>
						</td>
						<td>
							<p class="menuInfo"><%=option.getOpName() %> </p>
						</td>
						<td>
							<p class="price"><%=sOpPrice %></p>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<table>
				<thead>
					<tr>
						<td>
							선택
						</td>
					</tr>
				</thead>
				<tbody>
				<%			
				for(int i = 0; i < noRequired.size(); ++i){
					CafeOptionVO option = noRequired.get(i);
					int iPrice = option.getOpPrice();
					String sOpPrice = commas.format(iPrice);
				%>
				<tr>
					<td>
						<input type="checkbox" class="optionChk" name="optionChk" value=<%=option.getOpName() %> onclick="checkSelected()" >
						<input type="hidden" value=<%=iPrice %>>
					</td>
					<td>
						<p class="menuInfo"><%=option.getOpName() %> </p>
					</td>
					<td>
						<p class="price"><%=sOpPrice %></p>
					</td>
				</tr>	
				<%
				}
				%>			
				</tbody>
			</table>	
				<%
				}
				else{
					String msg = (String)request.getAttribute("msg");
				%>
					<p>등록된 상품이 없습니다.</p>
				<%
				}
			%>
		</div>
		<p id="showPrice"><%=menu.getmPrice() %></p>
		<form action="./addToCart.do" method="get">
			<input type="hidden" id="menu" name="menu" value=<%=menu.getmNum() %>>
			<input type="hidden" id="selectedOption" name="selectedOption">
			<input type="hidden" id="sumPrice" name="sumPrice">
			<input type="submit" class="" value="메뉴 담기">
		</form>
	</div>
</div>
<!--/main-->
</body>
<script defer src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script defer src="js/cart.js"></script>
<script type="text/javascript">
	let checkSelected = function(){	// 전체 선택, 해제
		let chkArr = [];
		// 메뉴 총 가격을 메뉴 가격으로 초기화
		let sumPrice = parseInt($("input[name='menuPrice']")[0].value);
		// 선택된 옵션
		let selectedOption;
		// 필수 중에서 체크 된 체크박스
		let required = $("input[name='required']:checked");
		// 선택 중에서 체크 된 체크박스 
		let checked = $("input[name='optionChk']:checked");
				
		// 필수 옵션 추가
		selectedOption = required[0].value;
		
		// 선택 옵션 추가
		for(let i = 0; i<checked.length; ++i){
			selectedOption += "," + checked[i].value;
			// 추가 가격 포함
			sumPrice += parseInt(checked[i].parentNode.childNodes[3].value);
		}
		
		$("#selectedOption").val(selectedOption);
		$("#sumPrice").val(sumPrice);
		console.log($("#showPrice")[0].innerHTML);
		$("#showPrice")[0].innerText = sumPrice+'원';
	};

</script>
</html>