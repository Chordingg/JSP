package com.project.controller;

import com.project.controller.action.Action;
import com.project.controller.action.LoginAction;
import com.project.controller.action.LogoutAction;
import com.project.controller.action.MainAction;
import com.project.controller.action.RegisterAction;

public class ActionFactory {
	
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory () {}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("main")){
			action = new MainAction();
		}else if(command.equals("user_login")) {
			action = new LoginAction();
		}else if (command.equals("user_register")) {
			action = new RegisterAction();
		}else if (command.equals("user_logout")) {
			action = new LogoutAction();
		}
		return action;
	}

}
