package kr.or.ddit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class userListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "/userLst.jsp";
	}

}
