<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>정보 입력 폼</h2>
	<form method="get" action="itemWrite.do">
		<table>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="item"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>설명</td>
				<td><textarea rows="10" cols="60"></textarea></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="전송">				
					<input type="reset" value="취소">				
				</td>
			</tr>
		</table>
	</form>
</body>
</html>