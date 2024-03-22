package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String url = null;
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		BoardDAO bDao = BoardDAO.getInstance();
		
		BoardVO vo = bDao.selectOneBoardByNum(num);
	}

}
