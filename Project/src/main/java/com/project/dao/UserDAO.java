package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.dto.UserVO;

import util.DBManager;

public class UserDAO {
	
	private static UserDAO instance = new UserDAO();
	
	private UserDAO () {}
	
	public static UserDAO getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public List<UserVO> selectAllUserAction(){
		
		List<UserVO> list = new ArrayList<UserVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from user";
				
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UserVO vo = new UserVO();
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("password"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAdmin(rs.getInt("admin"));
				
				list.add(vo);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(rs, pstmt, conn);
		}
				
		return list;	
	}
	
	public int userCheckAction(String userid, String pwd) {
		int result = -1;
		
		String sql = "select pwd from member where userid = ? ";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("pwd").equals(pwd)) {
					result = 1; // 아이디 /비밀번호 일치
				}else {
					result = -1; //비빌번호 불일치
				}
			}else {
				result = 0; //아이디 불일치
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
}
