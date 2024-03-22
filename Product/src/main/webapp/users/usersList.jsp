<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<title>Insert title here</title>
</head>
<body>
<div id="wrap" align="center">
		<h1>회원 리스트</h1>
		<table class="list">
			<tr>
				<td colspan="5" style="border: white; text-align: right">
				   <a href="ProServlet?command=users_join_form">회원 등록</a>
				</td>
			</tr>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>닉네임</th>
				<th>이메일</th>
				<th>비밀번호</th>
				<th>날짜</th>
				<th>관리자</th>
			</tr>
			<c:forEach var="users" items="${usersList}">
				<tr class="record">
					<td>${users.num }</td>
					<td>${users.id}</td>
					<td>${users.username}</td>
					<td>${users.email}</td>
					<td>${users.pass}</td>
					<td><fmt:formatDate value="${users.registration_date }" pattern="yyyy-MM-dd" /></td>
					<td>${users.is_admin}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>