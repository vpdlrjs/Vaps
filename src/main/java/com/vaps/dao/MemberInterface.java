package com.vaps.dao;

import java.util.List;
import java.util.Map;

import com.vaps.bean.BoardList;
import com.vaps.bean.Members;


public interface MemberInterface {
	public int getLoginResult(Map<String, String> map);
	public Members getMemberInfo(String id);
	public List<BoardList> getBoardList(int pageNum);
	public int getPageCount();
	public BoardList getContents(int bnum);
	public int memInsert(Members mb);
}
