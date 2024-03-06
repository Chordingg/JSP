<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String username = "ezen";
	String password = "1234";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String sql = "select* from item";
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>입력 완료된 정보</h2>
<%
	try{
		
		//1. 드라이브 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. DB 연결
		con = DriverManager.getConnection(url);
		
		//3. sql구문 전송
		pstmt = con.prepareStatement(sql);
		
		//4. 실행
		
		rs = pstmt.executeQuery();
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

%>
</body>
</html>