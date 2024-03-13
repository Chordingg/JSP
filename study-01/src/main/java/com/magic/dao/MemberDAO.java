package com.magic.dao;

public class MemberDAO {
	
	public static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {}
	
	public static MemberDAO getMemberDAO () {
		
		return instance;
	}

}
