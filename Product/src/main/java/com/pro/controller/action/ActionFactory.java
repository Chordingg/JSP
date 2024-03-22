package com.pro.controller.action;

public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {}

	public static ActionFactory getInstance() {
		
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("pro_list")) {
			action = new ProListAction();
		}else if(command.equals("pro_write_form")) {
			action = new ProWriteActionForm();
		}else if(command.equals("pro_write")) {
			action = new ProWriteAction();
		}else if(command.equals("pro_view")) {
			action = new ProViewAction();
		}
		
		// 메인화면
		//else if(command.equals("main")) {
			//action = new MainAction();
		//}
		
		// 전체 회원 보기
		else if(command.equals("users_list")) {
			action = new UsersListAction();
			
		// 회원가입
		}else if(command.equals("users_join_form")) {
			action = new UsersJoinAction();
		}else if(command.equals("users_join")) {
			action = new UsersJoinAction();
		}
		
		return action;
	};

}
