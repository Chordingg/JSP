<%@page import="java.text.CollationKey"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie cookie = new Cookie("id","");
	cookie.setMaxAge(0);
	
	response.addCookie(cookie);
	
	cookie = new Cookie("age","20");
	cookie.setMaxAge(0);
	response.addCookie(cookie);
	
%>
</body>
</html>