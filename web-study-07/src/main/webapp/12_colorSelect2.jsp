<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${param.color==1}">
	<h1 style="color: red;">빨강1</h1>
</c:if>

<c:if test="${param.color==2}">
	<h1 style="color: blue;">파랑1</h1>
</c:if>

<c:if test="${param.color==3}">
	<h1 style="color: yellow;">노랑1</h1>
</c:if>
 
<c:choose>  <!-- java의 case문 -->
	<c:when test="${param.color==1}">
	<h1 style="color: red;">빨강2</h1>
	</c:when>
	
	<c:when test="${param.color==2}">
	<h1 style="color: blue;">파랑2</h1>
	</c:when>
	
	<c:otherwise>
		<h1 style="color: yellow;">노랑2</h1>
	</c:otherwise>
</c:choose>
	
</body>
</html>