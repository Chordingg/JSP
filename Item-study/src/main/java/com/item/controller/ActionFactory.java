package com.item.controller;

import com.item.controller.action.Action;

public class ActionFactory {
	
	private ActionFactory () {}
	
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance () {
		return instance;
	}
	
	public Action getAction(String command) {
		
		Action action = null;
		
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("item_list")) {
			action = new ItemListAction();
		}
		
		return action;
	}

}
