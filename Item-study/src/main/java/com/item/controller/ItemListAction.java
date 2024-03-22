package com.item.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.item.controller.action.Action;
import com.item.dao.ItemDAO;
import com.item.dto.ItemVO;

public class ItemListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String url = "item/item_list.jsp";
		
		ItemDAO iDao = ItemDAO.getInstance();
		
		List<ItemVO> list = iDao.viewAllItems();
		
		request.setAttribute("itemList", list);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
