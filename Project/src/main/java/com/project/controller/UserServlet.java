package com.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.controller.action.Action;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// BoardServlet?command=user_login => 요청이 전달됨
		String command = request.getParameter("command");
		
		System.out.println("UserServlet에서 요청 받음을 확인 : " + command);
		
		ActionFactory af = ActionFactory.getInstance();
		
		Action action = af.getAction(command);
		
		// 아직 모델을 만들지 않아서 ActionFactory가 null 값을 갖는 액션을 반환하기 때문에 예외가 발생
		if(action != null) {
			action.execute(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
