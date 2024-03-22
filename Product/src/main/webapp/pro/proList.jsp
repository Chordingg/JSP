<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<title>상품 관리</title>
</head>
<body>
	<div id="wrap" align="center">
		<h1>상품 리스트 - 관리자 페이지</h1>
		<table class="list">
			<tr>
				<td colspan="5" style="border:whire; text-align:right">
					<a href="ProServlet?command=pro_write_form">상품 등록</a>
				</td>
			</tr>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>가격</th>
				<th>이미지</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="pro" items="${proList }">
				<tr class="record">
					<td>${pro.pid }</td>
					<td><a href="ProServlet?command=pro_view&pid=${pro.pid}">${pro.pname }</a></td>
					<td>${pro.price }</td>
					<td><img src="upload/${pro.img }" alt="Product Image" width="100" height="100"></td>
					<td><a href="ProServlet?command=pro_update_form">상품 수정</a></td>
					<td><a href="ProServlet?command=pro_delete_form">상품 삭제</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>