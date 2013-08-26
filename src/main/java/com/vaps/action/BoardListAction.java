package com.vaps.action;

import java.util.List;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.vaps.bean.BoardList;
import com.vaps.dao.MembersDAO;

public class BoardListAction {
	MembersDAO dao;
	
	public BoardListAction(MembersDAO membersDao){
		this.dao = membersDao;
	}
	
	public List<BoardList> getBoardList(int pageNum){
		return dao.getBoardList(pageNum); //sqlMapper.xml 갔다옴
	}
	

	public BoardList getContents(int bNum) {
		// TODO Auto-generated method stub
		return dao.getContents(bNum);
	}


}
