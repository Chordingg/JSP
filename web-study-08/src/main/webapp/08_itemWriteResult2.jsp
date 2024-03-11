<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userId = "ezen";
	String password = "1234";
	String sql = "insert into item values (?,?,?)";

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
<table>
	<tr>
		<td></td>
	</tr>
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String price = request.getParameter("price");
	String description = request.getParameter("dercription");

	try{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection(url, userId, password);
		
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		pstmt.setString(1, name);
		pstmt.setInt(2, Integer.parseInt("price"));
		pstmt.setString(3, description);
		
		pstmt.executeUpdate();
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
%>
</table>
<a href="08_itemWrite2.jsp">결과 보기</a>
</body>
</html>