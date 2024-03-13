<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/movies.css">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap" align="center">
		<h2>리스트</h2>
		<table class="list">
			<td colspan="6" style="border: white; text-align: right;">
				<a href="movieWriter.do">정보등록</a>
			</td>
			<tr>
				<th>제목</th>
				<th>감독</th>
				<th>배우</th>
				<th>가격</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
			<tr>
				<td>John</td>
				<td>Doe</td>
				<td>john@example.com</td>
			</tr>
		</table>
	</div>
</body>
</html>