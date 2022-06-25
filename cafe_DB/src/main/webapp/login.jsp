<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content=width-device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>로그인</title>
</head>
<body>
<div id="Container">
	<div class="contents">
		<div class="titleArea">
			<h3>LOGIN</h3>
		</div>
		<form class="login" method="post" action="login.do">
			<div>
				<ul>
					<li><input type="text" name="userPhoneNumber" id="userPhoneNumber" placeholder="전화번호" autofocus></li>
				</ul>
			</div>
			<input type="submit" id="login" value="LOGIN"><br>
		</form>
	</div>
</div>
</body>
</html>
