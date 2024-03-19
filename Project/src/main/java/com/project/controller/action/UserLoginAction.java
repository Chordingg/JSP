package com.project.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.UserDAO;
import com.project.dto.UserVO;

public class UserLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String url = "member/login.jsp";
		
		UserDAO mDao = UserDAO.getInstance();
		
		List<UserVO> list = mDao.selectAllUserAction();
		
		request.setAttribute("login", list);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
