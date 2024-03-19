<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/login.css">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" method="post" action="MainServlet">
		<div class="box">
			<input type="email" placeholder="Email" /> <input type="password" placeholder="Password" /> 
			<input type="submit" value="회원가입" />Sign in

			<div class="sign-up-box">
				<i class="material-icons"></i>
			</div>
		</div>
	</form>
</body>
</html>