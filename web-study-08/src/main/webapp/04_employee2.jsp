<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "ezen";
	String password = "1234";
	String sql = "select* from employee";
	
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
<table border="1" width="500">
	<tr>
		<th>이름</th><th>주소</th><th>ssn</th>
	</tr>
<%
	try{
	 	
		//1. 드라이브 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. DB연결
		con = DriverManager.getConnection(url, username, password);
		
		//3. sql구문 전송
		pstmt = con.prepareStatement(sql);
		
		//5. 실행
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			out.println("<tr>");
			out.println("<td>"+rs.getString("name") +"</td>");
	         out.println("<td>"+rs.getString("address") +"</td>");
	         out.println("<td>"+rs.getString("ssn") +"</td>");
			out.println("</tr>");
		}
		
		
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
</table>
</body>
</html>