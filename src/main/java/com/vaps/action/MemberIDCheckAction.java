package com.vaps.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.Action;

import com.vaps.dao.MembersDAO;

public abstract class MemberIDCheckAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		ActionForward forward=new ActionForward();
		String id=request.getParameter("id");
		MembersDAO membersdao=new MembersDAO();
		int check=membersdao.confirmId(id);	
		request.setAttribute("id", id);
		request.setAttribute("check", check);
		forward.setPath("./member_idchk.jsp"); 			
		return forward;
	}
}