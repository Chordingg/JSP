package com.pro.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.dao.UsersDAO;
import com.pro.dto.UsersVO;

public class UsersListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String url = "users/usersList.jsp";
		
		UsersDAO dao = UsersDAO.getInstance();
		
		List<UsersVO> list = dao.selectAllUsers();
		
		request.setAttribute("usersList", list);
		
		request.getRequestDispatcher(url).forward(request, response);
		//System.out.println("vo" + list);
	
	}

}
