<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userId = "ezen";
	String password = "1234";
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
<table width=500; border="1">

	<%
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection(url, userId, password);
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
		while(rs.next()){
			out.println("<tr>");
			out.println("<td>" + rs.getString("name") + "</td>");
			out.println("<td>" + rs.getInt("price") + "</td>");
			out.println("<td>" + rs.getString("description") + "</td>");
			out.println("</tr>");
		}
			
		}catch(Exception e) {
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
</table>	
</body>
</html>