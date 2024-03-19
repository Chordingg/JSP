package com.project.controller.action;

public class ActionFactory {
	
	private ActionFactory () {}
	
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("user_login")) {
			action = new UserLoginAction();
		}else if (command.equals("user_join")) {
			action = new UserJoinAction();
		}
		return action;
	}

}
