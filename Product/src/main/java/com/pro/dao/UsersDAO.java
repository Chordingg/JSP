package com.pro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.pro.dto.UsersVO;

public class UsersDAO {

	private UsersDAO() {
	}

	private static UsersDAO instance = new UsersDAO();

	public static UsersDAO getInstance() {

		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
	
	private void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void close(Connection conn, Statement stmt) {
		try {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//전체데이타 가져오기
		public List<UsersVO> selectAllUsers(){
			List<UsersVO> list  = new ArrayList<UsersVO>();
			
			String sql = "select * from users";
			
			try{
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					UsersVO vo  = new UsersVO();
					vo.setNum(rs.getInt("num"));
					vo.setId(rs.getString("id"));
					vo.setUsername(rs.getString("username"));
					vo.setEmail(rs.getString("email"));
					vo.setPass(rs.getString("password"));
					vo.setRegistration_date(rs.getDate("registration_date"));
					vo.setIs_admin(rs.getString("is_admin"));
					
					list.add(vo);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(conn, pstmt, rs);
			}
			return list;
		}
		
		//ID중복체크 
		public int confirmID(String id) {
			
			int result = -1;
			
			String sql = "select id from users where id = ?";
			
			try {
				
				//1. 연결
				conn = getConnection();
				//2. sql문 전송
				pstmt = conn.prepareStatement(sql);
				//3. 맵핑
				pstmt.setString(1, id);
				//4. 실행 및 결과값 받기
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = 1;  //ID 사용가능
				}else {
					result  = -1; //ID 중복 사용 불가
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(conn, pstmt, rs);
				}
			return result;
		}
		
		//회원가입
		public int insertMember(UsersVO vo) {
			int result = -1;
			
			String sql = "insert into users values(?,?,?,?,?,?,?)";
			
			try {
				//1. 연결
				conn = getConnection();
				//2. sql 구문 전송
				pstmt = conn.prepareStatement(sql);
				//3. 맵핑
				
				pstmt.setInt(1, vo.getNum());
				pstmt.setString(2, vo.getId());
				pstmt.setString(3, vo.getUsername());
				pstmt.setString(4, vo.getEmail());
				pstmt.setString(5, vo.getPass());
				pstmt.setDate(6, vo.getRegistration_date());
				pstmt.setString(7, vo.getIs_admin());
				
				//4. 구문실행
				result = pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return result;
		}
	
	

}
