<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/product.js"></script>

<title>Insert title here</title>
</head>
<body>
	<div id="wrap" align="center">
		<h1>게시글 상세보기</h1>
		<table>
			<tr>
				<th>상 품 명</th>
				<td>${pro.pname}</td>

			</tr>
			<tr>
				<th>내 용</th>
				<td>${pro.content}</td>
			</tr>
			<tr>
				<th>가 격</th>
				<td>${pro.price}</td>
			</tr>
			<tr>
				<th>수 량</th>
				<td>${pro.stock }</td>
			</tr>
			<tr>
				<th>사 진</th>
				<td><img
					src="${pageContext.request.contextPath}/upload/${pro.img}"
					alt="상품 이미지"></td>
		</table>
		<br> <br> <input type="button" value="상품 수정"
			onclick="open_win('ProServlet?command=pro_check_pass_form&pid=${pro.pid}', 'update')">
		<input type="button" value="상품 삭제"
			onclick="open_win('ProServlet?command=pro_check_pass_form&pid=${pro.pid}', 'delete')">
		<input type="button" value="상품 리스트"
			onclick="location.href='ProServlet?command=pro_list'"> <input
			type="button" value="상품 등록"
			onclick="location.href='ProServlet?command=pro_write_form'">
	</div>
</body>
</html>