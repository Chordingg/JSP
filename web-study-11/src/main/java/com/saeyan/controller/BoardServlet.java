package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;

@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	// BoardServlet?command=board_list => 요청이 전달됨
	// BoardServlet?command=board_view&num=${board.num}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
											 //board_list
		String command = request.getParameter("command");
		
		ActionFactory af = ActionFactory.getInstance();
		
		Action action = af.getAction(command);
		
		if (action != null) {
			action.execute(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}