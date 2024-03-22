package com.saeyan.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.BoardVO;

import util.DBManager;

public class BoardDAO {
	private BoardDAO() {}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	public List<BoardVO> selectAllBoards(){
		
		String sql = "select* from board";
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
			BoardVO vo = new BoardVO();
			vo.setNum(rs.getInt("num"));
			vo.setName(rs.getString("name"));
			vo.setPass(rs.getString("pass"));
			vo.setEmail(rs.getString("email"));
			vo.setTitle(rs.getString("title"));
			vo.setContent(rs.getString("content"));
			vo.setReadcount(rs.getInt("readcount"));
			vo.setWritedate(rs.getTimestamp("writedate"));
			
			list.add(vo);
			
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(rs, stmt, conn);
			}
		
		return list;
	}
	
	// 전달인자로 받은 VO 객체를 board 테이블에 삽입한다.
	public void insertBoard(BoardVO vo) {
		
	}
	
	public void updateReadCount(String nume) {
		
	}
	
	// 게시판 글 상세 내용 보기
	public BoardVO selectOneBoardByNum(String num) {
		return null;
	}
	
	public void updateBoard(BoardVO vo) {
		
	}

	public BoardVO checkPassWord(String name, String pass) {
		return null;
	}
	
	public void deleteBoard(String num) {
		
	}

}
