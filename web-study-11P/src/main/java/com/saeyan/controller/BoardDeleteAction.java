package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.BoardDAO;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	String num = request.getParameter("num");
	BoardDAO bDao = BoardDAO.getInstance();
	
	bDao.deleteBoard(num);
	
	new BoardListAction().execute(request, response);
	}

}
