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
<form action="08_itemWriteResult" method="get">
	상품명 <input type="text" name="name"><br>
	가격 &nbsp&nbsp  <input type="text" name="prcie"><br>
	설명 &nbsp&nbsp  <input type="text" name="description" width="800px" height="500px"><br>
	<input type="submit" value="전송">
	<input type="reset" value="취소">
</form>

</body>
</html>