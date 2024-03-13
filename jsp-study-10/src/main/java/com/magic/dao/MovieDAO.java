package com.magic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.magic.dto.MovieVO;

import util.DBManager;

public class MovieDAO {
	
	private static MovieDAO instance = new MovieDAO();
	
	private MovieDAO() {}
	
	public static MovieDAO getInstance() {
		return instance;
	}
	
	// 전체 리스트 가져오기
	public List<MovieVO> movieList() {
		List<MovieVO> list = new ArrayList<MovieVO>();
		String sql = "select* from movie";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MovieVO vo = new MovieVO();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(rs, pstmt, con);
		}
		
		
		return null;
	}
	
	// 한 영화 가져오기
	public MovieVO getOneMovie(int code) {
		return null;
	}
	
	// 영화 수정하기
	public void updateMovie(MovieVO vo) {
		
	}
	
	// 영화 저장하기
	public void insertMovie(MovieVO vo) {
		
	}
	
	// 영화 삭제하기
	public void deleteMovie(int code) {
		
	}

}
